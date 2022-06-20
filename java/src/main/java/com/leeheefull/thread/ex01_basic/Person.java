package com.leeheefull.thread.ex01_basic;

public class Person extends Animal implements Runnable {
    @Override
    public void run() {
        System.out.println("일과 시작");
    }
}
