package com.example.java_development.lesson190123;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;

import com.example.java_development.R;

public class DrawActivity extends AppCompatActivity {
    private GameView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar ab = getSupportActionBar();
        if (ab != null) ab.hide();

        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.player);
        Rect init = new Rect(0, 0, b.getWidth() / 5, b.getHeight() / 3);

        Sprite player = new Sprite(100, 300, 0, 20, init, b);
        setContentView(gv = new GameView(this, player));
        Timer timer = new Timer();
        timer.start();
    }

    class Timer extends CountDownTimer {

        public Timer() {
            super(Long.MAX_VALUE, 40);
        }

        @Override
        public void onTick(long l) {
            gv.update();
        }

        @Override
        public void onFinish() {

        }
    }
}