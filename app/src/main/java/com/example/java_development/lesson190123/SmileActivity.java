package com.example.java_development.lesson190123;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.java_development.R;

public class SmileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SmileView(getBaseContext()));
    }
}