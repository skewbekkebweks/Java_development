package com.example.java_development.module3;

public class Shop extends Thread {
    static class Client {
        Integer balance;
        public Client(int balance) {
            this.balance = balance;
        }
        public synchronized void changeBalance(int amount) {
            if (this.balance > amount) {
                this.balance -= amount;
            } else {
                System.out.println("No money");
            }
            System.out.println(this.balance);
        }
    }
    public Client client;
    public void run() {
        client.changeBalance(70);
    }
}
