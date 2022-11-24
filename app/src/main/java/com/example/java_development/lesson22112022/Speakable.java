package com.example.java_development.lesson22112022;

public interface Speakable {
    public static final int LENGTH_SHORT = 0;
    public static final int LENGTH_LONG = 1;
    public default void example() {
        System.out.println("");
    }
    public void speak();

    public default void run() {
        System.out.println("Я бегаю");
    }
}
