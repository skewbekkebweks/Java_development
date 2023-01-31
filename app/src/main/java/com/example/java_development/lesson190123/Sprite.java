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

    private Canvas canvas;

    public Sprite(double x, double y, double velocityX, double velocityY, Rect initialFrame, Bitmap bitmap, int sheetHeight, int sheetWidth) {

        this.x = x;
        this.y = y;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.bitmap = bitmap;
        this.frames = new ArrayList<Rect>();
        this.bitmap = bitmap;
        this.frameWidth = initialFrame.width();
        this.frameHeight = initialFrame.height();

        for (int i = 0; i < sheetHeight; i++) {
            for (int j = 0; j < sheetWidth; j++) {
                Rect r = new Rect(j * frameWidth, i * frameHeight,
                        (j + 1) * frameWidth, (i + 1) * frameWidth);
                frames.add(r);
                if (i != 2 && j != 4) frames.add(r);
            }
        }

    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap,
                frames.get(currentFrame),
                new Rect((int) x, (int) y, (int) (x + frameWidth), (int) (y + frameHeight)),
                new Paint());
        this.canvas = canvas;
    }

    public void update() {
        x += velocityX;
        y += velocityY;
        if (canvas != null) {
            if (y > canvas.getHeight() - frameHeight || y <= 0) {
                velocityY *= -1;
            }
            if (x < -frameWidth) {
                teleport(-1, -1);
            }
        }
        currentFrame++;
        currentFrame %= frames.size();
    }

    public void teleport(int x, int y) {
        if (canvas != null) {
            if (x == -1) this.x = canvas.getWidth();
            if (y == -1) this.y = (canvas.getHeight() - frameHeight) * Math.random();
        }
    }

    public void teleport() {
        teleport(-1, -1);
    }

    public void teleport(int x) {
        teleport(x, -1);
    }

    public List<Rect> getFrames() {
        return frames;
    }

    public void setFrames(List<Rect> frames) {
        this.frames = frames;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public int getFrameWidth() {
        return frameWidth;
    }

    public int getFrameHeight() {
        return frameHeight;
    }

    public Rect getBoundingBoxRect() {
        return new Rect(
                (int) (x + padding),
                (int) (y + padding),
                (int) (x + frameWidth - padding),
                (int) (y + frameHeight - padding));
    }
    public boolean intersect(Sprite sprite) {
        return sprite.getBoundingBoxRect().intersect(this.getBoundingBoxRect());
    }
}
