package com.example.java_development.test2;

public class Employee extends Person {
    public String company;
    public int experience;

    public Employee(String firstName, String lastName, String company, int experience) {
        super(firstName, lastName);
        this.company = company;
        if (experience < 0) experience = 0;
        this.experience = experience;
    }
}
