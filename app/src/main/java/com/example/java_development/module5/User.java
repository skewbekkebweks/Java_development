package com.example.java_development.module5;

public class User {
    private String name;
    private String lastname;
    private String surname;
    private int school;

    public User(String name, String lastname, int school) {
        this.name = name;
        this.lastname = lastname;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        if (surname != null) return surname;
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSchool() {
        return school;
    }

    public void setSchool(int school) {
        this.school = school;
    }
}
