package MultiThreadingMastery;
//Deadlock occurs when two or more threads wait forever for each other’s locks.

/**
 * =========================================================
 * LEVEL 3 – STEP 10
 * Topic: DEADLOCK (MOST DANGEROUS BUG)
 * =========================================================
 *
 *  ONE LINE ME DEADLOCK:
 * Jab do ya zyada threads ek dusre ke lock ka
 * intezaar karti rehti hain
 * aur program hamesha ke liye atak jaata hai
 *
 * Threads zinda rehti hain
 * Par kaam koi nahi hota
 *
 * =========================================================
 */
class LockResource{
    static final Object lock1 = new Object();
    static final Object lock2 = new Object();
}
/**
 * Thread-1
 * Pehle lock1 lega, fir lock2
 */
class ThreadOne extends Thread {

    @Override
    public void run() {

        synchronized (LockResource.lock1) {
            System.out.println("Thread-1 acquired lock1");

            try { Thread.sleep(100); } catch (Exception e) {}

            synchronized (LockResource.lock2) {
                System.out.println("Thread-1 acquired lock2");
            }
        }
    }
}

/**
 * Thread-2
 * Pehle lock2 lega, fir lock1
 */
class ThreadTwo extends Thread {

    @Override
    public void run() {

        synchronized (LockResource.lock2) {
            System.out.println("Thread-2 acquired lock2");

            try { Thread.sleep(100); } catch (Exception e) {}

            synchronized (LockResource.lock1) {
                System.out.println("Thread-2 acquired lock1");
            }
        }
    }
}

/**
 * Main Class
 */
public class Step9_Deadlock_Demo {

    public static void main(String[] args) {

        ThreadOne t1 = new ThreadOne();
        ThreadTwo t2 = new ThreadTwo();

        t1.start();
        t2.start();

        System.out.println("Main thread end (but program will hang)");
    }
}

/*AB IS CODE KO HUMAN LANGUAGE ME SAMJH
Step 1️⃣

Thread-1 ne lock1 le liya

Thread-2 ne lock2 le liya

Output:

Thread-1 acquired lock1
Thread-2 acquired lock2

Step 2️⃣

Thread-1 bolta: “ab lock2 chahiye”

Thread-2 bolta: “ab lock1 chahiye”

👉 Par:

lock2 → Thread-2 ke paas

lock1 → Thread-1 ke paas

💣 RESULT = DEADLOCK

Dono threads WAITING

Koi lock release nahi karega

Program hang

CPU chal raha, output nahi

 DEADLOCK KYUN HUA? (INTERVIEW GOLD)

Deadlock tab hota hai jab 4 conditions saath aati hain 👇

1️⃣ Mutual Exclusion
Lock ek time pe ek hi thread ko

2️⃣ Hold and Wait
Ek lock pakad ke dusre ka wait

3️⃣ No Preemption
Lock zabardasti chheena nahi ja sakta

4️⃣ Circular Wait
Thread-1 → Thread-2 → Thread-1 🔁

👉 4 me se ek tod do = deadlock khatam*/