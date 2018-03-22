package com.example.shuoquan1205.myapp05.SimpleNewsApp;

public class News {

    public News(){
    }

    public News(String title,String author,String content){
        this.setTitle(title);
        this.setAuthor(author);
        this.setContent(content);
    }

    public boolean isEmpty(){
        if(this.getTitle()==null||this.getTitle().isEmpty()){
            return true;
        }else if(this.getAuthor()==null||this.getAuthor().isEmpty()){
            return true;
        }else if(this.getContent()==null||this.getContent().isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    private String title;
    private String author;
    private String content;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}