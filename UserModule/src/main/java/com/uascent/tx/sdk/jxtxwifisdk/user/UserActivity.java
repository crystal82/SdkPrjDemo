package com.uascent.tx.sdk.jxtxwifisdk.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.knight.ble.router.Router;
import com.uascent.tx.sdk.jxtxwifisdk.base.RouterService;
import com.uascent.tx.sdk.jxtxwifisdk.base.bean.UserBean;
import com.uascent.tx.sdk.jxtxwifisdk.user.contract.UserContract;

public class UserActivity extends AppCompatActivity implements UserContract.View {

    private RouterService mService;
    private EditText mEt_user_name;
    private EditText mEt_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        mService = new Router(this).createService(RouterService.class);

        TextView tv_describe  = findViewById(R.id.tv_describe);
        TextView tv_time      = findViewById(R.id.tv_time);
        mEt_user_name = findViewById(R.id.et_user_name);
        mEt_account = findViewById(R.id.et_account);
        Button   btn_login  = findViewById(R.id.btn_login);

        String describe = getIntent().getData().getQueryParameter("describe");
        String time     = getIntent().getStringExtra("time");
        tv_describe.setText("describe:" + describe);
        tv_time.setText("time:" + time);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = mEt_user_name.getText().toString();
                String account   = mEt_account.getText().toString();
                mService.startMainActivity("用户登陆啦",
                                           new UserBean(user_name, account, "用户"));
            }
        });
    }

    @Override
    public void method() {

    }
}
