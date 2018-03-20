package com.uascent.tx.sdk.jxtxwifisdk.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.uascent.tx.sdk.jxtxwifisdk.R;

import jxtxwifisdk.sdk.tx.uascent.com.apt_lib.AutoCreateTest;

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
}
