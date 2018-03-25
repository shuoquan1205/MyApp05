package com.example.shuoquan1205.myapp05.ActivityPart;

import java.io.Serializable;

public class SerObj implements Serializable{

    public SerObj(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString(){
        return "SerObj/id:"+getId()+"/name:"+getName();
    }

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}