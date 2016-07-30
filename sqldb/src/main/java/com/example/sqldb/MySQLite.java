package com.example.sqldb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lzm on 2016/7/19.
 */
public class MySQLite extends SQLiteOpenHelper {

    public MySQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    //当第一次创建数据库的时候被系统调用。
    //在方法中，去创建数据库表，或者初始化一些数据
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql = "create table t_user(uid integer primary key,c_name varchar(20),c_age integer,c_phone varchar(20))";
        sqLiteDatabase.execSQL(sql);
    }

    //当数据库升级的时候系统回调
    //当我们new MySQLite时如果传入的version比之前老的版本号大，则系统会调用一次该方法，在该方法中实现table的修改
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "alter table t_user add c_money float";
        sqLiteDatabase.execSQL(sql);
    }
}
