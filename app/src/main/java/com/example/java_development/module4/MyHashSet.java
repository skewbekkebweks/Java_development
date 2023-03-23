package com.example.java_development.module4;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class MyHashSet<T> {
    private ArrayList<T>[] set;

    public MyHashSet(int capacity) {
        set = new ArrayList[capacity];
        for (int i = 0; i < capacity; i++) {
            set[i] = new ArrayList<>();
        }
    }

    private int getCol(T value) {
        int hashCode = value.hashCode();
        return hashCode % set.length;
    }

    public boolean add(T value) {
        int col = getCol(value);
        return set[col].add(value);
    }

    public boolean remove(T value) {
        int col = getCol(value);
        return set[col].remove(value);
    }

    public boolean contains(T value) {
        int col = getCol(value);
        return set[col].contains(value);
    }

    public static void main(String[] args) {
//        MyHashSet<Integer> myHashSet = new MyHashSet<>(10);
//        Set<Integer> myHashSet = new HashSet<>(8);
        Set<MyMonth> myHashSet = new TreeSet<>();
        myHashSet.add(new MyMonth("Dec", -15, 31));
        myHashSet.add(new MyMonth("Dec", -15, 31));
        myHashSet.add(new MyMonth("Jan", -15, 31));
        System.out.println(myHashSet);

    }
}
