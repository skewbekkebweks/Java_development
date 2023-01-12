package com.example.java_development.module3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.example.java_development.R;

public class RandomTextActivity extends AppCompatActivity {
    TextView text;
    RandomTextThread t;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.obj != null) {
                text.setText("" + (double) msg.obj);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_text);
        text = findViewById(R.id.text);
    }

    @Override
    protected void onResume() {
        super.onResume();
        t = new RandomTextThread(handler);
        t.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        t.setStart(false);
    }
}