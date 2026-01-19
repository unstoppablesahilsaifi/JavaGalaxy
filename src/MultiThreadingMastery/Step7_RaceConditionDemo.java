package MultiThreadingMastery;

//Jab multiple threads ek hi shared data ko same time pe modify karte hain aur result unpredictable ho jaata hai
/**
 * Shared data
 */
class Counter {
    int count = 0;
}

/**
 * Thread class (bahar likhi hui)
 */
class MyThread extends Thread {

    Counter counter;

    MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        // 👇 loop add kiya
        for (int i = 1; i <= 500; i++) {
            counter.count++;   // 👈 race condition yahin hai
        }
    }
}

/**
 * Main class
 */
public class Step7_RaceConditionDemo {

    public static void main(String[] args) throws Exception {

       Counter counter = new Counter(); // 👈 ek hi shared object

        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count = " + counter.count);
    }
}

