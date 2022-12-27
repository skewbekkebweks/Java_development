package com.example.java_development.tasks;

public class Printer {
    public static <T extends Number> void print(T x) {
        System.out.println(x);
    }

    public static <T> void print(T[] tArr){
        for (T t : tArr) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public static void print(int x) {
        System.out.println(x);
    }
    public static void print(double x) {
        System.out.println(x);
    }
    public static void print(int[] x) {
        System.out.print("[");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i]);
            if (i + 1 < x.length) System.out.print(",");
        }
        System.out.println("]");

    }
    public static void print(double[] x) {
        System.out.print("[");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i]);
            if (i + 1 < x.length) System.out.print(",");
        }
        System.out.println("]");
    }
}
