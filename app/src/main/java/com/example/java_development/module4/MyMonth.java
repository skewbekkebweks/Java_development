package com.example.java_development.module4;

import java.util.Locale;
import java.util.Objects;

public class MyMonth implements Comparable<MyMonth> {
    private String month;
    private double temp;
    private int days;
    private boolean like;

    public MyMonth(String month, double temp, int days) {
        this.setMonth(month);
        this.setTemp(temp);
        this.setDays(days);
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month.toLowerCase(Locale.ROOT);
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    @Override
    public boolean equals(Object m2) {
        if (this == m2) return true;
        if (!(m2 instanceof MyMonth)) return false;
        MyMonth myMonth = (MyMonth) m2;
        return Double.compare(myMonth.temp, temp) == 0 && days == myMonth.days && Objects.equals(month, myMonth.month);
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, temp, days, like);
    }

    @Override
    public int compareTo(MyMonth myMonth) {
        return Integer.compare(this.hashCode(), myMonth.hashCode());
    }

    @Override
    public String toString() {
        return month;
    }
}
