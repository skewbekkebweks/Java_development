package com.example.java_development;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        double b1 = (double) b;
        String div = a != 0 ? String.format("%.1f", -b1 / a) : "0";
        if (a > 0 && b >= 0) {
            System.out.println("any x");
        } else if (a > 0 && b < 0) {
            System.out.println("x<-" + div + " or x>" + div);
        } else if (a == 0 && b > 0) {
            System.out.println("any x");
        } else if (a == 0 && b <= 0) {
            System.out.println("no such x");
        } else if (a < 0 && b > 0) {
            System.out.println("-" + div + "<x<" + div);
        } else if (a < 0 && b <= 0) {
            System.out.println("no such x");
        }
    }
}
