package com.example.java_development;

import java.util.Arrays;

public class Main {
    private int count = 0;
    public static void main(String[] args) {
        System.out.println((int) (Math.random() * 5));
        String s2 = new String("A");
        String s1 = new String("A");
        int[] a = new int[5];

        System.out.println(Arrays.toString(a));
        System.out.println(s1.charAt(0));
        System.out.println(s1.equals(s2));
        s1 += "B";
        System.out.println(s1);
    }
    public int getCount() {
        return this.count;
    }
    public void registration(String name) {

    }
    public static void print(Integer i) {
        System.out.println(i);
    }
    public static void print(Long i) {
        System.out.println(i);
    }
}
