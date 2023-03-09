package com.example.java_development.module4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DBPoints {
    DBHelper dbHelper;
    SQLiteDatabase db;

    public DBPoints(Context ctx) {
        dbHelper = new DBHelper(ctx);
        db = dbHelper.getWritableDatabase();
    }

    public void insert(PointEntity pe) {
        ContentValues cv = new ContentValues();

        cv.put(DBHelper.POINTS_NAME, pe.getName());
        cv.put(DBHelper.POINTS_STUB, pe.getStub());
        cv.put(DBHelper.POINTS_POINT, pe.getPoint());

        db.insert(DBHelper.POINTS_TABLE_NAME, null, cv);
    }

    public ArrayList<PointEntity> selectAll() {
        ArrayList<PointEntity> list = new ArrayList<>();
        Cursor cursor = db.query(DBHelper.POINTS_TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
            do {
                PointEntity pe = new PointEntity(
                        cursor.getString(DBHelper.POINTS_NAME_NUM),
                        cursor.getString(DBHelper.POINTS_STUB_NUM),
                        cursor.getInt(DBHelper.POINTS_POINT_NUM)
                );
                pe.setId(cursor.getInt(DBHelper.POINTS_ID_NUM));
                list.add(pe);
            } while (cursor.moveToNext());
        }
        return list;
    }
}
