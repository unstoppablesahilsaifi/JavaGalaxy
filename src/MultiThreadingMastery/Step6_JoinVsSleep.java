package MultiThreadingMastery;

class WorkerThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Worker START | " + Thread.currentThread().getName());
            Thread.sleep(2000);   // 2 sec ka kaam
            System.out.println("Worker END   | " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println("Worker INTERRUPTED | " + Thread.currentThread().getName());
        }
    }
}
/**
 * Is file ka goal:
 * - bina join ke main wait nahi karti
 * - join ke saath main wait karti hai
 */
public class Step6_JoinVsSleep {

    public static void main(String[] args) throws Exception {
        System.out.println("Main Thread Start");
        WorkerThread thread1=new WorkerThread();
        thread1.start();
        thread1.join();

        System.out.println("Main Thread End");
    }
}
