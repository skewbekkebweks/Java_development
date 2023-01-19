package com.example.java_development.lesson190123;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class SamsungView extends View {
    Paint paint = new Paint();

    public SamsungView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.BLUE);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
    }
}
