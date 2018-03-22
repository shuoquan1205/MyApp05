package com.example.shuoquan1205.myapp05.SimpleNewsApp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.shuoquan1205.myapp05.R;

public class NewsMainActivity extends AppCompatActivity {

    private void showLog(String logMsg){
        String logTag = "NewsMainActivity";
        Log.d(logTag,logMsg);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_main);
        showLog("onCreate");
    }
}
