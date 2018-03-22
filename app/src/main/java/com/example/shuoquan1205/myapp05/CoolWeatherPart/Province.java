package com.example.shuoquan1205.myapp05.CoolWeatherPart;

public class Province {

    public Province(String code, int id, String name) {
        this.code = code;
        this.id = id;
        this.name = name;
    }

    private int id;
    private String name;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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