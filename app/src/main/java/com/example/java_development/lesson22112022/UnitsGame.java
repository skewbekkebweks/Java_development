package com.example.java_development.lesson22112022;

public class UnitsGame {
    public static void main(String[] args) {
        Robot r = new Robot("r2d2", "1.1.1.1", 100);
        Wizard w = new Wizard("Gandalf", "2.2.2.2", 10);
        Unit u = new Unit("Vasya", "3.3.3.3"){
            @Override
            public void move() {

            }
        };

        Speakable s = new Speakable() {
            @Override
            public void speak() {
                System.out.println("Я умею говорить, хотя меня никак не зовут");
            }
        };

        s.speak();
        u.speak();
        u.move();

        r.attack(w);
        u.attack(r);

        Unit[] list = new Unit[10];
        for (int i = 0; i < list.length; i++) {
            list[i] = Math.random() > 0.5
                    ? new Robot("Robot" + i, "2.2", 100)
                    : new Wizard("Mag" + i, "3.3", 80);
            list[i].move();
        }
        for (Unit unit : list) {
            unit.printInfo();
        }
    }
}
