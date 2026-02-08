package MultiThreadingMastery;
//Locks (ReentrantLock) -> (synchronized ka PRO version)
//Lock gives explicit control over synchronization with more flexibility than synchronized.

//❌ synchronized ki limitations (WHY LOCKS?)
//           Problem	          synchronized

//           Timeout	            ❌
//           Try without blocking	❌
//           Manual unlock	        ❌
//           Fairness control    	❌
//
//👉 Industry ne bola: hume control chahiye
//👉 Java ne diya: Lock API

// Remember: ⚠️ finally me unlock = mandatory
//  Nahi to 💣 deadlock


class SimpleLock {
    private boolean isLocked = false;

    public synchronized void lock() {
        while (isLocked) {
            try {
                wait();   // thread yahin fas jayega
            } catch (Exception e) {
            }
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}

class Test {
    SimpleLock lock = new SimpleLock();

    void outer() {
        lock.lock();
        System.out.println("Outer method acquired lock");

        inner();   // SAME thread dobara lock maang raha hai

        lock.unlock();
    }

    void inner() {
        lock.lock();   // ❌ yahin self deadlock
        System.out.println("Inner method acquired lock");
        lock.unlock();
    }
}
// ---------- THREAD CLASS ----------
class LockThread extends Thread {

    private Test test;

    LockThread(Test test) {
        this.test = test;
    }

    @Override
    public void run() {
        test.outer();
    }
}

// ---------- MAIN CLASS ----------
public class Step20_Part1_SelfDeadLock_NON_REENTRANTLOCK {

    public static void main(String[] args) {

        Test t = new Test();

        LockThread th = new LockThread(t);
        th.start();
    }
}

/*

# 🧠 PEHLE YAAD RAKHO

Sirf **1 thread** create ho rahi hai:

```java
WorkerThread th = new WorkerThread(t);
th.start();
```

Main thread bas start karta hai aur side ho jaata hai.

---

# ▶️ STEP 1 — Program Start

JVM pehle:

```java
main()
```

execute karegi.

---

# ▶️ STEP 2 — Object Creation

```java
Test t = new Test();
```

Memory me:

```
t
 └── lock -> SimpleLock object
         └── isLocked = false
```

---

# ▶️ STEP 3 — Thread Object

```java
WorkerThread th = new WorkerThread(t);
```

Memory:

```
th
 └── reference to t
```

---

# ▶️ STEP 4 — th.start()

```java
th.start();
```

JVM bolta hai:

👉 New thread banao
👉 Uska `run()` method call karo

---

# ▶️ STEP 5 — Worker Thread RUN

Inside `run()`:

```java
test.outer();
```

---

# ▶️ STEP 6 — outer() start

```java
lock.lock();
```

SimpleLock.lock():

```java
while(isLocked)  // false
isLocked = true;
```

State:

```
isLocked = true
```

Thread got lock ✅

---

# ▶️ STEP 7 — Print

```java
System.out.println("Outer method acquired lock");
```

Console:

```
Outer method acquired lock
```

---

# ▶️ STEP 8 — inner() call

```java
inner();
```

Same worker thread enters inner().

---

# ▶️ STEP 9 — inner() tries lock

```java
lock.lock();
```

Now inside SimpleLock.lock():

```
while(isLocked)  // true
```

Thread enters:
```java
wait();
```
Thread goes to WAITING state.

---

# ❌ AB SABSE IMPORTANT
Worker thread WAITING me hai.
Par unlock ka code yahan hai:
```java
lock.unlock();   // outer() ke end me
```
Outer() tab tak end nahi hoga jab tak inner() finish na ho.
Par inner() tab finish hoga jab lock mile.
Par lock tab milega jab unlock ho.
🔥 **Circular trap**


# 💀 FINAL RESULT

✔ Sirf ek line print hui:

Outer method acquired lock
✔ Program hang
✔ No crash
✔ No second print

Yehi SELF DEADLOCK.

# 🧠 ONE-LINE SUMMARY
Same thread ne lock liya
Same thread ne dobara lock maanga
Non-reentrant lock ne mana kar diya
Thread khud ke liye wait karne laga
= SELF DEADLOCK

*/