package com.example.java_development.module3;

public class ThreadMain {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Shop shop2 = new Shop();

        Shop.Client client = new Shop.Client(100);
        shop.client = client;
        shop2.client = client;

        shop.start();
        shop2.start();
    }
}
