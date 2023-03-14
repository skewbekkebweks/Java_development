package com.example.java_development.module4;

public class Recursion {

    public static long fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static long f1(int n) {
        return (n == 0 ? 1 : n * f1(n - 1));
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }
}
