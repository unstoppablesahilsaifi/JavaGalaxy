package MultiThreadingMastery;
/**
 * =========================================================
 * Topic: Why Multithreading Exists?
 * =========================================================
 * Multithreading isliye exist karti hai
 * kyunki SINGLE THREAD real world me FAIL ho jaati hai
 * ---------------------------------------------------------
 *  PROBLEM #1: BLOCKING (SABSE BADI DIKKAT)
 * ---------------------------------------------------------
 * Single thread case:
 *
 * downloadFile();   // 10 seconds lag gaye
 * playMusic();     // tab tak wait karega
 *
 * Jab tak download khatam nahi hota:
 * Music start nahi hota
 * ---------------------------------------------------------
 * Thread 1 -> downloadFile()
 * Thread 2 -> playMusic()
 *
 *  Dono kaam PARALLEL chalenge
 *  Ek kaam dusre ko block nahi karega
 * ---------------------------------------------------------
 *  PROBLEM #: CPU WASTE
 * ---------------------------------------------------------
 * Single thread:
 * - CPU idle rehta hai
 * - Multi-core CPU ka full use nahi hota
 *
 * Multithreading:
 * - Multiple threads
 * - Multiple cores ka use
 * - Performance boost
 * ---------------------------------------------------------
 * SUMMARY (EXAM / INTERVIEW READY)
 * ---------------------------------------------------------
 * Multithreading is used to:
 *
 * 1️⃣ Avoid blocking
 * 2️⃣ Improve performance
 * 3️⃣ Improve responsiveness
 * 4️⃣ Better CPU utilization
 *
 * ---------------------------------------------------------
 *  INTERVIEW PERFECT ANSWER
 * ---------------------------------------------------------
 * "Multithreading allows concurrent execution of tasks
 * to improve performance, responsiveness,
 * and efficient CPU utilization."
 *
 * =========================================================
 */

public class Step3_WhyMultithreadingExists {

    public static void main(String[] args) {

        // Abhi tak humne koi extra thread create nahi ki
        // Ye program sirf example ke liye hai (concept based)

        System.out.println("Single thread real world me fail hoti hai");
        System.out.println("Isi liye multithreading exist karti hai");
    }
}
