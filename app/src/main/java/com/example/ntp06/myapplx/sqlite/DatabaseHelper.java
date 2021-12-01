package com.example.ntp06.myapplx.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    static String name = "user.db";
    static int dbVersion = 1;

    private static DatabaseHelper databaseHelper;

    private DatabaseHelper(Context context) {
        super(context, name, null, dbVersion);
    }

    public static DatabaseHelper getInstance(Context context) {
        if (null == databaseHelper) {
            databaseHelper = new DatabaseHelper(context);
        }
        return databaseHelper;
    }

    //只在创建的时候用一次
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table user(id integer primary key autoincrement,username varchar(20) ,password varchar(20),age integer,sex varchar(2))";
        db.execSQL(sql);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}