package com.example.java_development.module3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int K = 1, A = 100, P = 50;
        System.out.println("Выберите цвет: синий, жёлтый, красный");
        String s1 = in.next();
        String s2;
        if (s1.equals("синий")) {
            System.out.println("вы выбрали синий цвет: K+=1");
            K += 1;
            System.out.println("выберите цвет: жёлтый, красный");
            s2 = in.next();
        } else if (s1.equals("жёлтый")) {
            System.out.println("вы выбрали жёлтый цвет: A+=100");
            A += 100;
            System.out.println("выберите цвет: синий, красный");
            s2 = in.next();
        } else if (s1.equals("красный")) {
            System.out.println("вы выбрали красный цвет: P+=50");
            P += 50;
            System.out.println("выберите цвет: синий, жёлтый");
            s2 = in.next();
        } else {
            System.out.println("Неправильный выбор!!!!!");
            return;
        }
        if (s2.equals("синий")) {
            System.out.println("вы выбрали синий цвет: K+=1");
            K += 1;
        } else if (s2.equals("жёлтый")) {
            System.out.println("вы выбрали жёлтый цвет: A+=100");
            A += 100;
        } else if (s2.equals("красный")) {
            System.out.println("вы выбрали красный цвет: P+=50");
            P += 50;
        } else {
            System.out.println("Неправильный выбор!!!!!");
            return;
        }
        System.out.println("K = " + K + "\nA = " + A + "\nP = " + P);
    }
}
