package MultiThreadingMastery;
/*
volatile guarantees VISIBILITY, not ATOMICITY.
________________________________________
❓ Problem samajh (WHY volatile?)
CPU + Threads ka sach
•	Har thread ke paas local cache hota hai
•	Thread memory se nahi, cache se read karta hai
•	Ek thread change kare → dusri thread ko dikhe hi nahi ❌
👉 Result: stale data bug 💣

 */

class SharedCounterForVolatile{
    private volatile int counter=0;
    public void increment(){
        counter++;
    }
    public int getCounter() {
        return counter;
    }
}
class CounterWorkerForVolatile extends Thread{
    SharedCounterForVolatile sharedCounterForVolatile;
    CounterWorkerForVolatile(SharedCounterForVolatile sharedCounterForVolatile){
        this.sharedCounterForVolatile=sharedCounterForVolatile;
    }

    @Override
    public void run() {
        while (sharedCounterForVolatile.getCounter() < 10000000) {
            sharedCounterForVolatile.increment();
        }

        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
public class Step25_VolatileDemo {
    public static void main(String[] args) throws Exception {

        SharedCounterForVolatile counter = new SharedCounterForVolatile();

        CounterWorkerForVolatile t1 = new CounterWorkerForVolatile(counter);
        CounterWorkerForVolatile t2 = new CounterWorkerForVolatile(counter);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Counter Value: " + counter.getCounter());
    }
}
