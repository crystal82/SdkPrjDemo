package com.uascent.tx.sdk.jxtxwifisdk.center;

import android.content.Context;
import android.widget.Toast;

import com.uascent.tx.sdk.jxtxwifisdk.user.UserTest;

/**
 * 作者：HWQ on 2018/3/6 09:38
 * 描述：
 */

public class CenterTest {

    public static void showCenter(Context context, String info) {
        Toast.makeText(context, "-----Center----:" + info, Toast.LENGTH_SHORT).show();
    }

    public static void showUser(Context context, String info) {
        UserTest.showUser(context, info);
    }
}
