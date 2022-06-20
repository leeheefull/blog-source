package com.leeheefull.thread.ex04_time_wait;

public class Async {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            Thread currentThread = Thread.currentThread();
            System.out.println(toStringThread(currentThread) + " -> print 전");
            print();
            System.out.println(toStringThread(currentThread) + " -> print 후");
        };

        Thread thread1 = new Thread(runnable);
        thread1.setName("Game");
        Thread thread2 = new Thread(runnable);
        thread2.setName("Memo");

        System.out.println(toStringThread(thread1) + " -> start 전");
        System.out.println(toStringThread(thread2) + " -> start 전");

        thread1.start();
        thread2.start();

        System.out.println(toStringThread(thread1) + " -> start 후");
        System.out.println(toStringThread(thread2) + " -> start 후");

        // 보조 thread가 종료 될 때까지 일시정지하고 종료되면 "35line~"을 실행
        if (thread1.isAlive() && thread2.isAlive()) {
            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(toStringThread(thread1) + " -> thread 종료");
        System.out.println(toStringThread(thread2) + " -> thread 종료");
        System.out.println("############### Main thread end ###############");
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
