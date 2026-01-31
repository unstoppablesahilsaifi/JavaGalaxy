package MultiThreadingMastery;

class Shared {
    synchronized void doWork() throws InterruptedException {
        System.out.println("Worker: kaam start");
        wait(); // 👈 yahin ruk jaayega
        System.out.println("Worker: kaam resume");
    }
    synchronized void finishWork() {
        System.out.println("Notifier: kaam complete");
        notify(); // 👈 waiting thread ko utha do
    }
}
class WorkerThreadForMethods extends Thread {
    Shared shared;
    WorkerThreadForMethods(Shared shared) {
        this.shared = shared;
    }
    public void run() {
        try {
            shared.doWork();
        } catch (Exception e) {}
    }
}
class NotifierThread extends Thread {
    Shared shared;
    NotifierThread(Shared shared) {
        this.shared = shared;
    }
    public void run() {
        try {
            Thread.sleep(2000); // thoda delay
            shared.finishWork();
        } catch (Exception e) {}
    }
}

public class Step11_WaitNotifySimpleDemo {
    public static void main(String[] args) {
        Shared shared = new Shared();
        WorkerThreadForMethods w = new WorkerThreadForMethods(shared);
        NotifierThread n = new NotifierThread(shared);
        w.start();
        n.start();
    }
}

