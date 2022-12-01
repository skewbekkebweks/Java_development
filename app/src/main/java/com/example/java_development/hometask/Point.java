package com.example.java_development.hometask;

import java.util.Scanner;

public class Point {
    double x, y;
    public static void main(String [] args){
        //создаем два объекта класса Point
        Point p1 = new Point();
        Point p2 = new Point();

        //вводим и выводим две точки
        p1.input();
        System.out.println("Point 1:");
        p1.printPoint();

        p2.input();
        System.out.println("Point 2:");
        p2.printPoint();

        //выводим расстояние между точками
        System.out.println("Distanse:" + p1.getDistance(p2));

        //перемещаем одну из точек
        p1.move(1, 2);

        //выводим новое положение точки
        System.out.println("Point 1 after move:");
        p1.printPoint();

        //выводим новое расстояние между точками
        System.out.println("New distanse:" + p1.getDistance(p2));
    }
    void move(double dx, double dy) {
        x += dx;
        y += dy;
    }
    void printPoint() {
        System.out.printf("(%s; %s)%n", x, y);
    }
    void input() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter x: ");
        double x = in.nextDouble();
        System.out.print("Enter y: ");
        double y = in.nextDouble();
        move(x, y);
    }

    double getDistance(Point a) {
        return Math.sqrt(Math.pow(x - a.x, 2) + Math.pow(y - a.y, 2));
    }

}
