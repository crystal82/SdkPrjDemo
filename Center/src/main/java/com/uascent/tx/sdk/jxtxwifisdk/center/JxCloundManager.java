package com.uascent.tx.sdk.jxtxwifisdk.center;

import android.content.Context;

import com.uascent.tx.sdk.jxtxwifisdk.center.callback.IActionCallback;

/**
 * 作者：HWQ on 2018/3/13 18:03
 * 描述：
 */

public class JxCloundManager {
    private static Context mContext;
    private static String  mAppId     = "";
    private static String  mAppKey    = "";
    private static boolean isDebug    = false;
    private static String  mUrlTest   = "http://120.24.55.58:8083/index.php/";
    private static String  mUrlFormal = "http://api.ourslinks.com/index.php/";
    private static boolean isInit     = false;


    public static synchronized void init(Context context, IActionCallback callback) {

    }
}
