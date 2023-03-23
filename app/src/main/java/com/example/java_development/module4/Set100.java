package com.example.java_development.module4;

import java.util.Arrays;

public class Set100 {
    boolean[] set = new boolean[101];
    int size = 0;

    public boolean add(int num) {
        if (num > 100 || num < 0 || set[num]) return false;
        size++;
        return set[num] = true;
    }

    public boolean remove(int num) {
        if (num > 100 || num < 0 || !set[num]) return false;
        size--;
        set[num] = false;
        return true;
    }

    public boolean contains(int num) {
        return num <= 100 && num >= 0 && set[num];
    }

    public static void main(String[] args) {
        Set100 mySet = new Set100();
        mySet.add(10);
        mySet.add(-5);
        mySet.add(101);
        System.out.println(Arrays.toString(mySet.set));
        System.out.println(mySet.size);
        mySet.remove(10);
        mySet.remove(-5);
        mySet.remove(101);
        System.out.println(Arrays.toString(mySet.set));
        System.out.println(mySet.size);


    }
}
