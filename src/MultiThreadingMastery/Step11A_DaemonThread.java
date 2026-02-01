package MultiThreadingMastery;
//Daemon threads are low-priority background threads that automatically stop when all user threads finish.
//JVM sirf USER threads ka wait karti hai isliye main thread khatam to daemon bhi khatam


class DaemonDemo extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("Daemon thread running...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Step11A_DaemonThread {
    public static void main(String[] args) {
        DaemonDemo daemonThread = new DaemonDemo();

        daemonThread.setDaemon(true); // 🔥 daemon bana diya
        daemonThread.start();

        System.out.println("Main thread ends");
    }
}
/*1️⃣ Garbage Collector (Sabse best example)

JVM ka Garbage Collector ek daemon thread hota hai

2️⃣ Background Monitoring / Health Check

Example:

CPU usage monitor

Memory monitor

Thread count monitor*/