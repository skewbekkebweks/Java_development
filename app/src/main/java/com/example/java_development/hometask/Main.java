package com.example.java_development.hometask;

import com.example.java_development.generics.ThreeIntegers;

public class Main {
    public static void main(String[] args) {
        System.out.println(check(new ThreeIntegers<Integer, Integer, Integer>(3, 4, 6)));
    }

    public static boolean check(ThreeIntegers<Integer, Integer, Integer> three) {
        Integer max_ = three.t1 > three.t2 ? (three.t1 > three.t3 ? three.t1 : three.t3) : (three.t2 > three.t3 ? three.t2 : three.t3);
        return Math.pow(three.t1, 2) + Math.pow(three.t2, 2) + Math.pow(three.t3, 2) == 2 * Math.pow(max_, 2);
    }
}
