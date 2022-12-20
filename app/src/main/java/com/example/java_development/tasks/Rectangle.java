package com.example.java_development.tasks;

public class Rectangle {
    int p;
    int s;

    public Rectangle(int a, int b) {
        this.p = 2 * (a + b);
        this.s = a * b;
    }

    public int getP() {
        return p;
    }

    public int getS() {
        return s;
    }
}
