package MultiThreadingMastery;
//Concept (FAST BUT RISKY)
//Thread needed → create
//Idle thread → reuse
//Idle 60 sec → destroy
//Unlimited threads
/*Kya hota hai?
ExecutorService executor =
    Executors.newCachedThreadPool();

Threads as needed
Idle thread → reuse
Idle > 60 sec → destroy
🧠 Real Use Case
Short-lived async tasks
Burst traffic
Lightweight jobs
❌ Risk
Unlimited threads
High traffic = 💣 memory issue
👉 Production me carefully*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CachedTask implements Runnable {
    private final String name;

    CachedTask(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(
                name + " executed by " +
                        Thread.currentThread().getName()
        );
    }
}

public class Step14_ThreadPoolType2_CachedThreadPool {

    public static void main(String[] args) {
        ExecutorService executor =
                Executors.newCachedThreadPool();
        //CachedThreadPool ka size FIXED nahi hota
        // Jitni zarurat, utni threads

        executor.execute(new CachedTask("Task-1"));
        executor.execute(new CachedTask("Task-2"));
        executor.execute(new CachedTask("Task-3"));

        executor.shutdown();
    }
}
/*❌ No fixed size
✅ Thread tab banti hai jab task aata hai
♻️ Idle thread reuse hoti hai
🗑️ 60 sec idle → thread destroy
👉 Isliye naam hai CACHED


ISILIYE DANGEROUS HAI
CachedThreadPool = unlimited threads
High traffic server
Burst load
Sudden 1000 requests
👉 JVM bolegi: “theek hai bhai, 1000 threads bana deta hoon”
👉 💥 Memory + CPU crash
*/