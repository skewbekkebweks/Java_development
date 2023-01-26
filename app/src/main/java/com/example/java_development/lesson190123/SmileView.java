package com.example.java_development.lesson190123;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class SmileView extends SurfaceView implements SurfaceHolder.Callback {
    SmileThread smile;

    public SmileView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        smile = new SmileThread(getHolder(), getContext());
        smile.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        smile.setStop(true);
        boolean stopped = false;
        while (!stopped) {
            try {
                smile.join();
                stopped = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        smile.setEventX((int) event.getX());
        smile.setEventY((int) event.getY());
        return super.onTouchEvent(event);
    }
}
