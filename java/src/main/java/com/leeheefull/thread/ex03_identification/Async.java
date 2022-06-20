package com.leeheefull.thread.ex03_identification;

public class Async {
    public static void main(String[] args) {
        Runnable runnable = Async::print;

        Thread thread1 = new Thread(runnable);
        thread1.setName("Music");
        Thread thread2 = new Thread(runnable);
        thread2.setName("Download");

        thread1.start();
        thread2.start();
        print();
    }

    private static void print() {
        Thread currentThread = Thread.currentThread();

        for (int i = 1; i <= 50; i++) {
            try {
                Thread.sleep(20);
                System.out.println("id: " + currentThread.getId() + ", name: " + currentThread.getName() + "-> " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
