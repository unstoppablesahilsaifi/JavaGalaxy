
package MultiThreading;

public class MyThread implements Runnable {

    // 🧩 run(): this code runs when the thread starts using start()
    @Override
    public void run() {
        System.out.println("Thread is running...");
        try {
            // Thread.sleep(2000) = current thread 2 sec ke liye pause karega
            // but thread alive rehta hai (TIMED_WAITING state me chala jata hai)
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // 1️⃣ Create Runnable object
        MyThread myThread = new MyThread();

        // 2️⃣ Pass runnable to Thread constructor
        Thread t1 = new Thread(myThread);

        // ------------------ THREAD LIFECYCLE DEMO ------------------

        // (A) Abhi tak t1.start() call nahi hua → state = NEW
        System.out.println("State A (Before start): " + t1.getState());  // NEW

        // (B) start() → JVM ek new thread create karta hai
        t1.start();
        System.out.println("State B (Just after start): " + t1.getState());  // RUNNABLE

        // (C) Main thread ko 1 sec sula dete hain, taaki t1 run kare
        Thread.sleep(1000);// thodi der k liye rukta h per lock release nhi krta
        // Abhi t1 "Thread.sleep(2000)" ke andar hoga → TIMED_WAITING
        System.out.println("State C (After 1 sec): " + t1.getState());

        // (D) join() = main thread waits until t1 completes
        // jis thread ne join() call kiya hai (yahan main), vo ruk jaata hai
        // jab tak t1 COMPLETED (TERMINATED) state me nahi chala jata
        t1.join();

        // Ab t1 khatam ho chuka hai → TERMINATED
        System.out.println("State D (After join): " + t1.getState());
    }
}
