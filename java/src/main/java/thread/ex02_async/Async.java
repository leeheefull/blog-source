package thread.ex02_async;

public class Async {
    public static void main(String[] args) {
        Thread thread1 = new Thread(Async::print);
        Thread thread2 = new Thread(Async::print);

        thread1.start();
        thread2.start();
    }

    private static void print() {
        for (int i = 1; i <= 50; i++) {
            try {
                Thread.sleep(20);
                System.out.println("thread1: " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
