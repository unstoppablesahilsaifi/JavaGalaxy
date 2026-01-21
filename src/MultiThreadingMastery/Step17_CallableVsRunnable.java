package MultiThreadingMastery;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
//Callable is similar to Runnable but can return a result and throw checked exceptions
/**
 * -----------------------------------------
 * Runnable Task (NO RESULT)
 * -----------------------------------------
 */
class RunnableTask implements Runnable {

    @Override
    public void run() {
        System.out.println(
                "Runnable running on " +
                        Thread.currentThread().getName()
        );
    }
}

/**
 * -----------------------------------------
 * Callable Task (RETURNS RESULT)
 * -----------------------------------------
 */
class CallableTask implements Callable<Integer> {

    @Override
    public Integer call() {
        System.out.println(
                "Callable running on " +
                        Thread.currentThread().getName()
        );
        return 10 + 20;
    }
}

/**
 * -----------------------------------------
 * Main Class
 * -----------------------------------------
 */
public class Step17_CallableVsRunnable {

    public static void main(String[] args) throws Exception {

        ExecutorService executor =
                Executors.newSingleThreadExecutor();

        // 🔹 Runnable (no result)
        executor.execute(new RunnableTask());

        // 🔹 Callable (with result)
        //Future is used to handel the result of Callable
        Future<Integer> future =
                executor.submit(new CallableTask());

        // 🔹 Result from Callable
        System.out.println(
                "Callable result = " + future.get()
        );

        executor.shutdown();
    }
}
