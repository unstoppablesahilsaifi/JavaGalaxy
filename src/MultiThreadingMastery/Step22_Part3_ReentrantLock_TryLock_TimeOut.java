package MultiThreadingMastery;
import java.util.concurrent.locks.ReentrantLock;

// -------------------- SERVICE CLASS --------------------
class TryLockService {

    private ReentrantLock lock = new ReentrantLock();

    // Thread-1 yeh method run karega
    void holdLock() {
        lock.lock();
        try {
            System.out.println("Thread-1 acquired lock");
            Thread.sleep(3000);   // lock 3 sec hold
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

    // Thread-2 yeh method run karega
    void tryGetLock() {

        if (lock.tryLock()) {   // 👈 MAIN POINT
            try {
                System.out.println("Thread-2 acquired lock");
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Thread-2 could NOT get lock");
        }
    }
}

// -------------------- THREAD-1 --------------------
class LockHolderThread extends Thread {

    private TryLockService service;

    LockHolderThread(TryLockService service) {
        this.service = service;
    }

    public void run() {
        service.holdLock();
    }
}

// -------------------- THREAD-2 --------------------
class TryLockThread extends Thread {

    private TryLockService service;

    TryLockThread(TryLockService service) {
        this.service = service;
    }

    public void run() {
        service.tryGetLock();
    }
}

public class Step22_Part3_ReentrantLock_TryLock_TimeOut {
    public static void main(String[] args) {
        TryLockService service = new TryLockService();

        LockHolderThread t1 = new LockHolderThread(service);
        TryLockThread t2 = new TryLockThread(service);

        t1.start();
        t2.start();

    }
}
