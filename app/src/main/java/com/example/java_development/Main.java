package com.example.java_development;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        int[] c = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (b > c[a - 1] || a > 12 || a < 1 || b < 1) {
            System.out.println(-1);
            return;
        }
        int left = 365;
        left -= b;
        for (int i = 0; i < a - 1; i++) {
            left -= c[i];
        }
        System.out.println(left);
    }
}
