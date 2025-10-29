package Java17;

import java.util.Scanner;

/*
 💡 Java 17 Feature: Switch Expressions
 -------------------------------------
 ✅ Supports arrow (->) syntax
 ✅ Multiple case labels in one line
 ✅ Can return a value directly (expression form)
*/
public class SwitchExpression {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 🔹 Step 1: User se time input lena (1 to 12)
        System.out.print("Enter time in hours (1-12): ");
        int enterTime = scanner.nextInt();

        // 🔹 Step 2: Switch expression that returns a String value
        String checkTime = switch (enterTime) {
            case 1, 2, 3, 4, 5, 6 -> "Night";
            case 7, 8, 9, 10, 11, 12 -> "Day";
            default -> "Unknown time";
        };

        // 🔹 Step 3: Output print karna
        System.out.println("Time entered: " + enterTime);
        System.out.println("It is: " + checkTime);

        scanner.close();
    }
}
