package com.example.java_development.lesson190123;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Window;

import com.example.java_development.R;

public class DrawActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar ab = getSupportActionBar();
        if (ab != null) ab.hide();

        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.player);
        Rect init = new Rect(0, 0, b.getWidth() / 5, b.getHeight() / 3);

        Sprite player = new Sprite(0, 300, 20, 20, init, b);
        setContentView(new GameView(this, player));
    }
}