package com.example.java_development.module3;

import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        test();
    }

    static void test() throws IOException {
        for (int index = 0; index < 2; index++) {
            PrintWriter writer = new PrintWriter("/test");
            writer.print("test");
            writer.close();
        }
    }
}
