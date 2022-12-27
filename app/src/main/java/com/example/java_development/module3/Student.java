package com.example.java_development.module3;

import java.util.Locale;

public class Student {
    private String name;
    private int rating;

    public Student(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public Integer division(int numerator, int denominator) throws MyFirstException {
        Integer r = null;
        try {
            r = numerator / denominator;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("Произошла ошибка" + name);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Проверь деление");
            throw new MyFirstException();
        } finally {
            System.out.println("The end");
        }
        if (rating >= 4) {
            return r;
        }
        System.out.println("Я не могу посчитать");
        return null;
    }
}
