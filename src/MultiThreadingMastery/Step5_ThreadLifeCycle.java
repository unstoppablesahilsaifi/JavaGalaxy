package MultiThreadingMastery;

/**
 * =========================================================
 * Topic: Thread Lifecycle (VERY VERY IMPORTANT)
 * ONE LINE ME THREAD LIFECYCLE
 * ---------------------------------------------------------
 * THREAD STATES (JAVA)
 * ---------------------------------------------------------
 * Java me logically ye states hoti hain:
 *
 * 1️⃣ NEW
 * 2️⃣ RUNNABLE
 * 3️⃣ RUNNING
 * 4️⃣ WAITING / BLOCKED
 * 5️⃣ TERMINATED (DEAD)
 *
 * ---------------------------------------------------------
 * LIFECYCLE FLOW (IMAGINE)
 * ---------------------------------------------------------
 *
 * NEW --> RUNNABLE --> RUNNING --> TERMINATED
 *            |           |
 *            |           |
 *         WAITING <--- BLOCKED
 *
 * ---------------------------------------------------------
 * 1️⃣ NEW STATE
 * ---------------------------------------------------------
 * Jab thread ka object create hota hai:
 *
 * Thread t = new Thread();
 *
 * Thread object bana
 * start() call nahi hua
 *
 * STATE = NEW
 *
 * ---------------------------------------------------------
 * 2️⃣ RUNNABLE STATE
 * ---------------------------------------------------------
 * Jab hum:
 *
 * t.start();
 *
 * Thread run hone ke liye READY hai
 * CPU milna baaki hai
 *
 * IMPORTANT:
 * RUNNABLE ≠ RUNNING
 * Scheduler decide karta hai kab CPU milega
 *
 * ---------------------------------------------------------
 * RUNNING STATE
 * ---------------------------------------------------------
 * Thread actually CPU pe execute ho rahi hoti hai
 *
 * JVM RUNNING state ko directly expose nahi karti
 * Ye internally manage hoti hai
 *
 * ---------------------------------------------------------
 * 4️⃣ WAITING / BLOCKED STATE
 * ---------------------------------------------------------
 *
 *  WAITING (TEMPORARY PAUSE)
 * --------------------------------
 * Thread khud ruk jaati hai kuch time ke liye:
 *
 * - sleep()
 * - join()
 * - wait()
 *
 * CPU release ho jaata hai
 *
 *  BLOCKED (LOCK KA WAIT)
 * --------------------------------
 * synchronized block me jab lock nahi milta:
 *
 * synchronized(obj) {
 *     // agar lock nahi mila -> BLOCKED
 * }
 *
 * Lock milte hi thread wapas RUNNABLE me jaati hai
 *
 * ---------------------------------------------------------
 * 5️⃣ TERMINATED (DEAD) STATE
 * ---------------------------------------------------------
 * Jab:
 *
 * run() method complete ho jaata hai
 *
 * Thread ka kaam khatam
 * Thread dead ho jaati hai
 *
 * Dobara start karna allowed nahi
 *
 * ---------------------------------------------------------
 *  INTERVIEW TRAP
 * ---------------------------------------------------------
 * Q: Can we restart a dead thread?
 *
 * ❌ NO
 * ❌ IllegalThreadStateException aata hai
 *
 * ---------------------------------------------------------
 * CODE DEMO (RESTART NOT ALLOWED)
 * ---------------------------------------------------------
 *
 * class Test extends Thread {
 *     public void run() {
 *         System.out.println("Running");
 *     }
 *
 *     public static void main(String[] args) {
 *         Test t = new Test();
 *         t.start();
 *         t.start(); // ❌ Exception
 *     }
 * }
 *
 * ---------------------------------------------------------
 *  STATE SUMMARY TABLE
 * ---------------------------------------------------------
 * NEW        -> Thread created, not started
 * RUNNABLE   -> Ready to run, waiting for CPU
 * RUNNING    -> Currently executing
 * WAITING    -> Temporarily paused
 * BLOCKED    -> Waiting for lock
 * DEAD       -> Execution finished

 */

public class Step5_ThreadLifeCycle {

    public static void main(String[] args) {

        // NEW STATE
        Thread t = new Thread(() -> {
            System.out.println("Thread running");
        });

        // RUNNABLE STATE
        t.start();

        // Note:
        // RUNNING, WAITING, BLOCKED states
        // JVM internally manage karti hai
    }
}
