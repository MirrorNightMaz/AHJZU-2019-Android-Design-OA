package com.example.oa10.Utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by asus on 2018/12/30.
 */

public class MyOpenHelper extends SQLiteOpenHelper {
    public MyOpenHelper(Context context) {
        super(context, "mydate", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table mylog(" +                  //表名设置为mybook
                "ids integer PRIMARY KEY autoincrement," +   //设置id自增
                "title text," +                              //设置标题为文本类型
                "content text," +                            //设置内容为文本类型
                "times text)");
        db.execSQL("create table mysticky(" +                  //表名设置为mybook
                "ids integer PRIMARY KEY autoincrement," +   //设置id自增
                "title text," +                              //设置标题为文本类型
                "content text," +                            //设置内容为文本类型
                "times text)");   //设置时间为文本类型
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
