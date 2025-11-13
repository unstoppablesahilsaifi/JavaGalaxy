package MultiThreading;

/**
 * Demonstrates:
 * 1. Thread Naming (setName, getName)
 * 2. Thread Priority (setPriority, getPriority)
 *
 * Notes:
 * - Thread priority sirf scheduler ko HINT deti hai (no guarantee)
 * - Naming se debugging & logging easy hoti hai
 */

class MyThreadNamingAndPriority extends Thread {

    @Override
    public void run() {
        // Thread ka naam + priority print
        System.out.println(
                "Thread Running → Name: " + getName() +
                        ", Priority: " + getPriority()
        );
    }
}

public class ThreadNamingAndPriorityDemo {

    public static void main(String[] args) {

        // Thread objects create
        MyThreadNamingAndPriority t1 = new MyThreadNamingAndPriority();
        MyThreadNamingAndPriority t2 = new MyThreadNamingAndPriority();

        /**
         * --------------------------
         * THREAD NAMING (VERY USEFUL)
         * --------------------------
         */
        t1.setName("FastWorkerThread");
        t2.setName("SlowWorkerThread");

        /**
         * ----------------------------------
         * THREAD PRIORITY (1 to 10)
         * ----------------------------------
         * MAX_PRIORITY = 10 (Default: 5)
         * MIN_PRIORITY = 1
         *
         * High priority means THREAD IS MORE IMPORTANT,
         * but NOT guaranteed that it will run first.
         */
        t1.setPriority(Thread.MAX_PRIORITY); // 10
        t2.setPriority(Thread.MIN_PRIORITY); // 1

        // Starting threads
        t1.start();
        t2.start();
    }
}
