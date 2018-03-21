package com.uascent.tx.sdk.module.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.uascent.tx.sdk.jxtxwifisdk.R;
import com.uascent.tx.sdk.jxtxwifisdk.center.CenterTest;
import com.uascent.tx.sdk.jxtxwifisdk.user.UserTest;
import com.uascent.tx.sdk.jxtxwifisdk.utils.OkhttpRequest;
import com.uascent.tx.sdk.jxtxwifisdk.utils.RequestBack;

import java.io.IOException;

import jxtxwifisdk.sdk.tx.uascent.com.annotation.test.AutoCreateTest;

/**
 * 流程：
 * 1.创建apt注解java-lib
 * -------------@Target(ElementType.TYPE)
 * -------------@Retention(RetentionPolicy.RUNTIME)
 * 2.创建apt处理器java-lib
 * 3.处理器lib引用库：
 * -------------implementation 'com.squareup:javapoet:1.9.0'
 * -------------implementation 'com.google.auto.service:auto-service:1.0-rc3'
 * 4.处理器lib创建class
 * -------添加注解：“@AutoService(Processor.class)”
 * -------继承：AbstractProcessor
 * -------在process中写下你要生成代码的逻辑
 * 5.在App中需要生成程序的页面添加：注解
 * <p>
 * 注意点：
 * 1.Android3.0跟目录不需要添加APT依赖
 * 2.process文件中不能有任何注释！！
 * 3.创建的lib必须为Java Lib
 */
public class AptTestActivity extends AppCompatActivity {

    @AutoCreateTest
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apt_test);

        mButton = findViewById(R.id.btn);
    }

    private void test() {
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
                        Toast.makeText(AptTestActivity.this, "body:" + body, Toast
                                .LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
