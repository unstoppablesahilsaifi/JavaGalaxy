package MultiThreadingMastery;

/**
 * Topic: Creating Thread in Java (2 Ways)
 *        + Why Runnable is Preferred Over Thread
 * ---------------------------------------------------------
 *  run() thread start nahi karta
 *  start() naya thread create karta hai
 *
 *  start() internally run() method ko call karta hai
 *
 * =========================================================
 * 🟢 WAY 1: EXTENDS THREAD (BASIC WAY)
 * =========================================================
 *
 * Easy to understand
 *  Real projects me avoid kiya jaata hai
 *
 * Example:
 */

class MyThreadUsingThreadClass extends Thread {

    @Override
    public void run() {
        System.out.println(
                "Thread class se thread chal rahi hai: "
                        + Thread.currentThread().getName()
        );
    }
}

/**
 * =========================================================
 *  WAY 2: IMPLEMENTS RUNNABLE (PROFESSIONAL WAY)
 * =========================================================
 *
 * Industry standard
 * Executor / ThreadPool ke saath perfect
 *
 * Example:
 */

class MyTaskUsingRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(
                "Runnable se thread chal rahi hai: "
                        + Thread.currentThread().getName()
        );
    }
}

/**
 * =========================================================
 * MAIN CLASS
 * =========================================================
 */

public class Step4_CreatingThread_TwoWays_AndWhyRunnable {

    public static void main(String[] args) {

        // -----------------------------
        // WAY 1: EXTENDS THREAD
        // -----------------------------
        MyThreadUsingThreadClass t1 = new MyThreadUsingThreadClass();
        t1.start(); // NEW THREAD create hoti hai


        // -----------------------------
        // WAY 2: IMPLEMENTS RUNNABLE
        // -----------------------------
        Thread t2 = new Thread(new MyTaskUsingRunnable());
        t2.start(); // NEW THREAD create hoti hai


        // -----------------------------
        // PROOF: run() vs start()
        // -----------------------------
        MyThreadUsingThreadClass t3 = new MyThreadUsingThreadClass();

        t3.run();   // Normal method call -> main thread
        t3.start(); // New thread -> Thread-n
    }
}

/**
 * =========================================================
 *  WHY THREAD CLASS SE THREAD BANANA ACHA KYU NAHI HAI?
 * =========================================================
 *
 * MULTIPLE INHERITANCE PROBLEM
 * ---------------------------------------------------------
 * Java multiple inheritance allow nahi karta
 *
 * Agar tu Thread class extend kare:
 *
 * class MyThread extends Thread {
 * }
 *
 * Tu kisi aur class ko extend nahi kar paayega
 *
 * ---------------------------------------------------------
 * BUSINESS LOGIC + THREAD LOGIC MIX HO JAATA HAI
 * ---------------------------------------------------------
 * Thread class extend karne par:
 * - Business logic (kya kaam karna hai)
 * - Thread control (kaise chalega)
 *
 *  Dono ek hi class me aa jaate hain
 * Code messy ho jaata hai

 * ---------------------------------------------------------
 * ✅ FINAL VERDICT (INTERVIEW LINE)
 * ---------------------------------------------------------
 * "We prefer Runnable over Thread because it avoids
 * multiple inheritance issues, separates business logic
 * from thread management, and works seamlessly with
 * Executor framework."
 *
 * =========================================================
 */
