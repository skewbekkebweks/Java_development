package com.example.java_development.module3;

public class Car {
    public static int wheelCount = 4;
    private String model = "BMW";
    public void ride() {
        System.out.println("Ride");
    }
    public class Wheel {
        private int radius = 17;
    }
    public enum Months {
        JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC
    }
}
