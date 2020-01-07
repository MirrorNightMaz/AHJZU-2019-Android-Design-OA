package com.example.oa10.manager;

import android.content.Context;
import android.util.Log;


import com.example.oa10.Utils.RetrofitHelper;
import com.example.oa10.Utils.RetrofitService;
import com.example.oa10.entity.Inform;
import com.example.oa10.entity.News;
import com.example.oa10.entity.ResultBean;
import com.example.oa10.entity.Schedule;


import java.util.List;

import rx.Observable;


/**
 * Created by win764-1 on 2016/12/12.
 */

public class DataManager {
    private RetrofitService mRetrofitService;
    public DataManager(Context context){
        this.mRetrofitService = RetrofitHelper.getInstance(context).getServer();
    }
    public Observable<News> getAllNews(){
        return  mRetrofitService.getAllNews();
    }

    //public Observable<Announcement> getAnno(){ return  mRetrofitService.getAnno(); }

    //public Observable<Notice> getNotice(){return  mRetrofitService.getNotice();}

    public Observable<Inform> getInform(){ return  mRetrofitService.getInform(); }

    public Observable<Schedule> getSche(String type,String user_id){
        return  mRetrofitService.getSche(type,user_id);
    }


    public Observable<ResultBean> login(String user_id,String user_pass){ return  mRetrofitService.login(user_id,user_pass); }


}
