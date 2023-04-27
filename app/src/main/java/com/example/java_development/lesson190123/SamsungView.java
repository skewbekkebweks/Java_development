package com.example.java_development.lesson190123;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import com.example.java_development.R;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SamsungView extends View {
    Paint paint = new Paint();

    public SamsungView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, 0, getWidth(), 100, paint);

        paint.setColor(Color.WHITE);
        paint.setTextSize(50);
        canvas.drawText("Hello World!!", 200, 50, paint);

        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
        b = Bitmap.createScaledBitmap(b, 920, 600, true);
        Rect src = new Rect(0, 0, b.getWidth(), b.getHeight());
        int w = getWidth();
        int h = getHeight();
        Rect dst = new Rect(w - b.getWidth(), h - b.getHeight(), w, h);
        canvas.drawBitmap(b, src, dst, paint);


        paint.setColor(Color.BLACK);
        paint.setTextSize(100);
        canvas.save();
        canvas.rotate(45);
        canvas.drawText("Hello world!!", 200, 500, paint);
        canvas.restore();
    }
}
