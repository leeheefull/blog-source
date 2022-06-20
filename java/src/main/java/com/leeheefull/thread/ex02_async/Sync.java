package com.leeheefull.thread.ex02_async;

public class Sync {
    public static void main(String[] args) {
        print1();
        print2();
    }

    private static void print1() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("method1: " + i);
        }
    }

    private static void print2() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("method2: " + i);
        }
    }
}
