package com.example.shuoquan1205.myapp05.FragmentPart;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.shuoquan1205.myapp05.R;

public class FragmentActivity extends AppCompatActivity {

    private final String logTag = "FragmentActivity";
    private String logMsg = "";

    Button showFrag01,showFrag02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        initLeftButton();
        hideRightFragIfDeviceIsPort();
    }

    private void hideRightFragIfDeviceIsPort() {

    }

    private void initLeftButton() {
        showFrag01 = (Button) findViewById(R.id.left_fragment_btn_01);
        showFrag01.setOnClickListener(onClickLis);
        showFrag02 = (Button) findViewById(R.id.left_fragment_btn_02);
        showFrag02.setOnClickListener(onClickLis);
    }

    View.OnClickListener onClickLis = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            switch (v.getId()){
                case R.id.left_fragment_btn_01:
                    logMsg = "Show Frag 1 Clicked";
                    Log.d(logTag,logMsg);
                    RightFragment fragment = new RightFragment();
                    transaction.replace(R.id.right_layout,fragment);
                    transaction.commit();
                    break;
                case R.id.left_fragment_btn_02:
                    logMsg = "Show Frag 2 Clicked";
                    Log.d(logTag,logMsg);
                    RightFragment2 fragment2 = new RightFragment2();
                    transaction.replace(R.id.right_layout,fragment2);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    break;
                default:
                    break;
            }
        }
    };


}
