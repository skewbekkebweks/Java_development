package com.example.java_development.module4;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedMain {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("123");
        list.add("1234");
        list.add("12345");
        list.add("123456");
        list.add("1234567");
        list.add("12345678");
        for (String s :
                list) {
            System.out.println(s);
        }

        MyLinkedList<String> list1 = new MyLinkedList<>();
        list1.add("123");
        list1.add("456");
        list1.add("789");
        ListIterator<String> li = list1.listIterator();
        while (li.hasNext()) {
            li.next();
        }
    }
}
