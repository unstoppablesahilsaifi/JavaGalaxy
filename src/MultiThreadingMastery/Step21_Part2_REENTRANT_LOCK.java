package MultiThreadingMastery;
import java.util.concurrent.locks.ReentrantLock;
/*🔥 ReentrantLock ki class tumhe banani hi nahi hoti
Ye Java ki built-in class hai.
import java.util.concurrent.locks.ReentrantLock;*/
// ---------- BUSINESS LOGIC ----------
class TestReentrant {

    ReentrantLock lock = new ReentrantLock();

    void outer() {
        lock.lock();
        try {
            System.out.println("Outer method acquired lock");
            inner();
        } finally {
            lock.unlock();
        }
    }

    void inner() {
        lock.lock();   // SAME thread dobara lock lega (allowed)
        try {
            System.out.println("Inner method acquired lock");
        } finally {
            lock.unlock();
        }
    }
}

// ---------- THREAD CLASS ----------
class WorkerThreadReentrant extends Thread {

    private TestReentrant test;

    WorkerThreadReentrant(TestReentrant test) {
        this.test = test;
    }

    @Override
    public void run() {
        test.outer();
    }
}
public class Step21_Part2_REENTRANT_LOCK {
    public static void main(String[] args) {

        TestReentrant t = new TestReentrant();

        WorkerThreadReentrant th = new WorkerThreadReentrant(t);
        th.start();

    }
}

/*🧠 AB FLOW SLOW MOTION ME
▶️ 1. main()
WorkerThreadReentrant th = new WorkerThreadReentrant(t);
th.start();


New thread start.

▶️ 2. run()
test.outer();

▶️ 3. outer()
lock.lock();   // count = 1


Lock mil gaya.

Print:

Outer method acquired lock

▶️ 4. inner()
lock.lock();   // SAME THREAD → count = 2


ReentrantLock bolta:

👉 Same owner hai → allow.

Print:

Inner method acquired lock

▶️ 5. inner() finally
lock.unlock();   // count = 1

▶️ 6. outer() finally
lock.unlock();   // count = 0 (lock free)


Thread finish ✅*/