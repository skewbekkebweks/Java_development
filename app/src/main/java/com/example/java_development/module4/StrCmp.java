package com.example.java_development.module4;

import java.util.Comparator;

class StrCmp implements Comparator<String> {
    @Override
    public int compare(String s, String t1) {
        int l1 = s.length();
        int l2 = t1.length();

        if (l1 != l2) {
            return l1 - l2;
        }

        return s.compareTo(t1);
    }
}
