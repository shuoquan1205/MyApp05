package com.example.shuoquan1205.myapp05.CoolWeatherPart;

public class City {

    public City(String code, String name, int proviceCode) {
        this.code = code;
        this.name = name;
        this.proviceCode = proviceCode;
    }

    private String name;
    private String code;
    private int proviceCode;

    public int getProviceCode() {
        return proviceCode;
    }

    public void setProviceCode(int proviceCode) {
        this.proviceCode = proviceCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}