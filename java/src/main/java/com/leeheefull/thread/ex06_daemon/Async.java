package com.leeheefull.thread.ex06_daemon;

public class Async {
    public static void main(String[] args) {
        Runnable runnable = Async::print;

        Thread thread1 = new Thread(runnable);
        thread1.setName("Game");
        Thread thread2 = new Thread(runnable);
        thread2.setName("BGM");
        thread2.setDaemon(true);

        thread1.start();
        thread2.start();
        print();
    }

    private static void print() {
        Thread currentThread = Thread.currentThread();

        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(50);
                System.out.println(toStringThread(currentThread) + " -> " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static String toStringThread(Thread thread) {
        return "id: " + thread.getId()
                + "\t name: " + thread.getName()
                + "\t\t state: " + thread.getState();
    }
}
