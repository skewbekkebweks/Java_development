package com.example.java_development.lesson22112022;

public class Unit {
    protected int hp;
    protected String name;
    protected String ip;

    public Unit(String name, String ip) {
        this.hp = 100;
        this.name = name;
        this.ip = ip;
    }

    public void printInfo() {
        System.out.println("NAME = " + this.name);
        System.out.println("IP = " + this.ip);
        System.out.println("HP = " + this.hp);
    }

    public void attack(Unit unit) {
        unit.hp -= 50;
        System.out.println("Мы атаковали " + unit.name);
    }
}
