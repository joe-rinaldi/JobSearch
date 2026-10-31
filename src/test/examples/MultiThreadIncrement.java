package examples;

import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadIncrement {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static int staticInteger = 0;
    private static int synchronizedInteger = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final counter value: " + atomicInteger.get());
        System.out.println("Final synchronized counter value: " + synchronizedInteger);
        System.out.println("Final static counter value: " + staticInteger);
    }

    private static  void increment() {
        atomicInteger.incrementAndGet();
        staticInteger++;
        synchronized (MultiThreadIncrement.class) {
            synchronizedInteger++;
        }
    }
}
