package com.uascent.tx.sdk.jxtxwifisdk.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.uascent.tx.sdk.jxtxwifisdk.user.contract.UserContract;
import com.uascent.tx.sdk.jxtxwifisdk.user.presenter.UserPresenter;

public class UserActivity extends AppCompatActivity implements UserContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
    }

    @Override
    public void method() {

    }
}
