package com.example.oa10.Utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.oa10.Beans.LogBeans;

import java.util.ArrayList;

/**
 * Created by asus on 2018/12/30.
 */

public class MyDatabase {
    Context context;
    MyOpenHelper myOpenHelper;
    SQLiteDatabase mydatabase;
    public MyDatabase(Context context){
        this.context = context;
        myOpenHelper = new MyOpenHelper(context);
    }

    public ArrayList<LogBeans> getarray(){            //获取listview中要显示的数据
        ArrayList<LogBeans> arr = new ArrayList<LogBeans>();
        ArrayList<LogBeans> arr1 = new ArrayList<LogBeans>();
        mydatabase = myOpenHelper.getWritableDatabase();
        Cursor cursor = mydatabase.rawQuery("select ids,title,times from mylog",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            int id = cursor.getInt(cursor.getColumnIndex("ids"));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String times = cursor.getString(cursor.getColumnIndex("times"));
            LogBeans data = new LogBeans(id, title, times);
            arr.add(data);
            cursor.moveToNext();
        }
        mydatabase.close();
        for (int i = arr.size(); i >0; i--) {
            arr1.add(arr.get(i-1));
        }
        return arr1;
    }

    public LogBeans getTiandCon(int id){
        //获取要修改数据（就是当选择listview子项想要修改数据时，获取数据显示在新建页面）
        mydatabase = myOpenHelper.getWritableDatabase();
        Cursor cursor=mydatabase.rawQuery("select title,content from mylog where ids='"+id+"'" , null);
        cursor.moveToFirst();
        String title=cursor.getString(cursor.getColumnIndex("title"));
        String content=cursor.getString(cursor.getColumnIndex("content"));
        LogBeans data=new LogBeans(title,content);
        mydatabase.close();
        return data;
    }

    public void toUpdate(LogBeans data){           //修改表中数据
        mydatabase = myOpenHelper.getWritableDatabase();
        mydatabase.execSQL(
                "update mylog set title='"+ data.getLog_title()+
                        "',times='"+data.getLog_times()+
                        "',content='"+data.getLog_content() +
                        "' where ids='"+ data.getLog_ids()+"'");
        mydatabase.close();
    }

    public void toInsert(LogBeans data){           //在表中插入新建的便签的数据
        mydatabase = myOpenHelper.getWritableDatabase();
        mydatabase.execSQL("insert into mylog(title,content,times)values('"
                + data.getLog_title()+"','"
                +data.getLog_content()+"','"
                +data.getLog_times()
                +"')");
        mydatabase.close();
    }

    public void toDelete(int ids){            //在表中删除数据
        mydatabase  = myOpenHelper.getWritableDatabase();
        mydatabase.execSQL("delete from mylog where ids="+ids+"");
        mydatabase.close();
    }

    public ArrayList<LogBeans> getarraySt(){            //获取listview中要显示的数据
        ArrayList<LogBeans> arr = new ArrayList<LogBeans>();
        ArrayList<LogBeans> arr1 = new ArrayList<LogBeans>();
        mydatabase = myOpenHelper.getWritableDatabase();
        Cursor cursor = mydatabase.rawQuery("select ids,title,times from mysticky",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            int id = cursor.getInt(cursor.getColumnIndex("ids"));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String times = cursor.getString(cursor.getColumnIndex("times"));
            LogBeans data = new LogBeans(id, title, times);
            arr.add(data);
            cursor.moveToNext();
        }
        mydatabase.close();
        for (int i = arr.size(); i >0; i--) {
            arr1.add(arr.get(i-1));
        }
        return arr1;
    }

    public LogBeans getTiandConSt(int id){
        //获取要修改数据（就是当选择listview子项想要修改数据时，获取数据显示在新建页面）
        mydatabase = myOpenHelper.getWritableDatabase();
        Cursor cursor=mydatabase.rawQuery("select title,content from mysticky where ids='"+id+"'" , null);
        cursor.moveToFirst();
        String title=cursor.getString(cursor.getColumnIndex("title"));
        String content=cursor.getString(cursor.getColumnIndex("content"));
        LogBeans data=new LogBeans(title,content);
        mydatabase.close();
        return data;
    }

    public void toUpdateSt(LogBeans data){           //修改表中数据
        mydatabase = myOpenHelper.getWritableDatabase();
        mydatabase.execSQL(
                "update mysticky set title='"+ data.getLog_title()+
                        "',times='"+data.getLog_times()+
                        "',content='"+data.getLog_content() +
                        "' where ids='"+ data.getLog_ids()+"'");
        mydatabase.close();
    }

    public void toInsertSt(LogBeans data){           //在表中插入新建的便签的数据
        mydatabase = myOpenHelper.getWritableDatabase();
        mydatabase.execSQL("insert into mysticky(title,content,times)values('"
                + data.getLog_title()+"','"
                +data.getLog_content()+"','"
                +data.getLog_times()
                +"')");
        mydatabase.close();
    }

    public void toDeleteSt(int ids){            //在表中删除数据
        mydatabase  = myOpenHelper.getWritableDatabase();
        mydatabase.execSQL("delete from mysticky where ids="+ids+"");
        mydatabase.close();
    }

}
