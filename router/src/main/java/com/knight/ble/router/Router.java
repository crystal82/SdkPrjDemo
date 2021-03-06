package com.knight.ble.router;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import com.knight.ble.router.annotation.IntentCombineUri;
import com.knight.ble.router.annotation.IntentExactHostUri;
import com.knight.ble.router.annotation.ParamActionDescribe;
import com.knight.ble.router.annotation.ParamIntentExtrasData;

/**
 * 作者： hwq
 * 创建时间：2018/3/21 0:44
 * 描述：通过路由方式解析传入接口方法中的注解，获取Activity隐式跳转相关参数
 * 相关注解有：
 * IntentUri
 */

public class Router {

    Context context;

    public Router(Context context) {
        this.context = context;
    }

    @SuppressWarnings("unchecked")
    public <T> T createService(Class<T> tClass) {
        return (T) Proxy.newProxyInstance(
                tClass.getClassLoader(),
                new Class[]{tClass},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args)
                            throws
                                                                                     Throwable {

                        //解析Method注解,拼接uri
                        StringBuilder uriBuild = analysisMethod(method);

                        //将args中的数据取出，保存到bundle
                        Bundle bundle = analysisParams(uriBuild, method, args);

                        //进行跳转
                        jumpToActivity(uriBuild.toString(), bundle);
                        return null;
                    }
                });
    }

    //组合规则：<scheme>://<host>:<port>/<path>
    private StringBuilder analysisMethod(Method method) {
        StringBuilder uriBuilder = new StringBuilder();

        IntentExactHostUri intentExactHostUri = method.getAnnotation(IntentExactHostUri
                                                                             .class);
        IntentCombineUri   intentCombineUri   = method.getAnnotation(IntentCombineUri
                                                                             .class);

        if (intentExactHostUri != null) {
            uriBuilder.append(intentExactHostUri.value());
        } else if (intentCombineUri != null) {
            String scheme = intentCombineUri.scheme();
            String host   = intentCombineUri.host();
            String port   = intentCombineUri.port();
            String path   = intentCombineUri.path();

            uriBuilder.append(scheme).append("://").append(host)
                    .append(TextUtils.isEmpty(port) ? "" : ":" + port)
                    .append(TextUtils.isEmpty(path) ? "" : path.startsWith("/") ? path
                            : ("/" + path));

        } else {
            throw new IllegalArgumentException("Annotation is error");
        }

        return uriBuilder;
    }


    private Bundle analysisParams(StringBuilder uriBuild, Method method, Object[] args) {
        Bundle bundle = new Bundle();
        //因为一个参数可以有多个注解，所以是二维数组
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();

        int position = 0;
        for (int i = 0; i < parameterAnnotations.length; i++) {
            Annotation[] parameterAnnotation = parameterAnnotations[i];
            if (parameterAnnotation == null || parameterAnnotation.length == 0) {
                break;
            }
            Annotation annotation = parameterAnnotation[0];
            if (annotation instanceof ParamActionDescribe) {
                uriBuild.append(position == 0 ? "?" : "&");
                position++;
                uriBuild.append(((ParamActionDescribe) annotation).value())
                        .append("=")
                        .append(args[i]);
            } else if (annotation instanceof ParamIntentExtrasData) {
                bundlePutParam(bundle, ((ParamIntentExtrasData) annotation).value(),
                               args[i]);
            }
        }
        return bundle;
    }

    private void jumpToActivity(String uri, Bundle bundle) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        intent.putExtras(bundle);
        PackageManager packageManager = context.getPackageManager();
        //查找是否存目标activity
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        if (!activities.isEmpty()) {
            context.startActivity(intent);
        }
    }

    private void bundlePutParam(Bundle bundle, String key, Object value) {
        if (value instanceof Integer) {
            bundle.putInt(key, Integer.parseInt(value.toString()));
        } else if (value instanceof Long) {
            bundle.putLong(key, Long.parseLong(value.toString()));
        } else if (value instanceof Double) {
            bundle.putDouble(key, Double.parseDouble(value.toString()));
        } else if (value instanceof Short) {
            bundle.putShort(key, Short.parseShort(value.toString()));
        } else if (value instanceof Float) {
            bundle.putFloat(key, Float.parseFloat(value.toString()));
        } else if (value instanceof String) {
            bundle.putString(key, (String) value);
        } else if (value instanceof CharSequence) {
            bundle.putCharSequence(key, (CharSequence) value);
        } else if (value.getClass().isArray()) {
            if (int[].class.isInstance(value)) {
                bundle.putIntArray(key, (int[]) value);
            } else if (long[].class.isInstance(value)) {
                bundle.putLongArray(key, (long[]) value);
            } else if (double[].class.isInstance(value)) {
                bundle.putDoubleArray(key, (double[]) value);
            } else if (short[].class.isInstance(value)) {
                bundle.putShortArray(key, (short[]) value);
            } else if (float[].class.isInstance(value)) {
                bundle.putFloatArray(key, (float[]) value);
            } else if (String[].class.isInstance(value)) {
                bundle.putStringArray(key, (String[]) value);
            } else if (CharSequence[].class.isInstance(value)) {
                bundle.putCharSequenceArray(key, (CharSequence[]) value);
            } else if (Parcelable[].class.isInstance(value)) {
                bundle.putParcelableArray(key, (Parcelable[]) value);
            }
        } else if (value instanceof ArrayList && !((ArrayList) value).isEmpty()) {
            ArrayList list = (ArrayList) value;
            if (list.get(0) instanceof Integer) {
                bundle.putIntegerArrayList(key, (ArrayList<Integer>) value);
            } else if (list.get(0) instanceof String) {
                bundle.putStringArrayList(key, (ArrayList<String>) value);
            } else if (list.get(0) instanceof CharSequence) {
                bundle.putCharSequenceArrayList(key, (ArrayList<CharSequence>) value);
            } else if (list.get(0) instanceof Parcelable) {
                bundle.putParcelableArrayList(key, (ArrayList<? extends Parcelable>)
                        value);
            }
        } else if (value instanceof Parcelable) {
            bundle.putParcelable(key, (Parcelable) value);
        } else if (value instanceof Serializable) {
            bundle.putSerializable(key, (Serializable) value);
        } else {
            throw new IllegalArgumentException("不支持的参数类型！");
        }
    }
}
