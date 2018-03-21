package jxtxwifisdk.sdk.tx.uascent.com.devicecontrolmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import jxtxwifisdk.sdk.tx.uascent.com.devicecontrolmodule.contract.DeviceControlContract;

public class DeviceControlActivity extends AppCompatActivity implements
        DeviceControlContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_control);
    }

    @Override
    public void method() {

    }
}
