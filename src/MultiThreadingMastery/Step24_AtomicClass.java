package MultiThreadingMastery;
/*

//(Lock-Free Programming 🔥)
//Synchronization & Locks ke bina bhi thread-safe operations possible hain
//Ye magic karti hain 👉 Atomic Classes

//Atomic classes perform thread-safe operations using low-level CPU instructions without locks.

/*🧠 PROBLEM – count++ kyun dangerous hai?
count++;
Ye ek single instruction nahi hai ❌
Actually CPU karta hai:
1️⃣ Read value
2️⃣ Increment
3️⃣ Write back
Agar beech me dusri thread aa gayi → value lost 💣
Isko bolte hain → Race Condition

❌ synchronized solution
synchronized void increment() {
    count++;
}

Safe hai ✅
But:
Lock lagta hai
Threads block hoti hain
Context switching hota hai
Performance drop hoti hai
Production high-throughput system me heavy padta hai.
*/


/*
 “Jab synchronized hai to Atomic kyun?” 😏

# 🔴 Haan, synchronized se bhi problem solve ho jaati hai

Example:

static int counter = 0;
static synchronized void increment() {
    counter++;
}

Ya:

synchronized(this) {
   counter++;
}

✔ Correct result milega
✔ Race condition khatam

To fir Atomic kyu bana?

---

# ⚔️ Difference Samjho – Lock vs Lock-Free

## 🧱 synchronized kya karta hai?

* Lock lagata hai
* Dusre threads ko wait karwata hai
* Context switching hoti hai
* Performance hit hota hai

Matlab:

Thread A → andar
Thread B → bahar wait
Thread C → bahar wait

Blocking ho gaya.

---

## ⚛️ Atomic kya karta hai?

* Lock nahi lagata
* CAS (Compare And Swap) use karta hai
* CPU level instruction
* Non-blocking

Matlab:

Thread A → try update
Thread B → try update
Agar fail → retry

Wait nahi — retry 🔥

---

# 🧠 Visual Comparison

## 🧱 synchronized (Blocking)

🔒 LOCK
Thread A inside
Thread B waiting...
Thread C waiting...

## ⚛️ Atomic (Non-Blocking)

Thread A try
Thread B try
Thread C try

Agar fail → retry

---

# 🏎 Performance Angle

High concurrency me:

| Scenario     | synchronized | Atomic      |
| ------------ | ------------ | ----------- |
| 5 threads    | OK           | Fast        |
| 100 threads  | Slower       | Faster      |
| 1000 threads | Bottleneck   | Much better |

Atomic me context switch kam hota hai.

---

# 🎯 To fir kab kya use karein?

## 🟢 Atomic use karo jab:

* Simple counter ho
* Flag ho (true/false)
* Single variable update ho
* High concurrency ho

## 🔴 synchronized use karo jab:

* Multiple variables update karne ho
* Complex logic ho
* Compound operation ho
* Critical section bada ho

---

# 💣 Important Line (Interview me bol dena)

Atomic classes are non-blocking and use CAS internally, while synchronized uses locking mechanism which may cause thread blocking and context switching overhead.

Interviewer khush 😎

---

# 🧨 Real Example

Agar bank transfer hai:

balanceA--
balanceB++

Ye dono ek saath hona chahiye.

Atomic se nahi kar sakte easily.

Yaha synchronized better hai.


# ⚡ Ek line me samjho
synchronized = “Ek hi banda andar aayega”
Atomic = “Sab try karo, jo jeete wo update kare”

*/






// Now question is -- baaki thread wait hi krti and lock bhi nhi lgta to race condition aani chahiye na

/*

“Agar lock nahi lagta aur threads wait bhi nahi karte,
to race condition kaise nahi aati Atomic me?”

Ab dhyaan se… yahi Atomic ka asli magic hai 👇

---

# 🧠 Pehle Race Condition kya hoti hai?

Normal counter++ actually 3 steps hai:

1. Read value
2. Increment
3. Write back

Agar do threads same time pe read karein → data lost 💀

Example:

Counter = 5

Thread A read 5
Thread B read 5

Thread A write 6
Thread B write 6   ❌ 7 hona chahiye tha

Ye hoti hai race condition.

---

# ⚛️ Atomic me kya alag hota hai?

Atomic ka increment aise nahi hota.

Ye internally use karta hai:

# 🔥 CAS – Compare And Swap

Concept:

Agar current value wahi hai jo maine last dekhi thi
    to update kar do
warna
    retry karo

---

# 🎯 Step-by-Step Atomic Example

Counter = 5

## Thread A:

read 5
try CAS(5 → 6)
SUCCESS ✅
counter = 6

## Thread B:

read 5
try CAS(5 → 6)
FAIL ❌ (kyunki ab value 6 ho chuki hai)
retry
read 6
try CAS(6 → 7)
SUCCESS ✅

Final value = 7 ✔

---

# 🚀 Important Point

Atomic me:

❌ Lock nahi lagta
❌ Thread wait nahi karti
❌ Blocking nahi hota

BUT…

✅ Agar update fail ho jaye to retry hota hai
✅ Jab tak successful na ho tab tak try karta rehta hai

Isko bolte hain:

# 🔥 Non-Blocking Retry Mechanism

---

# 🧠 Difference Samjho

| Normal                  | Atomic                    |
| ----------------------- | ------------------------- |
| Read-Modify-Write       | Compare-And-Swap          |
| Data overwrite possible | Overwrite allowed hi nahi |
| Race condition          | Retry logic               |

---

# 🏎 Real Life Analogy

Imagine ek whiteboard hai.

Normal method:

Dono aadmi ek hi number dekhte hain
Dono apna number likh dete hain
Last wala jeet gaya

Atomic method:

Tum number likhne jaoge
System check karega:

"Kya board pe wahi number hai jo tumne dekha tha?"
Agar nahi → tumhe phir se dekh ke likhna padega

---

# 💣 Isliye race condition nahi aati

Race condition tab aati hai jab:

✔ Multiple threads same data overwrite kar sake

Atomic me:

❌ Overwrite allowed hi nahi
✔ Agar mismatch → retry

---

# 🔬 Advanced Insight (Interview Gold Line)

Atomic operations are atomic at hardware level using CPU instructions like CMPXCHG, ensuring that compare-and-update happens in a single uninterruptible step.

Ye line bol di na…

Interviewer bolega:
“Okay, this guy understands internals.”

---

# 🧨 Final Summary

Thread wait nahi karti
Lock nahi lagta
Phir bhi race condition nahi aati

Kyun?

Because:

Atomic guarantees atomicity using CAS and retry logic instead of locking.

*/
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


class CounterAtomic {

    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
class CounterTask implements Runnable {

    private CounterAtomic counter;

    public CounterTask(CounterAtomic counter) {
        this.counter = counter;
    }

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class Step24_AtomicClass {
    public static void main(String[] args) throws InterruptedException {

        CounterAtomic sharedCounter = new CounterAtomic();

        // Fixed Thread Pool of 10 threads
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // Submit 10 tasks
        for (int i = 0; i < 10; i++) {
            executor.submit(new CounterTask(sharedCounter));
        }

        executor.shutdown();  // Stop accepting new tasks
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Final Counter Value: " + sharedCounter.getCount());
    }
}
