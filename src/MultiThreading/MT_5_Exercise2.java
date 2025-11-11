package MultiThreading;

public class MT_5_Exercise2 implements Runnable {
    static  int counter=0;
    public void run(){
        for(int i=1;i<=1000;i++){
            counter++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MT_5_Exercise2 obj=new MT_5_Exercise2();
        Thread th1=new Thread(obj);
        Thread th2=new Thread(obj);
        // Start both threads
        th1.start();
        th2.start();

        // Wait until both finish
        th1.join();
        th2.join();

        System.out.println("Final Counter Value: " + counter);


    }

}
//Run multiple times, you’ll see variations:

/*package MultiThreading;

public class MT_5_Exercise2 implements Runnable {
    static int counter = 0;

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            increment();
        }
    }

    // synchronized method → lock on class (since static)
    static synchronized void increment() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        MT_5_Exercise2 obj = new MT_5_Exercise2();

        Thread th1 = new Thread(obj);
        Thread th2 = new Thread(obj);

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println("Final Counter Value: " + counter);
    }
}
*/