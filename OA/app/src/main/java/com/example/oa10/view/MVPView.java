package com.example.oa10.view;

import android.view.View;
import com.example.oa10.entity.Inform;
import com.example.oa10.entity.News;
import com.example.oa10.entity.ResultBean;
import com.example.oa10.entity.Schedule;


import java.util.List;

public interface MVPView {
    void onSuccess_news(News news);
    void onSuccess_login(ResultBean resultBean);
    void onSuccess_inform(Inform inform);
    //void onSuccess_announcement(Announcement announcement);
    //void onSuccess_notice(Notice notice);
    void onSuccess_schedule(Schedule schedule);
    void onError();

}
