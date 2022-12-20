package com.example.java_development.tasks;

public class SQEquation {
    int a;
    int b;
    int c;

    public SQEquation(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int val(int x) {
        return (int) (this.a * Math.pow(x, 2) + this.b * x + this.c);
    }
}
