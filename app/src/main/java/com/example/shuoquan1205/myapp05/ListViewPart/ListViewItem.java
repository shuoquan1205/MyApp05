package com.example.shuoquan1205.myapp05.ListViewPart;

public class ListViewItem {
    private int id;
    private String msg;
    private int imgId;

    ListViewItem(){
        setId(0);
        setMsg("");
        setImgId(0);
    }

    ListViewItem(int id,String msg,int imgId){
        setId(id);
        setMsg(msg);
        setImgId(imgId);
    }

    public boolean isNull(){
        if (id==0||msg.equals("")||imgId==0){
            return true;
        }else{
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}