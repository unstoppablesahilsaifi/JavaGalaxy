package MultiThreadingMastery;
class CounterForSync{
    int count=0;
   synchronized   void increment(){
        count++;
    }
}
class MyThreadForSync extends Thread{
    CounterForSync counter;
    MyThreadForSync(CounterForSync counter){
        this.counter=counter;
    }

    @Override
    public void run() {
        for(int i=0;i<500;i++){
            counter.increment();
        }
    }
}
public class Step8_Synchronization_FixedRaceCondition {
    public static void main(String[] args) throws InterruptedException {
        CounterForSync counter=new CounterForSync();
        MyThreadForSync th1=new MyThreadForSync(counter);
        MyThreadForSync th2=new MyThreadForSync(counter);
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        System.out.println("Final Counter :   "+ counter.count);
    }
}
