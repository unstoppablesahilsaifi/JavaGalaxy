package MultiThreadingMastery;

//Jab multiple threads ek hi shared data ko same time pe modify karte hain aur result unpredictable ho jaata hai
/**
 * Shared data
 */
//Counter bahar kyu banaya? Shared data ko alag class me rakhna best practice hai. Agar count har thread ke andar hota:
// Har thread ka apna alag counter hota
//Shared hi nahi hota
class Counter {
    int count = 0;
    void increment(){
        count++;
    }
}

/**
 * Thread class (bahar likhi hui)
 */
class MyThread extends Thread {
//Bhai, ye raha same counter, isi ko use karna”
//Agar ye nahi karte:
// Har thread apna naya Counter bana leta
    Counter counter;

    MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        // 👇 loop add kiya
        for (int i = 1; i <= 500; i++) {
            counter.increment();   // 👈 race condition yahin hai
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

