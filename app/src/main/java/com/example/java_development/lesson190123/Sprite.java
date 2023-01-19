package com.example.java_development.lesson190123;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.List;

public class Sprite {
    private Bitmap bitmap;
    private List<Rect> frames;
    private int frameWidth;
    private int frameHeight;
    private int currentFrame = 0;
    private double frameTime = 20;
    private double timeForCurrentFrame = 0;

    private double x;
    private double y;

    private double velocityX;
    private double velocityY;

    private int padding = 20;

    public Sprite(double x, double y, double velocityX, double velocityY, Rect initialFrame, Bitmap bitmap) {

        this.x = x;
        this.y = y;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.bitmap = bitmap;
        this.frames = new ArrayList<Rect>();
        this.frames.add(initialFrame);
        this.bitmap = bitmap;
//        this.timeForCurrentFrame = 0.0;
//        this.frameTime = 0.1;
//        this.currentFrame = 0;
        this.frameWidth = initialFrame.width();
        this.frameHeight = initialFrame.height();
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap,
                frames.get(currentFrame),
                new Rect((int) x, (int) y, frameWidth, frameHeight),
                new Paint());
    }
}
