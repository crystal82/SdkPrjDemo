package jxtxwifisdk.sdk.tx.uascent.com.devicesetnetmodule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.uascent.tx.sdk.jxtxwifisdk.base.bean.UserBean;

import jxtxwifisdk.sdk.tx.uascent.com.devicesetnetmodule.contract.DeviceSetNetContract;

public class DeviceSetNetActivity extends AppCompatActivity implements DeviceSetNetContract.View {

    private TextView mTv_describe;
    private TextView mTv_set_type;
    private TextView mTv_time;
    private TextView mTv_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_set_net);


        String describe1 = getIntent().getStringExtra("describe");
        String describe2 = getIntent().getData().getQueryParameter("describe");
        String type      = getIntent().getStringExtra("type");


        String   time     = getIntent().getStringExtra("time");
        String   time2    = (String) getIntent().getBundleExtra("time").get("time");
        UserBean userBean = getIntent().getParcelableExtra("user");

        mTv_describe = findViewById(R.id.tv_describe);
        mTv_set_type = findViewById(R.id.tv_set_type);
        mTv_time = findViewById(R.id.tv_time);
        mTv_user = findViewById(R.id.tv_user);

        mTv_describe.setText("describe1:" + describe1 + "    describe2:" + describe2);
        mTv_set_type.setText("type:" + type);
        mTv_time.setText("time:" + time + "   time2:" + time2);
        mTv_user.setText("userBean:" + userBean);
    }

    @Override
    public void method() {

    }
}
