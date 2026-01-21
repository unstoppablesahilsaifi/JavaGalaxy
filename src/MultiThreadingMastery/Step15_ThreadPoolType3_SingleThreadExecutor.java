package MultiThreadingMastery;
//SINGLE THREAD EXECUTOR (ORDER GUARANTEE 🔐)
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SingleTask implements Runnable {
    private final String name;

    SingleTask(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(
                name + " executed by " +
                        Thread.currentThread().getName()
        );
    }
}

public class Step15_ThreadPoolType3_SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService executor =
                Executors.newSingleThreadExecutor();

        executor.execute(new SingleTask("Task-1"));
        executor.execute(new SingleTask("Task-2"));
        executor.execute(new SingleTask("Task-3"));

        executor.shutdown();
    }
}
/*Real Use Case

Logging

File writing

Payment processing

Sequential tasks*/