package com.example.java_development.module3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SchoolMain {
    public static void main(String[] args) {
        Student student3 = new Student("Ян", 3);
        Student student5 = new Student("Дэн", 4);
        try {
            File file = new File("C:\\Users\\Samsung1\\AndroidStudioProjects\\Java_development\\app\\src\\main\\java\\com\\example\\java_development\\module3\\in.txt");
            Scanner scanner = new Scanner(file);
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            student3.division(a, b);
            student5.division(a, b);
        } catch (MyFirstException e) {
            System.out.println("Ошибка функции деления. Пожалуйста, обновите приложение");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
