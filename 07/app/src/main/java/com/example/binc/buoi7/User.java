package com.example.binc.buoi7;

/**
 * Copyright © 2015 AsianTech inc.
 * Created by Binc on 03/04/2016.
 */
public class User {
    String title;
    String content;
    public User(String title,String content){
        this.title=title;
        this.content=content;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }
}
