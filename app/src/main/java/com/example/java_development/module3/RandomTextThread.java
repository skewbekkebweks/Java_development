package com.example.java_development.module3;

import android.os.Handler;
import android.os.Message;


public class RandomTextThread extends Thread {
    Handler handler;
    private boolean start = true;

    public RandomTextThread(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        while (start) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            double i = Math.random() * 100;
            Message m = new Message();
            m.obj = i;
            handler.sendMessage(m);
        }
    }

    public void setStart(boolean start) {
        this.start = start;
    }
}
