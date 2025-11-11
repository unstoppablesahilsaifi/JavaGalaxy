package MultiThreading;

public class MT_2_MultiThreadDemo {
        public static void main(String[] args) {
            Thread t1 = new Thread(() -> task1()); // Lambda Runnable
            Thread t2 = new Thread(() -> task2());

            t1.start(); // Start both threads
            t2.start();
        }

        static void task1() {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Task 1 - Step " + i);
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        }

        static void task2() {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Task 2 - Step " + i);
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        }
    }


    /*Observation:

Ab dono threads ek saath chal rahe hain.
Output interleaved hoga (kabhi Task1 pehle print karega, kabhi Task2), kyunki scheduling JVM/OS pe depend karta hai.
*/