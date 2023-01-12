package com.example.java_development.module3;

public class MyHouse {
    boolean arrived = false;
    public synchronized void pizzaGuy() {
        arrived = true;
        notifyAll();
    }
    public void eatPizza() {
        synchronized (this) {
            while (!arrived) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("yumyum");
    }

    public static void main(String[] args) {
        MyHouse house = new MyHouse();
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            house.pizzaGuy();
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                house.eatPizza();
            }
        });
        t.start();
        t2.start();
    }
}
