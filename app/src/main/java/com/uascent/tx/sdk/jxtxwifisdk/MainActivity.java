package com.uascent.tx.sdk.jxtxwifisdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.uascent.tx.sdk.jxtxwifisdk.utils.OkhttpRequest;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       OkhttpRequest.doRequest("http://www.baidu.com", new OkhttpRequest.RequestBack() {
           @Override
           public void onFailure(IOException e) {

           }

           @Override
           public void onResponse(String body) {
               Toast.makeText(MainActivity.this, "body", Toast.LENGTH_SHORT).show();
           }
       });
    }

}


