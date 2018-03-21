package jxtxwifisdk.sdk.tx.uascent.com.devicecontrolmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.uascent.tx.sdk.jxtxwifisdk.base.bean.DeviceBean;
import com.uascent.tx.sdk.jxtxwifisdk.base.bean.UserBean;

import java.util.ArrayList;

import jxtxwifisdk.sdk.tx.uascent.com.devicecontrolmodule.contract.DeviceControlContract;

public class DeviceControlActivity extends AppCompatActivity implements
        DeviceControlContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_control);

        UserBean              user    = getIntent().getParcelableExtra("user");
        ArrayList<DeviceBean> devices = getIntent().getParcelableArrayListExtra("device");

        TextView tv_devices    = findViewById(R.id.tv_devices);
        TextView tv_device_name = findViewById(R.id.tv_device_name);

        tv_devices.setText("device:" + devices);
        tv_device_name.setText("userName:" + user);
    }

    @Override
    public void method() {

    }
}
