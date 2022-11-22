package com.example.java_development.lesson22112022;

public class UnitsGame {
    public static void main(String[] args) {
        Robot r = new Robot("r2d2", "1.1.1.1", 100);
        Wizard w = new Wizard("Gandalf", "2.2.2.2", 10);
        Unit u = new Unit("Vasya", "3.3.3.3");

        r.attack(w);
        u.attack(r);

        Unit[] list = {w, r, u};
        for (Unit unit : list) {
            unit.printInfo();
        }
    }
}
