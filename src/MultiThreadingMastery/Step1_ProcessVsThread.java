package MultiThreadingMastery;

/**
 * =========================================================
 * STEP 1 : Process vs Thread
 * =========================================================
 * Process = Running Program
 * Thread  = Us program ke andar chal raha kaam
 * ---------------------------------------------------------
 * PROCESS KYA HOTA HAI?
 * ---------------------------------------------------------
 *  Process ek running program hota hai jiske paas:
 * 1️⃣ Apni memory hoti hai
 * 2️⃣ Apna address space hota hai
 *
 *  Real Life Example:
 * - Chrome open → ek process
 * - VS Code open → alag process
 * - Spotify open → alag process
 *
 *  Har process independent hota hai
 *
 * ---------------------------------------------------------
 *  PROCESS KI PROPERTIES
 * ---------------------------------------------------------
 * Memory        → Alag hoti hai
 * Crash         → Ek process crash ho jaaye to dusra safe
 * ---------------------------------------------------------
 *  THREAD KYA HOTA HAI?
 * ---------------------------------------------------------
 *  Thread ek lightweight execution unit hota hai
 *  Thread same process ki memory SHARE karta hai
 *
 * Real Life Example (Chrome ke andar):
 * - Ek thread webpage load karta hai
 * - Ek thread video play karta hai
 * - Ek thread download handle karta hai
 * - Ek thread UI responsive rakhta hai
 *
 * ---------------------------------------------------------
 *  THREAD KI PROPERTIES
 * ---------------------------------------------------------
 * Memory        → Shared hoti hai
 * Crash         → Ek thread crash → poora process crash
 *
 * ---------------------------------------------------------
 * PROCESS vs THREAD (SIDE BY SIDE)
 * ---------------------------------------------------------
 * Process:
 * - Running program
 * - Heavyweight
 * - Separate memory
 *
 * Thread:
 * - Lightweight
 * - Shared memory

 *
 * ---------------------------------------------------------
 *  IMPORTANT CONFUSION KILLER
 * ---------------------------------------------------------
 *  Java process create nahi karti
 * Java threads create karti hai
 *
 * ---------------------------------------------------------
 *  JAVA KA REAL SCENARIO
 * ---------------------------------------------------------
 * Jab hum Java program run karte hain:
 * 1️⃣ JVM start hoti hai → ek PROCESS create hota hai
 * 2️⃣ JVM automatically ek THREAD banati hai → main thread
 *
 * ---------------------------------------------------------
 *  YAAD RAKHNE KA TRICK (BEST)
 * ---------------------------------------------------------
 * Process = Ghar
 * Thread  = Ghar ke andar kaam karne wale log
 *
 * - Ghar alag → memory alag
 * - Log same ghar me → memory shared
 *
 * ---------------------------------------------------------
 *  INTERVIEW
 * ---------------------------------------------------------
 * "Process is a heavyweight execution unit with its own memory,
 * whereas thread is a lightweight execution unit that shares
 * memory within the same process."
 *
 * =========================================================
 */

public class Step1_ProcessVsThread {

    public static void main(String[] args) {

        // Jab ye program run hota hai:
        // JVM start hoti hai -> ek process banta hai
        // JVM ek main thread banati hai

        System.out.println("Main thread chal raha hai");

    }
}
