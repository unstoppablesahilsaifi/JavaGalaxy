package MultiThreading;

/*
 *  ===============================================
 *      Java Multithreading Giant Practice File
 *      All Thread Methods Covered in One File
 *      start() | run() | sleep() | join() | yield()
 *      isAlive() | currentThread() | priority | daemon
 *  ===============================================
 */

class WorkerThread extends Thread {

    public WorkerThread(String name) {
        super(name); // Thread ka naam set kar diya
    }

    @Override
    public void run() {
        System.out.println("Running: " + Thread.currentThread().getName());

        for (int i = 1; i <= 3; i++) {
            try {

                // --- sleep() Demo ---
                // Ye thread ko 500ms ke liye sula dega
                Thread.sleep(500);

                System.out.println("  " + Thread.currentThread().getName() +
                        " executing step " + i);

                // --- yield() Demo ---
                // Scheduler ko suggest karte hain ki agar koi aur ready thread hai to usko chalao
                Thread.yield();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Finished: " + Thread.currentThread().getName());
    }
}


public class AllThreadMethodsDemo {

    public static void main(String[] args) throws Exception {

        System.out.println("Main thread: " + Thread.currentThread().getName());

        // ==========================================================
        // 1. start() vs run() Difference
        // ==========================================================

        WorkerThread t1 = new WorkerThread("T1-Normal-Thread");

        System.out.println("\n--- start() vs run() Demo ---");

        System.out.println("Calling run() directly (NO NEW THREAD)");
        t1.run(); // run() current main thread me hi chalta hai

        System.out.println("Calling start() (CREATES NEW THREAD)");
        t1.start(); // NEW THREAD created

        // ==========================================================
        // 2. isAlive() Demo
        // ==========================================================

        System.out.println("\n--- isAlive() Demo ---");
        System.out.println("T1 alive before join? " + t1.isAlive());

        // ==========================================================
        // 3. join() Demo
        // ==========================================================

        System.out.println("\n--- join() Demo ---");
        System.out.println("Main thread waiting for T1 to finish...");
        t1.join();  // Main thread yahan ruk jayega

        System.out.println("T1 alive after join? " + t1.isAlive());


        // ==========================================================
        // 4. Priority Demo
        // ==========================================================

        System.out.println("\n--- Priority Demo ---");

        WorkerThread t2 = new WorkerThread("T2-HighPriority");
        WorkerThread t3 = new WorkerThread("T3-LowPriority");

        t2.setPriority(Thread.MAX_PRIORITY); // 10
        t3.setPriority(Thread.MIN_PRIORITY); // 1

        System.out.println("T2 Priority: " + t2.getPriority());
        System.out.println("T3 Priority: " + t3.getPriority());

        t2.start();
        t3.start();


        // ==========================================================
        // 5. Daemon Thread Demo
        // ==========================================================

        System.out.println("\n--- Daemon Thread Demo ---");

        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon running (background task)...");
                try { Thread.sleep(300); } catch (Exception e) {}
            }
        }, "DAEMON-THREAD");

        // Daemon thread ko start se pehle daemon set karna zaroori hai
        daemonThread.setDaemon(true);
        daemonThread.start();


        // ==========================================================
        // 6. currentThread() Demo
        // ==========================================================

        System.out.println("\n--- currentThread() Demo ---");
        System.out.println("Currently Running: " + Thread.currentThread().getName());


        // ==========================================================
        // 7. Final join() to wait for user threads
        // ==========================================================

        t2.join();
        t3.join();

        System.out.println("\nMain thread completed.");
        System.out.println("Program exiting... Daemon thread auto-stop ho jayega.");
    }
}

