package MultiThreading;

public class MT_4_ProcessVsThreadDemo {
    private static int counter = 0; // shared variable (in heap)
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 3; i++) {
                counter++;
                System.out.println(Thread.currentThread().getName() + " updated counter to: " + counter);
                try { Thread.sleep(200); } catch (InterruptedException e) {}
            }
        };

        Thread t1 = new Thread(task, "Worker-1");
        Thread t2 = new Thread(task, "Worker-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final counter value: " + counter);

    }
}
/*sometimes, output may skip numbers or print same twice (like final counter 5 or 4).
Why?
Because both threads share the same variable counter (in heap) and may update it simultaneously — without synchronization.
👉 Ye hi Race Condition hoti hai*/