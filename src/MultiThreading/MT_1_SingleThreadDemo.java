package MultiThreading;

public class MT_1_SingleThreadDemo {
    public static void main(String[] args) {
        task1();
        task2();
    }

    static void task1() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Task 1 - Step " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }

    static void task2() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Task 2 - Step " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}

/*Observation:

Task 2 tabhi start hota hai jab Task 1 pura khatam ho jaata hai.
Ye sequential execution hai.
*/