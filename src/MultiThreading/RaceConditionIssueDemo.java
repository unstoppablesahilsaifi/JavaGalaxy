

/**
 * 🎯 Concept: Race Condition
 * When multiple threads modify a shared variable (counter) at the same time,
 * data inconsistency occurs due to lack of synchronization.
 *
 * In this example, both threads increment the same counter 1000 times each.
 * Expected = 2000, but Actual < 2000 (Race Condition)
 */

package MultiThreading;

// Shared counter class
class Counter {
    int count = 0;

    void increment() {
        count++;   // ❌ Not thread-safe
    }
}

// Runnable class (run method yahan hai)
class IncrementTask implements Runnable {

    private Counter counter; // shared object

    // Constructor → same Counter object pass hoga
    public IncrementTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            counter.increment(); // thread-unsafe increment
        }
    }
}

// Main class
public class RaceConditionIssueDemo {

    public static void main(String[] args) throws InterruptedException {

        Counter c = new Counter();         // shared resource
        IncrementTask task = new IncrementTask(c);  // same task for both threads

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count (without sync): " + c.count);
        // Expected: 2000
        // Actual: <2000 due to race condition
    }
}
