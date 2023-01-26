package com.example.java_development.lesson190123;

import android.app.usage.UsageEvents;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import com.example.java_development.R;

public class SmileThread extends Thread {
    private boolean stop = false;
    private SurfaceHolder holder;
    private Context context;
    private int x = 100, y = 100;
    private int dX = 10, dY = 10;
    private int eventX = x, eventY = y;
    private Paint p = new Paint();

    {
        p.setColor(Color.BLUE);
        p.setStyle(Paint.Style.FILL);
    }

    public SmileThread(SurfaceHolder holder, Context context) {
        this.holder = holder;
        this.context = context;
    }

    @Override
    public void run() {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.smile);

        while (!stop) {
            Canvas canvas = holder.lockCanvas();
            if (canvas != null) {
                canvas.drawColor(Color.BLUE);
                canvas.drawBitmap(bitmap, x - bitmap.getWidth() / 2, y - bitmap.getHeight() / 2, p);

                if (eventX > x) x += dX;
                if (eventX < x) x -= dX;
                if (Math.abs(eventX - x) <= 10) x = eventX;

                if (eventY > y) y += dY;
                if (eventY < y) y -= dY;
                if (Math.abs(eventY - y) <= 10) y = eventY;


                holder.unlockCanvasAndPost(canvas);
            }
        }
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public int getEventX() {
        return eventX;
    }

    public void setEventX(int eventX) {
        this.eventX = eventX;
    }

    public int getEventY() {
        return eventY;
    }

    public void setEventY(int eventY) {
        this.eventY = eventY;
    }
}
