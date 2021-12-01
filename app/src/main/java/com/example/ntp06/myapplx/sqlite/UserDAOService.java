package com.example.ntp06.myapplx.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDAOService {
    private DatabaseHelper dbHelper;
    private static UserDAOService userDAOService;

    private UserDAOService() {
        // 之前初始化过了，所以这里没问题
        dbHelper = DatabaseHelper.getInstance(null);
    }

    public static UserDAOService getInstance() {
        if (null == userDAOService) {
            userDAOService = new UserDAOService();
        }
        return userDAOService;
    }


    //登录用
    public boolean login(String username, String password) {
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        String sql = "select * from user where username=? and password=?";
        Cursor cursor = sdb.rawQuery(sql, new String[]{username, password});
        if (cursor.moveToFirst()) {
            cursor.close();
            return true;
        }
        return false;
    }

    //注册用
    public String register(String username,String password,int age,String sex) {
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        // 先查询
        String sql = "select * from user where username=?";
        Cursor cursor = sdb.rawQuery(sql, new String[]{username});
        // 用户名重复
        if (cursor.moveToFirst()) {
            cursor.close();
            return "用户名重复";
        } else {
            try {
                sql = "insert into user(username,password,age,sex) values(?,?,?,?)";
                Object[] obj = {username, password, age, sex};
                sdb.execSQL(sql, obj);
            } catch (Exception e) {
                return "注册失败";
            }
            return "";
        }
    }
}