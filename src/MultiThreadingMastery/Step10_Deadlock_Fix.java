package MultiThreadingMastery;
// Sleep does not release the lock
class Lock{
    static final Object lock1=new Object();
    static final Object lock2=new Object();
}
class Thread1 extends Thread{
    @Override
    public void run() {
        synchronized (Lock.lock1){
            System.out.println("Thread 1 acquiring lock 1 ");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (Lock.lock2){
                System.out.println("Thread 1 acquiring lock 2");
            }

        }
    }
}
class Thread2 extends Thread{
    @Override
    public void run() {
        synchronized (Lock.lock1){
            System.out.println("Thread 2 acquiring lock 1");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (Lock.lock2){
                System.out.println("Thread 2 acquiring lock 2");
            }
        }
    }
}
public class Step10_Deadlock_Fix {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2=new Thread2();
        thread1.start();
        thread2.start();
        System.out.println("Main Thread End");

    }
}
