package com.uascent.tx.sdk.module;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.knight.ble.router.Router;
import com.uascent.tx.sdk.jxtxwifisdk.R;
import com.uascent.tx.sdk.jxtxwifisdk.base.RouterService;
import com.uascent.tx.sdk.jxtxwifisdk.base.bean.DeviceBean;
import com.uascent.tx.sdk.jxtxwifisdk.base.bean.UserBean;
import com.uascent.tx.sdk.jxtxwifisdk.center.CenterTest;
import com.uascent.tx.sdk.jxtxwifisdk.user.UserTest;
import com.uascent.tx.sdk.jxtxwifisdk.utils.OkhttpRequest;
import com.uascent.tx.sdk.jxtxwifisdk.utils.RequestBack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ServiceLoader;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button                mBtn_to_device_control;
    private Button                mBtn_to_device_net;
    private Button                mBtn_to_main;
    private Button                mBtn_to_user;
    private RouterService         mRouterService;
    private UserBean              mUserBean;
    private ArrayList<DeviceBean> mDeviceBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRouterService = new Router(this).createService(RouterService.class);

        mBtn_to_device_control = findViewById(R.id.btn_to_device_control);
        mBtn_to_device_net = findViewById(R.id.btn_to_device_net);
        mBtn_to_main = findViewById(R.id.btn_to_main);
        mBtn_to_user = findViewById(R.id.btn_to_user);

        initData();
        initListener();
    }

    private void initData() {
        mUserBean = new UserBean("hwq", "userAccount", "token:123123");

        mDeviceBeans = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            mDeviceBeans.add(new DeviceBean("type:" + i, "deviceName:" + i, i + ""));
        }
    }

    private void initListener() {
        mBtn_to_device_control.setOnClickListener(this);
        mBtn_to_device_net.setOnClickListener(this);
        mBtn_to_main.setOnClickListener(this);
        mBtn_to_user.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_to_device_control:
                mRouterService.startDeviceControlActivity(mUserBean, mDeviceBeans);
                break;
            case R.id.btn_to_device_net:
                mRouterService.startDeviceSetNetActivity("to device net",
                                                         System.currentTimeMillis() + "",
                                                         mUserBean);
                break;
            case R.id.btn_to_main:
                mRouterService.startMainActivity("to Main", mUserBean);
                break;
            case R.id.btn_to_user:
                mRouterService.startUserActivity("to user", System.currentTimeMillis()
                        + "");
                break;
            default:
        }
    }
}


