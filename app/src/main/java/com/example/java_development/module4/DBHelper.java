package com.example.java_development.module4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "points.db";
    public static final String POINTS_TABLE_NAME = "points";
    public static final int DB_VERSION = 1;

    public static final String POINTS_ID = "id";
    public static final int POINTS_ID_NUM = 0;
    public static final String POINTS_NAME = "name";
    public static final int POINTS_NAME_NUM = 1;
    public static final String POINTS_STUB = "stub";
    public static final int POINTS_STUB_NUM = 2;
    public static final String POINTS_POINT = "point";
    public static final int POINTS_POINT_NUM = 3;

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table " + POINTS_TABLE_NAME + "(" +
            POINTS_ID + " INTEGER primary key autoincrement," +
            POINTS_NAME + " TEXT," +
            POINTS_STUB + " TEXT," +
            POINTS_POINT + " INTEGER" +
        ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int ov, int nv) {
        db.execSQL("drop table " + POINTS_TABLE_NAME);
        onCreate(db);
    }
}
