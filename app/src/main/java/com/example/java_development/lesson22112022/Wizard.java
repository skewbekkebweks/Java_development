package com.example.java_development.lesson22112022;

public class Wizard extends Unit {
    protected int mana;

    public Wizard(String name, String ip, int mana) {
        super(name, ip);
        this.mana = mana;
    }

    @Override
    public void attack(Unit unit) {
        unit.hp -= 60;
        System.out.println("-60hp у противника " + unit.name);
    }

    @Override
    public void move() {
        System.out.println("Идёт волшебник");
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("MANA = " + this.mana);
    }
}