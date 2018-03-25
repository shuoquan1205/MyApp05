package com.example.shuoquan1205.myapp05.ActivityPart;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {

    private static String Tag = "ActivityCollector";

    private static List<Activity> activityList = new ArrayList<Activity>();

    public static List<Activity> getActivityList() {
        return activityList;
    }

    public static void setActivityList(List<Activity> activityList) {
        ActivityCollector.activityList = activityList;
    }

    public static void showActivityListInfo(){
        Log.d(Tag,"showActivityListInfo()");
        Log.d(Tag,"ActivityList size:"+activityList.size());
    }

    public static boolean addActivity(Activity activity){
        Log.d(Tag,"addActivity()");
        activityList.add(activity);
        return true;
    }

    public static boolean removeActivity(Activity activity,boolean neeadFinish){
        Log.d(Tag,"removeActivity()");
        activityList.remove(activity);
        if(neeadFinish){
            finishActivity(activity);
        }
        return true;
    }

    public static boolean removeActivity(Class<?> cls,boolean neeadFinish){
        Log.d(Tag,"removeActivity(Class<?> cls)|cls:"+cls.toString());
        for(Activity activity:activityList){
            if(activity.getClass().equals(cls)){
                Log.d(Tag,"remove Activity:"+activity.toString());
                activityList.remove(activity);
                if(neeadFinish){
                    finishActivity(activity);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean finishAll(){
        for(Activity activity:activityList){
            finishActivity(activity);
        }
        return true;
    }

    private static void finishActivity(Activity activity){
        if(activity.isFinishing()){
            Log.d(Tag,activity.toString()+"is Finishing");
        }else{
            activity.finish();
        }
    }

}