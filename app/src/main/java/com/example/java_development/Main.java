package com.example.java_development;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите, пожалуйста, первую дробь");
        int An = sc.nextInt();
        int Ad = sc.nextInt();
        System.out.println("Введите, пожалуйста, вторую дробь");
        int Bn = sc.nextInt();
        int Bd = sc.nextInt();
        int Cn = An + 3 * Bn;
        int Cd = Bn;
        int Dn = 3 * Bn - Bd;
        int Dd = 3 * Bd;
        int En = Cn * Dd;
        int Ed = Cd * Dn;
        System.out.println("Результат:");
        System.out.println(1.0 * En / Ed);
        if (En / Ed == 0) {
            System.out.println(En);
            System.out.println("---");
            System.out.println(Ed);
        } else {
            System.out.println("   " + En % Ed);
            System.out.println(En / Ed + "-----");
            System.out.println("   " + Ed);
        }
    }
}
