package com.example.java_development;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n, m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int temp = sc.nextInt();
            int left, right;
            int start_ind = Arrays.binarySearch(array, temp);

            left = start_ind;
            right = start_ind;
            try {
                while (array[left] == temp) left--;
            } catch (ArrayIndexOutOfBoundsException ignored) {}
            finally {
                left++;
            }
            try {
                while (array[right] == temp) right++;
            } catch (ArrayIndexOutOfBoundsException ignored) {}
            finally {
                right--;
            }
            int l = array.length - 1;
            if (left < 0 || left > l || right < 0 || right > array.length - 1) {
                System.out.println(0);
            } else {
                System.out.println((left + 1) + " " + (right + 1));
            }
        }

    }
}
