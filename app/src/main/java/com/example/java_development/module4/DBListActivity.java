package com.example.java_development.module4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.java_development.R;

public class DBListActivity extends AppCompatActivity {
    DBPoints dbPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dblist);
        dbPoints = new DBPoints(this);
        dbPoints.insert(new PointEntity("Vasya", "Mat", 2));
    }
}