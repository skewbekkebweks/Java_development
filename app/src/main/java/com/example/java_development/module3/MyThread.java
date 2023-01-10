package com.example.java_development.module3;

public class MyThread implements Runnable {
    String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print(name);
        }
    }

    public static void main(String[] args) {
        Thread t, t2, t3;
        t = new Thread(new MyThread("A"));
        t2 = new Thread(new MyThread("B"));
        t3 = new Thread(new MyThread("C"));
        t.start();
        t2.start();
        t3.start();
    }
}
