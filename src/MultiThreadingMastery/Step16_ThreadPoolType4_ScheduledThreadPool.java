package MultiThreadingMastery;
/*Real Use Case
Cron jobs
Health checks
Retry mechanism
Token cleanup*/

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class ScheduledTask implements Runnable {
    public void run() {
        System.out.println(
                "Task executed by " +
                        Thread.currentThread().getName()
        );
    }
}
public class Step16_ThreadPoolType4_ScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(1);

        scheduler.schedule(
                new ScheduledTask(),
                3,
                TimeUnit.SECONDS
        );
    }
}
//ScheduledThreadPool is used for delayed and periodic tasks.