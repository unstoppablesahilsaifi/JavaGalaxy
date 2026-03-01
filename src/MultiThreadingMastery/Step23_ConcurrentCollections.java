package MultiThreadingMastery;

import java.util.*;
import java.util.concurrent.*;

/*
=========================================================
LEVEL 7 – STEP 18
Concurrent Collections – Complete Demonstration
Everything in ONE file 🔥
=========================================================

ConcurrentHashMap (MOST IMPORTANT 🔥)
Kya karta hai?
•	Thread-safe map
•	Whole map lock nahi hota
•	Sirf required bucket / segment lock hota hai

*/

public class Step23_ConcurrentCollections {

    public static void main(String[] args) throws Exception {

        System.out.println("========== 1️⃣ HashMap Problem ==========");
        hashMapProblemDemo();

        Thread.sleep(2000);

        System.out.println("\n========== 2️⃣ ConcurrentHashMap Solution ==========");
        concurrentHashMapDemo();

        Thread.sleep(2000);

        System.out.println("\n========== 3️⃣ CopyOnWriteArrayList Demo ==========");
        copyOnWriteListDemo();

        Thread.sleep(2000);

        System.out.println("\n========== 4️⃣ BlockingQueue Producer-Consumer ==========");
        blockingQueueDemo();
    }

    // ❌ HashMap Multithreading Problem
    static void hashMapProblemDemo() throws InterruptedException {

        Map<Integer, String> map = new HashMap<>();

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                map.put(i, Thread.currentThread().getName());
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("HashMap Size (expected 10000): " + map.size());
        // Often wrong due to race condition
    }

    // ✅ ConcurrentHashMap Safe Version
    static void concurrentHashMapDemo() throws InterruptedException {

        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                map.put(i, Thread.currentThread().getName());
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("ConcurrentHashMap Size: " + map.size());
    }

    // ✅ CopyOnWriteArrayList Demo
    static void copyOnWriteListDemo() throws InterruptedException {

        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

        list.add(1);
        list.add(2);

        Runnable reader = () -> {
            for (Integer i : list) {
                System.out.println("Reading: " + i);
            }
        };

        Runnable writer = () -> {
            list.add(3);
            System.out.println("Added 3 safely");
        };

        Thread t1 = new Thread(reader);
        Thread t2 = new Thread(writer);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    // ✅ BlockingQueue Producer–Consumer
    static void blockingQueueDemo() {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        Runnable producer = () -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    queue.put(i);
                    System.out.println("Produced: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer = () -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    int value = queue.take();
                    System.out.println("Consumed: " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
