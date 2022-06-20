package com.leeheefull.thread.ex01_basic;

public class MyTest {
    public static void main(String[] args) {
        // 상속을 통해 스레드를 확장하고 사용
        MyThread thread1 = new MyThread();

        // Runnable 인터페이스 구현체를 스레드에 주입하여 사용
        Thread thread2 = new Thread(new MyRunnable());

        // Runnable 익명함수로 사용 (두 번째 방법과 비슷하지만, 재사용 X)
        Thread thread3 = new Thread(() -> System.out.println("Functional interface Run!!"));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
