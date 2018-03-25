package com.example.shuoquan1205.myapp05.ActivityPart;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.shuoquan1205.myapp05.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Activity01 extends AppCompatActivity {

    private String Tag = "Activity01";

    Button startActivityBtn01;
    Button startActivityBtn02;
    Button startActivityBtn03;
    Button startActivityBtn04;
    Button startActivityBtn05;
    Button finishActivityBtn;

    private int REQUEST_CODE_NO_REQUEST = 0;
    private int REQUEST_CODE_01 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(Tag,"onCreate|"+this.toString());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_01);
        initWidget();
    }

    @Override
    protected void onStart() {
        Log.d(Tag,"onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(Tag,"onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(Tag,"onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(Tag,"onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(Tag,"onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d(Tag,"onRestart");
        super.onRestart();
    }

    private void initWidget() {
        Log.d(Tag,"initWidget()");
        startActivityBtn01 = (Button) findViewById(R.id.startActivityBtn01);
        startActivityBtn01.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(Tag,"start Activity OnClick");
                startActivityFromAtoB();
            }
        });
        startActivityBtn02 = (Button) findViewById(R.id.startActivityBtn02);
        startActivityBtn02.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(Tag,"start Activity Bwith Action OnClick");
                startActivityWithActionAndCategory("MY_ACTION");
            }
        });
        startActivityBtn03 = (Button) findViewById(R.id.startActivityBtn03);
        startActivityBtn03.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(Tag,"start Activity with Action and Category OnClick");
                startActivityWithActionAndCategory("MY_ACTION","MY_CATEGORY");
            }
        });
        startActivityBtn04 = (Button) findViewById(R.id.startActivityBtn04);
        startActivityBtn04.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(Tag,"start Activity with Extra OnClick");
                startActivityWithExtar();
            }
        });
        startActivityBtn05 = (Button) findViewById(R.id.startActivityBtn05);
        startActivityBtn05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(Tag,"start Activity For Result OnClick");
                startActivityFromAtoB(true,REQUEST_CODE_01);
            }
        });
        finishActivityBtn = (Button) findViewById(R.id.finishActivityBtn);
        finishActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(Tag,"finish Activity Btn OnClick");
                ActivityCollector.showActivityListInfo();
                boolean b = ActivityCollector.removeActivity(Activity02.class,true);
                ActivityCollector.showActivityListInfo();
            }
        });
    }

    private void startActivityFromAtoB(){
        startActivityFromAtoB(false,REQUEST_CODE_NO_REQUEST);
    }

    private void startActivityFromAtoB(boolean needResult,int requestCode) {
        Intent intent = new Intent(Activity01.this,Activity02.class);
        if(needResult&&(requestCode!=REQUEST_CODE_NO_REQUEST)){
            startActivityForResult(intent,requestCode);
        }else {
            startActivity(intent);
        }
    }

    private void startActivityWithActionAndCategory(String actionName){
        startActivityWithActionAndCategory(actionName,null);
    }

    private void startActivityWithActionAndCategory(String actionName,String categoryName) {
        String packageName = "com.example.shuoquan1205.myapp05";
        actionName = packageName + "."+ actionName;
        Log.d(Tag,"actionName:"+actionName);
        Intent i = new Intent(actionName);
        if(categoryName==null||categoryName.isEmpty()||categoryName.length()==0){
            Log.d(Tag,"categoryName:DEFAULT");
        }else{
            categoryName = packageName + "." + categoryName;
            Log.d(Tag,"categoryName:"+categoryName);
            i.addCategory(categoryName);
        }
        startActivity(i);
    }

    private void startActivityWithExtar() {
        //new Intent and Bundle
        Intent intent = new Intent(Activity01.this,Activity02.class);
        Bundle bundle = new Bundle();
        //normal
        intent.putExtra("key","data");
        //Serializable Obj
        intent.putExtra("key_ser",new SerObj(111,"xxx"));
        //Serializable Obj List
        List<SerObj> serObjList = new ArrayList<SerObj>();
        serObjList.clear();
        serObjList.add(new SerObj(100,"xxx"));
        serObjList.add(new SerObj(101,"yyy"));
        intent.putExtra("key_ser_list", (Serializable) serObjList);
        //Parcelable Obj
        intent.putExtra("key_par",new ParObj(11,11,"xxx"));
        //Parcelable Obj List
        List<ParObj> parObjList = new ArrayList<ParObj>();
        parObjList.clear();
        parObjList.add(new ParObj(11,11,"xxx"));
        parObjList.add(new ParObj(22,22,"yyy"));
        intent.putParcelableArrayListExtra("key_par_list", (ArrayList<ParObj>) parObjList);
        //start Activity
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CODE_01){
            Log.d(Tag,"onActivityResult");
            switch (requestCode){
                case RESULT_OK:
                    Log.d(Tag,"RESULT_OK");
                    String returnData = data.getStringExtra("return_data");
                    if(returnData==null){
                        Log.d(Tag,"returnData:NULL");
                    }else if(returnData.isEmpty()){
                        Log.d(Tag,"returnData:isEmpty");
                    }else{
                        Log.d(Tag,"returnData:"+returnData);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //返回true，表示允许创建的菜单显示出来
        //返回了false，创建的菜单将无法显示。
        //getMenuInflater().inflate(menuRes,menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (getItemId()){
//            case :
//                ...
//        }
        return true;
    }
}
