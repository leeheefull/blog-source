package com.leeheefull.thread.ex01_basic;

public class ExtAndImplTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new Person());
        thread.start();
    }
}
