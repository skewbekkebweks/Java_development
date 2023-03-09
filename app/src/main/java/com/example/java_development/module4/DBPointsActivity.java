package com.example.java_development.module4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.java_development.R;

public class DBPointsActivity extends AppCompatActivity {
    DBPoints dbPoints;
    Button addPoint;
    ListView pointsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbpoints);
        dbPoints = new DBPoints(this);
        addPoint = findViewById(R.id.add_point);
        pointsList = findViewById(R.id.points_list);
        addPoint.setOnClickListener((v) -> startActivity(new Intent(getBaseContext(), AddPointActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayAdapter<PointEntity> a = new ArrayAdapter<>(
                getBaseContext(),
                android.R.layout.simple_list_item_1,
                dbPoints.selectAll()
        );
        pointsList.setAdapter(a);
    }
}