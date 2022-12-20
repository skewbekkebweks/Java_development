package com.example.java_development.test2;

class Unit {
    String name;
    int health;

    public Unit() {
        this.name = "Noname";
        this.health = 100;
    }

    public String toString() {
        return name + " " + health;
    }
}