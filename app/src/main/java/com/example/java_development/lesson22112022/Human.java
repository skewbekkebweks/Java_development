package com.example.java_development.lesson22112022;

public class Human extends Unit {
    public Human(String name, String ip) {
        super(name, ip);
    }

    @Override
    public void move() {
        System.out.println("Идёт челвоек");
    }
}
