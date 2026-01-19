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





/*Pehle ek real-life example (CODE KO BHOOLO ABHI)

Soch 👇

🔐 Situation:

2 chabiyaan (locks) hain

🔑 Lock-1

🔑 Lock-2

2 aadmi (threads) hain

👨 Thread-1

👨 Thread-2

👨 Thread-1 bolta hai:

“Mujhe pehle Lock-1, phir Lock-2 chahiye”

👨 Thread-2 bolta hai:

“Mujhe pehle Lock-2, phir Lock-1 chahiye”

🚨 Problem kya hui?

Thread-1 ne 🔑 Lock-1 pakad li

Thread-2 ne 🔑 Lock-2 pakad li

Ab:

Thread-1 bolta hai → “Lock-2 do”

Thread-2 bolta hai → “Lock-1 do”

❌ Dono ek-dusre ka wait kar rahe
❌ Koi bhi aage nahi badh pa raha

🔥 ISI KO KEHTE HAIN → DEADLOCK

Ab CODE ko tod ke samajhte hain (ek ek line)
1️⃣ LockResource class – ye kya hai?
class LockResource{
    static final Object lock1 = new Object();
    static final Object lock2 = new Object();
}

Simple language:

lock1 = 🔑 chabi 1

lock2 = 🔑 chabi 2

❓ static kyu?

Taaki sab threads same lock use karein

❓ Object kyu?

Java me kisi bhi object pe lock lag sakta hai

📌 Yaha lock ka koi kaam nahi,
sirf taala (mutex) hai.

2️⃣ synchronized(lock) ka matlab (SABSE IMPORTANT)
synchronized (LockResource.lock1) {
    // code
}


Iska matlab:

🔒 Jab tak ye block chalega
koi aur thread is lock ko use nahi kar sakta

3️⃣ ThreadOne – pehle kaunsa lock?
synchronized (LockResource.lock1) {
    System.out.println("Thread-1 acquired lock1");

    Thread.sleep(100);

    synchronized (LockResource.lock2) {
        System.out.println("Thread-1 acquired lock2");
    }
}

Step-by-step:

Thread-1 🔑 lock1 le leta hai

100 ms rukta hai (jaan-bujh ke delay)

Fir bolta hai:

“Ab mujhe lock2 bhi chahiye”

4️⃣ ThreadTwo – ulta kaam
synchronized (LockResource.lock2) {
    System.out.println("Thread-2 acquired lock2");

    Thread.sleep(100);

    synchronized (LockResource.lock1) {
        System.out.println("Thread-2 acquired lock1");
    }
}

Step-by-step:

Thread-2 🔑 lock2 le leta hai

100 ms rukta hai

Fir bolta hai:

“Ab mujhe lock1 bhi chahiye”

5️⃣ Ab DEADLOCK ka exact flow (YE YAAD RAKH)
Time line 👇
Time	Thread-1	Thread-2
T1	lock1 le liya
T2		lock2 le liya
T3	lock2 ka wait
T4		lock1 ka wait

❌ Thread-1 → “lock2 do”
❌ Thread-2 → “lock1 do”

🔁 Infinite wait = DEADLOCK

6️⃣ Main method
t1.start();
t2.start();


Dono saath start hue
Isliye ye problem pakki hoti hai

System.out.println("Main thread end");


Ye line print ho jaayegi
❌ par program khatam nahi hoga

kyunki:

Threads abhi zinda hain, par kaam nahi kar pa rahe

⚡ ONE LINE ME DEADLOCK

Jab do threads alag-alag order me locks lete hain
aur ek-dusre ka wait karte reh jaate hain
use DEADLOCK kehte hain

❗ Interview me agar bole:

Deadlock kya hota hai?

👉 Bolna:

Deadlock tab hota hai jab multiple threads
circular dependency me locks hold kar lete hain
aur koi bhi release nahi kar pata.
*/