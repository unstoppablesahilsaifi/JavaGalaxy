package MultiThreading;

/*
 * ================================================
 *     WAIT - NOTIFY SUPER SIMPLE SINGLE FILE
 *     Real-life analogy: Jug (Producer) & Glass (Consumer)
 *     Concepts Covered:
 *       - synchronized
 *       - wait()
 *       - notify()
 *       - shared resource
 *       - thread communication
 * ================================================
 */

class JugGlass {

    private boolean glassHasWater = false;  // false = glass empty, true = water inside

    // Producer = Jug se glass me paani bharna
    public synchronized void fillGlass() throws Exception {

        // Agar glass already filled hai → Producer ruk jayega
        while (glassHasWater) {
            System.out.println("Glass already full → Producer WAIT karega...");
            wait();               // Producer lock release karke wait state me chala gaya
        }

        // Now glass empty hai → Producer fill karega
        glassHasWater = true;
        System.out.println("Producer: Glass filled with water");

        // Ab consumer ko signal ki paani ready hai
        notify();    // Consumer ko uthao
    }

    // Consumer = Glass se paani peena
    public synchronized void drinkGlass() throws Exception {

        // Agar glass empty hai → Consumer ruk jayega
        while (!glassHasWater) {
            System.out.println("Glass empty → Consumer WAIT karega...");
            wait();            // Consumer lock release karke wait me chala gaya
        }

        // Now glass full hai → Consumer peeyega
        glassHasWater = false;
        System.out.println("Consumer: Drank the water");

        // Ab producer ko signal ki glass empty ho gaya
        notify();    // Producer ko uthao
    }
}

public class WaitNotifyExampleCode {

    public static void main(String[] args) {

        JugGlass glass = new JugGlass();

        // Producer Thread (Jug wala)
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    glass.fillGlass();
                    Thread.sleep(300);   // just to slow things for viewing
                }
            } catch (Exception e) {}
        });

        // Consumer Thread (Glass wala)
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    glass.drinkGlass();
                    Thread.sleep(500);
                }
            } catch (Exception e) {}
        });

        producer.start();
        consumer.start();
    }
}
