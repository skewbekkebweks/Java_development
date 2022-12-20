package com.example.java_development.lesson22112022;

import com.example.java_development.hometask.MySuper;

public class MySub extends MySuper {

    int i = 5;
    int x = 7;

    void method() {
        MySuper mySuper = new MySuper();
        System.out.print(mySuper.i);
        System.out.print(super.x);
    }
    public static void main(String[] args) {
        MySub ms = new MySub();
        ms.method();
    }
}