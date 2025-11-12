package MultiThreading;

// Shared counter class
class Counter {
    int count = 0;

    // ❌ Without synchronization
    void incrementWithoutSync() {
        count++;
    }

    // ✅ With synchronization
    synchronized void incrementWithSync() {
        count++;
    }
}

// ---------------- Runnable Class 1 (Unsafe Task) ----------------
class UnsafeTask implements Runnable {
    Counter counter;

    public UnsafeTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        // Each thread tries to increment shared counter 1000 times
        for (int i = 1; i <= 1000; i++) {
            counter.incrementWithoutSync();
        }
    }
}

// ---------------- Runnable Class 2 (Safe Task) ----------------
class SafeTask implements Runnable {
    Counter counter;

    public SafeTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        // Each thread tries to increment shared counter 1000 times
        for (int i = 1; i <= 1000; i++) {
            counter.incrementWithSync();
        }
    }
}

// ---------------- Main Class ----------------
public class SynchronizationDemo {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        // ---------------- Without Synchronization ----------------
        Runnable unsafe = new UnsafeTask(counter);
        Thread t1 = new Thread(unsafe, "Thread-1");
        Thread t2 = new Thread(unsafe, "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("❌ Without Synchronization, final count: " + counter.count);
        // Expected < 2000 (due to race condition)


        // ---------------- With Synchronization ----------------
        counter.count = 0; // reset counter

        Runnable safe = new SafeTask(counter);
        Thread t3 = new Thread(safe, "Thread-3");
        Thread t4 = new Thread(safe, "Thread-4");

        t3.start();
        t4.start();

        t3.join();
        t4.join();

        System.out.println("✅ With Synchronization, final count: " + counter.count);
        // Expected = 2000 (thread-safe)
    }
}
