package com.uascent.tx.sdk.jxtxwifisdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.uascent.tx.sdk.jxtxwifisdk.center.CenterTest;
import com.uascent.tx.sdk.jxtxwifisdk.user.UserTest;
import com.uascent.tx.sdk.jxtxwifisdk.utils.OkhttpRequest;
import com.uascent.tx.sdk.jxtxwifisdk.utils.RequestBack;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CenterTest.showCenter(this, "center测试");
        CenterTest.showUser(this, "显示User");
        UserTest.showUser(this, "测试哈哈哈哈");
        OkhttpRequest.doRequest("http://www.baidu.com", new RequestBack() {
            @Override
            public void onFailure(IOException e) {

            }

            @Override
            public void onResponse(final String body) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "body:" + body, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

}


