package jxtxwifisdk.sdk.tx.uascent.com.devicesetnetmodule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import jxtxwifisdk.sdk.tx.uascent.com.devicesetnetmodule.contract.DeviceSetNetContract;

public class DeviceSetNetActivity extends AppCompatActivity implements DeviceSetNetContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_set_net);
    }

    @Override
    public void method() {

    }
}
