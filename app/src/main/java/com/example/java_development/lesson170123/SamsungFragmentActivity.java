package com.example.java_development.lesson170123;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.java_development.R;

public class SamsungFragmentActivity extends AppCompatActivity {
    static boolean isAdded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samsung_fragment);
        LinearLayout l = findViewById(R.id.container);
        if (savedInstanceState == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            FragmentCheck fragment = FragmentCheck.newInstance("Female", "Male");
            ft.add(R.id.container, fragment);
            ft.commit();
        }
    }
}