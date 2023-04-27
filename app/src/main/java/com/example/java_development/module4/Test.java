package com.example.java_development.module4;

import java.util.HashMap;
import java.util.Map;

class Test {
    public static void main(String[] args) {
        int[] a = {2, 1, 5, 7, 5, 2, 2, 2};
        printOdds(a, 100);
        System.out.println("\n");
        printOdds1(a, 100);
    }

    static Map<Integer, Integer> countEach(int[] a) {
        Map<Integer, Integer> b = new HashMap<>();
        for (int elem :
                a) {
            if (b.containsKey(elem)) b.put(elem, b.get(elem) + 1);
            else b.put(elem, 1);
        }
        return b;
    }

    static void printOdds1(int[] a, int k) {
        for (int i = k; i < a.length; i++) {
            if (a[i] % 2 != 0)
                System.out.println(a[i]);
        }
    }

    static void printOdds(int[] a, int k) {
        if (k < a.length) {
            if (a[k] % 2 != 0) System.out.println(a[k]);
            printOdds(a, k + 1);
        }
    }
}
