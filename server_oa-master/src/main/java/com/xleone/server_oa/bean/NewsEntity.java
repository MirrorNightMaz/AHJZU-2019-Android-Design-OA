package com.xleone.server_oa.bean;
import java.io.Serializable;
public class NewsEntity implements Serializable {
    private Integer news_id;
    private String news_title;
    private String news_content;
    private String news_time;
    private String news_icon;

    public String getNews_icon() {
        return news_icon;
    }

    public void setNews_icon(String news_icon) {
        this.news_icon = news_icon;
    }

    public String getNews_time() {
        return news_time;
    }

    public void setNews_time(String news_time) {
        this.news_time = news_time;
    }

    public Integer getNews_id() {
        return news_id;
    }

    public void setNews_id(Integer news_id) {
        this.news_id = news_id;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }
}
