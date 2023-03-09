package com.example.java_development.module4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.java_development.R;

public class AddPointActivity extends AppCompatActivity {
    EditText fio, stub, point;
    Button savePoint;
    DBPoints dbPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_point);
        fio = findViewById(R.id.fio);
        stub = findViewById(R.id.stub);
        point = findViewById(R.id.point);
        savePoint = findViewById(R.id.savePoint);
        dbPoints = new DBPoints(getBaseContext());

        savePoint.setOnClickListener((v) -> {

            PointEntity pe = new PointEntity(
                    fio.getText().toString(),
                    stub.getText().toString(),
                    Integer.parseInt(point.getText().toString())
            );

            dbPoints.insert(pe);
            finish();
        });
    }
}