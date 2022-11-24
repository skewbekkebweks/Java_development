package com.example.java_development.lesson22112022;

public class Robot extends Unit {
    protected int armor;

    public Robot(String name, String ip, int armor) {
        super(name, ip);
        this.armor = armor;
    }

    @Override
    public void move() {
        System.out.println("Идёт робот");
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("ARMOR = " + this.armor);
    }
}
