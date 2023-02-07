package com.example.java_development.module3;

class Answer extends Thread {
    char chr;
    public Answer(char chr) {
        this.chr = chr;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print(this.chr);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
