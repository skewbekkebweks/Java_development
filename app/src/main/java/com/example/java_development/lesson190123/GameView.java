package com.example.java_development.lesson190123;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

import com.example.java_development.R;

import java.util.ArrayList;

public class GameView extends View {
    private int viewWidth;
    private int viewHeight;
    private int points;
    private Paint paint = new Paint();
    private Sprite player;
    private ArrayList<Sprite> enemy = new ArrayList<Sprite>();
    private Sprite bonus;
    private static final int ENEMIES_COUNT = 3;

    private long startTime;
    private static final int MAX_DURATION = 200;
    private boolean isPaused = false;

    private int currentLevel = 1;

    public GameView(Context context, Sprite player) {
        super(context);
        this.player = player;
        restart();
    }

    public void restart() {
        this.enemy.clear();
        points = 0;
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.enemy);
        for (int i = 0; i < ENEMIES_COUNT; ++i) {
            int x = (int) (Math.random() * 1000) + 500;
            int y = (int) (Math.random() * 1000);
            this.enemy.add(new Sprite(x, y, -20, 0, player.getFrames().get(0), b, 3, 5));
        }
        for (int i = 0; i < enemy.size(); i++) {
            changeVelocity(enemy.get(i), -5 * currentLevel, 0);
        }
        b = BitmapFactory.decodeResource(getResources(), R.drawable.smile);
        b = Bitmap.createScaledBitmap(b, b.getWidth() / 3, b.getHeight() / 3, true);
        Rect init = new Rect(0, 0, b.getWidth(), b.getHeight());
        int y = (int) (Math.random() * 1000);
        bonus = new Sprite(100 + player.getFrameWidth() / 2, y, 0, 0, init, b, 1, 1);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawARGB(128, 0, 0, 255);
        paint.setColor(Color.WHITE);
        paint.setTextSize(150);
        if (isPaused) {
            canvas.drawText("PAUSED", (int) (viewWidth * 0.25), (int) (viewHeight * 0.45), paint);
        }
        canvas.drawText(points + "", viewWidth - 400, 110, paint);
        paint.setTextSize(50);
        canvas.drawText("Level: " + currentLevel, viewWidth - 400, 210, paint);
        player.draw(canvas);
        for (int i = 0; i < enemy.size(); i++) {
            enemy.get(i).draw(canvas);
        }
        bonus.draw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
        viewHeight = h;
    }

    public void update() {
        if (!isPaused) {
            points++;
            player.update();
            for (int i = 0; i < enemy.size(); i++) {
                enemy.get(i).update();
                if (player.intersect(enemy.get(i))) {
                    points -= 50;
                    enemy.get(i).teleport();
                }
            }
            if (player.intersect(bonus)) {
                points += 50;
                bonus.teleport(110);
            }
            changeLevel();
        }
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - startTime <= MAX_DURATION) {
                isPaused = !isPaused;
            } else {
                boolean isKilled = false;
                for (int i = 0; i < enemy.size(); i++) {
                    Sprite curEnemy = enemy.get(i);
                    if (event.getX() >= curEnemy.getX() &&
                            event.getX() <= curEnemy.getX() + curEnemy.getFrameWidth() &&
                            event.getY() >= curEnemy.getY() &&
                            event.getY() <= curEnemy.getY() + curEnemy.getFrameHeight()) {
//                        enemy.remove(i);
                        curEnemy.teleport();
                        isKilled = true;
                    }
                }
                if (!isKilled) {
                    startTime = System.currentTimeMillis();
                    if (event.getY() > player.getY()) {
                        player.setVelocityY(Math.abs(player.getVelocityY()));
                    } else {
                        player.setVelocityY(-Math.abs(player.getVelocityY()));
                    }
                }
            }
        }
        return super.onTouchEvent(event);
    }

    private void changeVelocity(Sprite sprite, int dVx, int dVy) {
        sprite.setVelocityX(sprite.getVelocityX() + dVx);
        sprite.setVelocityY(sprite.getVelocityY() + dVy);
    }

    private void changeLevel() {
        if (points >= currentLevel * 100) {
            currentLevel += 1;
            restart();
        }
        if (points < -50) {
            isPaused = true;
            currentLevel = 1;
            restart();
        }
    }
}
