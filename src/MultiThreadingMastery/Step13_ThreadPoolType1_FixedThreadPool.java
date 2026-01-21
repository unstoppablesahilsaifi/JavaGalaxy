package MultiThreadingMastery;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//Fixed number of threads
// Task class (bahar)
class FixedTask implements Runnable {
    private final String name;

    FixedTask(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(
                name + " executed by " +
                        Thread.currentThread().getName()
        );
    }
}

public class Step13_ThreadPoolType1_FixedThreadPool {
    public static void main(String[] args) {

        ExecutorService executor =
                Executors.newFixedThreadPool(2);

        executor.execute(new FixedTask("Task-1"));
        executor.execute(new FixedTask("Task-2"));
        executor.execute(new FixedTask("Task-3"));

        executor.shutdown();
    }
}


/*FixedThreadPool (MOST USED)
🔹 Kya hota hai?
ExecutorService executor =
    Executors.newFixedThreadPool(3);

Fixed number of threads (e.g. 3)
100 tasks aaye → queue me wait
Threads reuse hote hain

🧠 Real Use Case
Web server
REST APIs
Database calls
Production systems*/