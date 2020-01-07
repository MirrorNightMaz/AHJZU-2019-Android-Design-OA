package com.example.oa10.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.util.Log;
import android.view.View;
import com.example.oa10.entity.Inform;
import com.example.oa10.entity.News;
import com.example.oa10.entity.ResultBean;
import com.example.oa10.entity.Schedule;
import com.example.oa10.manager.DataManager;
import com.example.oa10.view.MVPView;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by wl624 on 2017/10/17.
 */

public class MyPresenter implements Presenter {
    private DataManager manager;
    private CompositeSubscription mCompositeSubscription;
    private static Context mContext = null;
    private MVPView newView;
    //private ArticleView articleView;
    private News myNews;
    private ResultBean resultBean;
    private Schedule schedule;
    //private Article article;
    //private Theme theme;

    /**
    public static MyPresenter myPresenter = null;

    public static MyPresenter getInstance(Context Context){
        if(mContext==null){
            mContext = Context;
        }

        if(myPresenter==null){
            myPresenter = new MyPresenter();
        }
        return myPresenter;
    }

     **/

    public MyPresenter(Context context) {
        this.mContext=context;
        onCreate();
    }

    @Override
    public void onCreate() {
        manager = new DataManager(mContext);
        mCompositeSubscription = new CompositeSubscription();

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        if (mCompositeSubscription.hasSubscriptions()){
            mCompositeSubscription.unsubscribe();
        }

    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(MVPView view) {
        newView=(MVPView) view;
        //

    }
    public void getAllNews(){
        mCompositeSubscription.add(manager.getAllNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<News>() {
                    @Override
                    public void onCompleted() {
                        if (myNews != null){
                            //newView.stopRefreshing();

                            newView.onSuccess_news(myNews);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        newView.onError();
                        Log.e("erroe","a");
                    }
                    @Override
                    public void onNext(News news1) {

                        myNews = news1;
                    }

                })
        );
    }

    public void getSche(String type,String user_id){
        mCompositeSubscription.add(manager.getSche(type,user_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Schedule>() {
                    @Override
                    public void onCompleted() {
                        if (schedule != null){
                            //newView.stopRefreshing();

                            newView.onSuccess_schedule(schedule);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        newView.onError();
                        Log.e("erroe","a");
                    }

                    @Override
                    public void onNext(Schedule schedule1) {
                        schedule = schedule1;
                    }


                })
        );
    }

    Inform inform;
    public void getInform(){
        mCompositeSubscription.add(manager.getInform()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Inform>() {
                    @Override
                    public void onCompleted() {

                        if (inform != null){
                            //newView.stopRefreshing();

                            newView.onSuccess_inform(inform);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        newView.onError();
                        Log.e("erroe","a");
                    }
                    @Override
                    public void onNext(Inform inform1) {

                        inform=inform1;
                    }

                })
        );
    }
    /**
    public void getAnno(){
        mCompositeSubscription.add(manager.getAnno()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Announcement>() {
                    @Override
                    public void onCompleted() {

                        if (announcements != null){
                            //newView.stopRefreshing();

                            newView.onSuccess_announcement(announcements);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        newView.onError();
                        Log.e("erroe","a");
                    }
                    @Override
                    public void onNext(Announcement announcement1) {

                        announcements = announcement1;
                    }

                })
        );
    }
    public void getNotice(){
        mCompositeSubscription.add(manager.getNotice()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Notice>() {
                    @Override
                    public void onCompleted() {
                        if (notices != null){
                            //newView.stopRefreshing();

                            newView.onSuccess_notice(notices);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        newView.onError();
                        Log.e("erroe","a");
                    }
                    @Override
                    public void onNext(Notice notice1) {

                        notices = notice1;
                    }

                })
        );
    }
     **/
    public void login(String user_id,String user_pass){
        mCompositeSubscription.add(manager.login(user_id,user_pass)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultBean>() {
                    @Override
                    public void onCompleted() {
                        if (resultBean != null){
                            //newView.stopRefreshing();

                            Log.e("login",resultBean.toString());
                            newView.onSuccess_login(resultBean);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        newView.onError();
                        Log.e("erroe","a");
                    }
                    @Override
                    public void onNext(ResultBean ne) {

                        resultBean = ne;
                    }

                })
        );
    }


}
