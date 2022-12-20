package com.example.java_development;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Integer iOb1 = 100;
        Integer iOb2 = 100;
        System.out.println(iOb1 == iOb2);

        Integer iOb3 = new Integer(120);
        Integer iOb4 = new Integer(120);
        System.out.println(iOb3 == iOb4);

        Integer iOb5 = 200;
        Integer iOb6 = 200;
        System.out.println(iOb5 == iOb6);

        Integer iOb7 = 200;
        Integer iOb8 = 200;
        System.out.println(iOb7.equals(iOb8));
    }
}
