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

/*
Why not sleep- coz sleep thread ko block krta h , time reliable nhi h, agar 3 second sleep kiya to ho skta h 3.1 second wait krle
scheduled m time accurate hota h

* */