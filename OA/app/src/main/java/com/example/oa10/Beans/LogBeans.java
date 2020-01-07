package com.example.oa10.Beans;

/**
 * Created by asus on 2018/12/30.
 */

public class LogBeans {
    private String log_title;   //标题
    private String log_content; //内容
    private String log_times;   //时间
    private int log_ids;        //编号


    public LogBeans(String log_title, String log_content, String log_times, int log_ids) {
        this.log_title = log_title;
        this.log_content = log_content;
        this.log_times = log_times;
        this.log_ids = log_ids;
    }

    public LogBeans(String log_title, String log_content, String log_times) {
        this.log_title = log_title;
        this.log_content = log_content;
        this.log_times = log_times;
    }

    public LogBeans(int log_ids,String log_title, String log_times) {
        this.log_title = log_title;
        this.log_times = log_times;
        this.log_ids = log_ids;
    }

    public LogBeans(String log_title, String log_content) {
        this.log_title = log_title;
        this.log_content = log_content;
    }

    public String getLog_title() {
        return log_title;
    }

    public String getLog_content() {
        return log_content;
    }

    public String getLog_times() {
        return log_times;
    }

    public int getLog_ids() {
        return log_ids;
    }
}
