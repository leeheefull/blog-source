package thread.ex05_interrupt;

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

        System.out.println(toStringThread(thread1) + " -> start 전");
        thread1.start();
        System.out.println(toStringThread(thread1) + " -> start 후");

        // 보조 thread가 2초 동안 일시정지하고 "26line~"을 실행
        if (thread1.isAlive()) {
            try {
                thread1.join(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread1.interrupt();
        }

        System.out.println(toStringThread(thread1) + " -> thread 종료");
        System.out.println("############### Main thread end ###############");
    }

    private static void print() {
        Thread currentThread = Thread.currentThread();

        for (int i = 1; i <= 10000; i++) {
            if (currentThread.isInterrupted()) {
                System.out.println("############### Interrupt ###############");
                return;
            }
            System.out.println(toStringThread(currentThread) + " -> " + i);
        }
    }

    private static String toStringThread(Thread thread) {
        return "id: " + thread.getId()
                + "\t name: " + thread.getName()
                + "\t\t state: " + thread.getState();
    }
}
