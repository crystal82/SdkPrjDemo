package jxtxwifisdk.sdk.tx.uascent.com.deviceinfomodule;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.uascent.tx.sdk.jxtxwifisdk.base.bean.UserBean;

public class MyMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_main);

        String   describe = getIntent().getData().getQueryParameter("describe");
        UserBean userBean = getIntent().getParcelableExtra("user");

        TextView tv_describe = findViewById(R.id.tv_describe);
        TextView tv_user     = findViewById(R.id.tv_user);

        tv_describe.setText("describe:" + describe);
        tv_user.setText("userBean:" + userBean);
    }
}
