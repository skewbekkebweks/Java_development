package com.example.java_development.module4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
//        String[] a = new String[10];
//        System.out.println(a);
//        System.out.println(Arrays.toString(a));
//        Integer[] a2 = {2, 1, 3, 46, 0};
//        Arrays.sort(a2, new ReverseCMP());
//
//        System.out.println(Arrays.toString(a2));
        Queue<String> queue = new LinkedList<>();
        queue.offer("Первый");
        queue.offer("Второй");
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        hehe();
    }

    public static void hehe() throws Exception {
        throw new Exception("dfklg");
    }

    public static void v1() {

    }

    static class ReverseCMP implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            return - (i1 - i2);
        }
    }

    static class LastCMP implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            i1 %= 10;
            i2 %= 10;
            return - (i1 - i2);
        }
    }
}
