package com.example.oa10.Beans;

import android.graphics.drawable.Drawable;

/**
 * Created by asus on 2018/12/27.
 */

public class NewsBeans {
    public String title;
    public String des;
    public Drawable icon;
    public String news_url;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getNews_url() {
        return news_url;
    }

    public void setNews_url(String news_url) {
        this.news_url = news_url;
    }
}
