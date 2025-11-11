package MultiThreading;
//Print "Main Thread" every 400ms and "Child Thread" every 600ms in parallel.
public class MT_3_Exercise1 {
    public static void main(String[] args) {
        // Step 1: Create a Runnable for Child Thread
        Runnable childTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Child Thread");
                    try {
                        Thread.sleep(600); // 600ms delay
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        // Step 2: Create Thread object and start it
        Thread childThread = new Thread(childTask);
        childThread.start();

        // Step 3: Main thread work (runs parallel)
        for (int i = 1; i <= 8; i++) {
            System.out.println("Main Thread");
            try {
                Thread.sleep(400); // 400ms delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Main and Child Threads Finished!");
    }
}
