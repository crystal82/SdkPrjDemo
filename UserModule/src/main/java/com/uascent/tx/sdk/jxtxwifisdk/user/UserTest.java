package com.uascent.tx.sdk.jxtxwifisdk.user;

import android.content.Context;
import android.widget.Toast;

import com.uascent.tx.sdk.jxtxwifisdk.base.OkhttpRequest;
import com.uascent.tx.sdk.jxtxwifisdk.base.RequestBack;

/**
 * 作者：HWQ on 2018/3/6 09:40
 * 描述：
 */

public class UserTest {

    public static void showUser(Context context, String info) {
        Toast.makeText(context, "-----User----:" + info, Toast.LENGTH_SHORT).show();
    }

    public static void requestUser(String url, RequestBack requestBack) {
        OkhttpRequest.doRequest(url, requestBack);
    }
}
