package com.leeheefull.thread.ex07_synchronization;

public class Async {
    private static int globalIndex = 0;

    public static void main(String[] args) {
        Runnable runnable = Async::print;

        Thread thread1 = new Thread(runnable);
        thread1.setName("Game");
        Thread thread2 = new Thread(runnable);
        thread2.setName("BGM");
        Thread thread3 = new Thread(runnable);
        thread3.setName("Memo");

        thread1.start();
        thread2.start();
        thread3.start();

        // 보조 thread가 2초 동안 일시정지하고 "26line~"을 실행
        try {
            thread1.join(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main end");
    }

    private static void print() {
        int index = 0;
        Thread currentThread = Thread.currentThread();

        for (int i = 1; i <= 100; i++) {
            if (currentThread.isInterrupted()) {
                System.err.println("요청이 들어와서 종료.");
                return;
            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                System.err.println("자다가 꺠어나서 종료.");
                return;
            }

            index++;
            globalIndex++;

            System.out.println(
                    "id: " + currentThread.getId()
                            + "\t name: " + currentThread.getName()
                            + "\t\t" + i
                            + "\t" + index
                            + "\t" + globalIndex
            );
        }
    }
}
