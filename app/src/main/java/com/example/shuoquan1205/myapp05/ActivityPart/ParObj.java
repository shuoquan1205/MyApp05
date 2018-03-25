package com.example.shuoquan1205.myapp05.ActivityPart;

import android.os.Parcel;
import android.os.Parcelable;

public class ParObj implements Parcelable{

    public ParObj() {

    }

    public ParObj(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return "ParObj/id:"+getId()+"/age:"+getAge()+"/name:"+getName();
    }

    private int id;
    private int age;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(age);
        dest.writeString(name);
    }

    public static final Creator<ParObj> CREATOR = new Creator<ParObj>() {
        @Override
        public ParObj createFromParcel(Parcel source) {
            ParObj e = new ParObj();
            e.id = source.readInt();
            e.age = source.readInt();
            e.name = source.readString();
            return e;
        }

        @Override
        public ParObj[] newArray(int size) {
            return  new ParObj[size];
        }
    };
}