package MultiThreading;

public class MT_6_ThreadCreation extends Thread{
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " is running: " + i);
            try {
                Thread.sleep(500);  // Pause 0.5 seconds
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }

    public static void main(String[] args) {
        MT_6_ThreadCreation t1 = new MT_6_ThreadCreation();
        MT_6_ThreadCreation t2 = new MT_6_ThreadCreation();
        t1.start();
        t2.start();

        try {
            t1.join();  // Wait for t1 to finish
            t2.join();  // Wait for t2 to finish
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Main thread ends.");

    }
}

/*// File: ThreadCreationByRunnable.java

class MyRunnableTask implements Runnable {
    private String taskName;

    MyRunnableTask(String name) {
        this.taskName = name;
    }

    @Override
    public void run() {
        // Thread.currentThread() current thread ka reference deta hai
        String threadName = Thread.currentThread().getName();
        for (int i = 1; i <= 3; i++) {
            System.out.println(threadName + " executing " + taskName + " step " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted");
            }
        }
    }
}

public class ThreadCreationByRunnable {
    public static void main(String[] args) {
        // task bana diya
        Runnable task = new MyRunnableTask("DatabaseSync");

        // thread ke andar runnable pass kiya
        Thread t1 = new Thread(task, "Worker-A");
        Thread t2 = new Thread(task, "Worker-B");

        t1.start();
        t2.start();

        System.out.println("Main thread done: " + Thread.currentThread().getName());
    }
}
*/