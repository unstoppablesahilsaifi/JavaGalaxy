package MultiThreadingMastery;
/**
 * =========================================================
 * Topic: Single Threaded Program & main() Thread
 * =========================================================
 *
 *  CONFUSION KILLER TOPIC
 *
 * ---------------------------------------------------------
 *  ONE LINE TRUTH
 * ---------------------------------------------------------
 * Java ka har program by default SINGLE THREADED hota hai
 * aur wo thread hota hai -> main thread
 *
 * ---------------------------------------------------------
 *  main() THREAD KYA HOTA HAI?
 * ---------------------------------------------------------
 * Jab tu Java program run karta hai:
 *
 * OS JVM ko start karta hai
 * JVM ek PROCESS create karti hai
 * JVM automatically ek THREAD banati hai
 *
 *  Is thread ka naam hota hai: "main"
 *
 * Ye thread hum khud create nahi karte
 * JVM automatically create karti hai
 *
 * ---------------------------------------------------------
 *  SIMPLE SINGLE THREADED JAVA PROGRAM
 * ---------------------------------------------------------
 * Example:
 *
 * System.out.println("Line 1");
 * System.out.println("Line 2");
 * System.out.println("Line 3");
 *
 * Output hamesha same order me aayega:
 * Line 1
 * Line 2
 * Line 3
 *
 * 💡 Kyun?
 * 👉 Kyunki sirf EK thread hai
 * 👉 Execution SEQUENTIAL hota hai
 *
 * ---------------------------------------------------------
 *  SINGLE THREADED PROGRAM KA MATLAB
 * ---------------------------------------------------------
 *  Ek time pe sirf ek kaam hota hai
 *  Jab tak current kaam finish nahi hota next kaam start nahi hota
 *  Agar ek kaam slow ho gaya to poora program slow ho jaata hai
 *
 * ---------------------------------------------------------
 * REAL LIFE PROBLEM
 * ---------------------------------------------------------
 * Soch:
 * - App data load kar rahi hai (slow operation)
 * - UI bhi same thread pe chal rahi hai
 *
 * Result:
 *  UI freeze
 *  App hang
 *
 *  Isi problem ko solve karne ke liye
 *  MULTITHREADING exist karti hai
 *

 * ---------------------------------------------------------
 *  INTERVIEW TRAP QUESTION
 * ---------------------------------------------------------
 * Q: Java program by default multi-threaded hota hai?
 *
 * NO
 * Java program by default SINGLE THREADED hota hai
 *    (main thread ke saath)
 *
 * ---------------------------------------------------------
 * MOST IMPORTANT LINE
 * ---------------------------------------------------------
 * Jab tak tu khud thread create nahi karega,
 * Java single-threaded hi rahegi
 *
 * =========================================================
 */

public class Step2_SingleThreadedProgramAndMainThread {

    public static void main(String[] args) {

        // Ye program ek hi thread (main) pe chal raha hai

        System.out.println("Line 1");
        System.out.println("Line 2");
        System.out.println("Line 3");

        // Current thread ka naam print kar rahe hain
        System.out.println("Current Thread: " + Thread.currentThread().getName());
    }
}
