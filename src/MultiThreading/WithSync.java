package MultiThreading;

class CounterSync {
    int count = 0;

    // synchronized → only one thread can update at a time
    synchronized void increment() {
        count++;
    }
}

public class WithSync {
    public static void main(String[] args) throws InterruptedException {

        CounterSync c = new CounterSync();

        // Thread 1 (run method INSIDE main)
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    c.increment();
                }
            }
        });

        // Thread 2 (run method INSIDE main)
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    c.increment();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count (with sync): " + c.count); // Always 2000
    }
}
