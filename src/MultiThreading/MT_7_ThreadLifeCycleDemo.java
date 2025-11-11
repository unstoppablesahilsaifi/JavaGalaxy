package MultiThreading;

public class MT_7_ThreadLifeCycleDemo {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(getName() + " state inside run(): " + getState()); // should be RUNNABLE
            try {
                Thread.sleep(1000);  // moves to TIMED_WAITING
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " finished work.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();

        System.out.println("State after creation: " + t1.getState()); // NEW

        t1.start();
        System.out.println("State after start(): " + t1.getState()); // RUNNABLE

        Thread.sleep(100);  // give t1 some time to enter sleep()
        System.out.println("State during sleep(): " + t1.getState()); // TIMED_WAITING

        t1.join(); // wait for t1 to finish
        System.out.println("State after completion: " + t1.getState()); // TERMINATED
    }
}


/*🧠 1️⃣ Thread Lifecycle Overview

Java thread ke total 6 major states hote hain (JVM-level):

NEW  →  RUNNABLE  →  (WAITING / TIMED_WAITING / BLOCKED)  →  TERMINATED


Let’s break down har ek state ek simple line + real life example ke saath 👇

🧩 NEW

➡️ Thread abhi create hua hai, lekin start nahi hua.

“Thread ready hai, lekin abhi race me ghusa nahi.” 🏁

🧠 Example:

Thread t = new Thread();  // NEW

🧩 RUNNABLE

➡️ Thread start ho gaya hai (start() call hua), ab ready to run ya actually running ho sakta hai.

“Thread line me lag gaya CPU time ke liye.”

🧠 Example:

t.start();  // RUNNABLE

🧩 BLOCKED

➡️ Thread kisi lock ke release hone ka wait kar raha hai (synchronized block).

“Resource busy hai, mujhe lock milne ka wait karna padega.”

🧩 WAITING

➡️ Thread kisi condition ka indefinitely wait kar raha hai (e.g., wait(), join() without timeout).

“Main ruk gaya hoon jab tak koi mujhe notify nahi karega.”

🧩 TIMED_WAITING

➡️ Thread kisi condition ka fixed time tak wait kar raha hai (e.g., sleep(1000), join(500), wait(1000)).

“Main 1 second ke liye so raha hoon, fir khud uth jaunga.”

🧩 TERMINATED

➡️ Thread ka run() method complete ho gaya hai.

“Thread ne apna kaam complete kar diya, ab khatam.” ️*/