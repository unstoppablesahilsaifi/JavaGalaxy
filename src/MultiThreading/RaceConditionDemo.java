class Counter {
    int count = 0;

    void increment() {
        count++; // NOT THREAD SAFE (3-step operation)
    }
}

public class RaceConditionDemo {
    public static void main(String[] args) throws Exception {

        Counter counter = new Counter();

        // Thread 1
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) counter.increment();
        });

        // Thread 2
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) counter.increment();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count = " + counter.count);
        // Expected = 10000
        // Actual = random (9200, 8700, etc.)
    }
}
