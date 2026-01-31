package MultiThreadingMastery;
//Executor Framework manages thread creation and reuse, allowing developers to focus only on tasks.
/*Har baar naya thread
Thread banana mehnga hota hai
1000 request = 1000 threads 💣
CPU + Memory overload
👉 Yahin pe server girta hai*/


// Limited threads bana lo, unhi ko reuse karo
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyTask implements Runnable{
    private final String taskName;
    MyTask(String taskName){
        this.taskName=taskName;
    }

    @Override
    public void run() {
        System.out.println(taskName + " executed by "+ Thread.currentThread().getName());
    }
}
public class Step12_ExecutorFramework {
    public static void main(String[] args) {
        Executor executor= Executors.newFixedThreadPool(2);
        executor.execute(new MyTask("Task-1"));
        executor.execute(new MyTask("Task-2"));
        executor.execute(new MyTask("Task-3"));
        executor.execute(new MyTask("Task-3"));

        ((ExecutorService) executor).shutdown();
    }
}
//Thread pool limits the number of threads and reuses them to execute multiple tasks efficiently.