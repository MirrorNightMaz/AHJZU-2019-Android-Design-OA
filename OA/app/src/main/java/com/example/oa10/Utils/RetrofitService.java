package com.example.oa10.Utils;

import com.example.oa10.entity.Inform;
import com.example.oa10.entity.News;
import com.example.oa10.entity.ResultBean;
import com.example.oa10.entity.Schedule;


import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;


/**
 * Created by wl624 on 2017/10/17.
 */

public interface RetrofitService {
    @GET("news")
    Observable<News> getAllNews();
    /**
    @GET("announcement")
    Observable<Announcement> getAnno();
    @GET("notice")
    Observable<Notice> getNotice();
     **/

    @GET("inform")
    Observable<Inform> getInform();

    @GET("schedule")
    Observable<Schedule> getSche(@Query("type") String type,@Query("user_id") String user_id);


    @GET("login")
    Observable<ResultBean> login(@Query("user_id") String user_id, @Query("user_pass") String user_pass);

//    @GET("news/before/{date}")
//    Observable<MyNews> getMoreNews(@Path("date") String date);
//
//    @GET("news/{id}")
//    Observable<Article> getArticle(@Path("id") int id);
//
//    @GET("theme/{id}")
//    Observable<Theme> getTheme(@Path("id") int id);
//
//    @GET("theme/{id}/before/{id1}")
//    Observable<Theme> getMoreTheme(@Path("id") int id, @Path("id1") int id1);

}
