package MultiThreadingMastery;
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
Production high-throughput system me heavy padta hai.*/




public class Step24_AtomicClass {
}
