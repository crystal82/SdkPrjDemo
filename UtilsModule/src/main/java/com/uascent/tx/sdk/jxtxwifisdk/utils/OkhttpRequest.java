package com.uascent.tx.sdk.jxtxwifisdk.utils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 作者：HWQ on 2018/3/6 09:50
 * 描述：
 */

public class OkhttpRequest {

    public interface TestInnerInterface {
        void methodA();
    }

    public class A {
        public void mA() {
        }
    }

    public static void doRequest(String url, final RequestBack requestBack) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                requestBack.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                requestBack.onResponse(response.body().string());
            }
        });
    }
}
