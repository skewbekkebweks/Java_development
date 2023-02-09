package com.example.java_development.module4;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        String[] a = new String[10];
        System.out.println(a);
        System.out.println(Arrays.toString(a));
        Integer[] a2 = {2, 1, 3, 46, 0};
        Arrays.sort(a2, new ReverseCMP());

        System.out.println(Arrays.toString(a2));
    }

    public static void v1() {

    }

    static class ReverseCMP implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            return - (i1 - i2);
        }
    }

    static class LastCMP implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            i1 %= 10;
            i2 %= 10;
            return - (i1 - i2);
        }
    }
}
