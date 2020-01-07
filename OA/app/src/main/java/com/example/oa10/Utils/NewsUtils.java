package com.example.oa10.Utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.example.oa10.Beans.NewsBeans;
import com.example.oa10.R;

import java.util.ArrayList;

/**
 * Created by asus on 2018/12/28.
 */

public class NewsUtils {
    //封装新闻的假数据到list中返回,以后数据会从数据库中获取
    public static ArrayList<NewsBeans> getAllNews(Context context) {

        ArrayList<NewsBeans> arrayList = new ArrayList<NewsBeans>();

        for(int i = 0 ;i <100;i++)
        {
            NewsBeans newsBean = new NewsBeans();
            newsBean.title ="火箭发射成功";
            newsBean.des= "搜索算法似懂非懂三分得手房贷首付第三方的手";
            newsBean.news_url= "http://www.sina.cn";
            newsBean.icon = ContextCompat.getDrawable(context, R.drawable.about);; //通过context对象将一个资源id转换成一个Drawable对象。
            arrayList.add(newsBean);


            NewsBeans newsBean1 = new NewsBeans();
            newsBean1.title ="似懂非懂瑟瑟发抖速度";
            newsBean1.des= "地方上的房贷首付读书首付第三方的手房贷首付第三方的手负担";
            newsBean1.news_url= "http://www.baidu.cn";
            newsBean1.icon = ContextCompat.getDrawable(context, R.drawable.about);;//通过context对象将一个资源id转换成一个Drawable对象。
            arrayList.add(newsBean1);



            NewsBeans newsBean2 = new NewsBeans();
            newsBean2.title ="豆腐皮人热舞";
            newsBean2.des= "费解的是离开房间打扫李开复离开独守空房迪斯科浪费电锋克劳利分级恐龙快打";
            newsBean2.news_url= "http://www.qq.com";
            //通过context对象将一个资源id转换成一个Drawable对象。
            newsBean2.icon = ContextCompat.getDrawable(context, R.drawable.about);
            arrayList.add(newsBean2);
        }
        return arrayList;
    }

}
