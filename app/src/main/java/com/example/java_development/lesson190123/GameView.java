package com.example.java_development.lesson190123;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class GameView extends View {
    private int viewWidth;
    private int viewHeight;
    private int points;
    private Paint paint = new Paint();
    private Sprite player;

    public GameView(Context context, Sprite player) {
        super(context);
        this.player = player;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawARGB(128, 0, 0, 255);
        paint.setColor(Color.WHITE);
        paint.setTextSize(150);
        canvas.drawText(points + "", viewWidth - 200, 110, paint);
        player.draw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
        viewHeight = h;
    }
}
