package com.example.shuoquan1205.myapp05.ActivityPart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.shuoquan1205.myapp05.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Activity02 extends AppCompatActivity {

    private String Tag = "Activity02";

    Button goBackBtn;
    CheckBox setResultCheckBox;

    TextView showActivityInfoText;

    private String lastExitTime;
    private Boolean setResultChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(Tag,"onCreate|"+this.toString());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_02);
        getDataFromSavedInstancaState(savedInstanceState);
        initWidget();
        getExtraData();
        //
        ActivityCollector.showActivityListInfo();
        ActivityCollector.addActivity(this);
        ActivityCollector.showActivityListInfo();
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(Tag,"onSaveInstanceState()");
        super.onSaveInstanceState(outState);
        String lastExitTime = getCurrentTime();
        outState.putString("lastExitTime",lastExitTime);
        Log.d(Tag,"save lastExitTime:"+lastExitTime);
        Log.d(Tag,"outState==null:"+(outState==null));
    }

    private void getDataFromSavedInstancaState(Bundle savedInstanceState) {
        Log.d(Tag,"getDataFromSavedInstancaState()");
        if(savedInstanceState==null){
            Log.d(Tag,"savedInstanceState is NULL");
        }else{
            lastExitTime = savedInstanceState.getString("lastExitTime");
            Log.d(Tag,"get lastExitTime from savedInstanceState,lastExitTime:"+lastExitTime);
        }
    }

    private void initWidget() {
        Log.d(Tag,"initWidget()");
        goBackBtn = (Button) findViewById(R.id.goBackBtn);
        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(Tag,"Go Back to Activity 01 onClick");
                startActivity();
            }
        });
        setResultCheckBox = (CheckBox) findViewById(R.id.setResult);
        setResultChecked = setResultCheckBox.isChecked();
        setResultCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(Tag,"addResultCheckBox onCheckedChanged,"+isChecked);
                setResultChecked = isChecked;
            }
        });
        Log.d(Tag,"setResultChecked:"+setResultChecked);
        showActivityInfoText = (TextView) findViewById(R.id.showActivityInfoText);
        if(lastExitTime==null||lastExitTime.isEmpty()){
            //...
        }else{
            showActivityInfoText.append("lastExitTime:"+lastExitTime);
        }
    }

    private void getExtraData() {
        //get Intent and Bundle
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        //get normal
        String data = intent.getStringExtra("key");
        if(data==null){

        }else{
            Log.d(Tag,"getStringExtra:"+data);
        }
        //get Serializable Obj
        SerObj s = (SerObj) intent.getSerializableExtra("key_ser");
        if(s==null){
            Log.d(Tag,"Serializable Obj is NULL");
        }else{
            Log.d(Tag,s.toString());
        }
        //get Serializable Obj List
        List<SerObj> serObjList = (List<SerObj>) intent.getSerializableExtra("key_ser_list");
        if(serObjList==null){
            Log.d(Tag,"Serializable Obj List is NULL");
        }else if(serObjList.size()==0){
            Log.d(Tag,"Serializable Obj List is Empty");
        }else{
            for (int i=0;i<serObjList.size();i++){
                Log.d(Tag,"Serializable Obj id:"+i+"/"+serObjList.get(i).toString());
            }
        }
        //get Parcelable Obj
        ParObj p = intent.getParcelableExtra("key_par");
        if(p==null){
            Log.d(Tag,"Parcelable Obj is NULL");
        }else{
            Log.d(Tag,p.toString());
        }
        //get Parcelable Obj List
        List<ParObj> parObjList = intent.getParcelableArrayListExtra("key_par_list");
        if(parObjList==null){
            Log.d(Tag,"Parcelable Obj List is NULL");
        }else if(parObjList.size()==0){
            Log.d(Tag,"Parcelable Obj List is Empty");
        }else{
            for(int i=0;i<parObjList.size();i++){
                Log.d(Tag,"Parcelable Obj id:"+i+"/"+parObjList.get(i).toString());
            }
        }
    }

    private String getCurrentTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String date_s = simpleDateFormat.format(date);
        return date_s;
    }

    private void startActivity(){
        Intent intent = new Intent();
        intent.setClass(Activity02.this,Activity01.class);
        Log.d(Tag,"setResultChecked:"+setResultChecked);
        if(setResultChecked){
            intent.putExtra("data_return","Hello Activity 01");
            setResult(RESULT_OK,intent);
        }
        startActivity(intent);
    }

}
