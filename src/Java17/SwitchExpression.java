package Java17;

import java.util.Scanner;

/*
 💡 Java 17 Feature: Switch Expressions
 -------------------------------------
  Supports arrow (->) syntax
  Multiple case labels in one line
  Can return a value directly (expression form)
*/

/* Old Switch (Statement):
- Sirf execution karta hai
- Value return nahi karta
- break lagana padta hai
- Code zyada aur error-prone hota hai

 New Switch (Expression) – Java 17:
- Value return karta hai
- break ki zarurat nahi
- Arrow (->) syntax
- Clean, short, readable code*/
public class SwitchExpression {
    public static void main(String[] args) {


        // 🔹 User se input lene ke liye Scanner
        Scanner scanner = new Scanner(System.in);

        // 🔹 Integer input
        int n = scanner.nextInt();

        /*
        ====================================================
         OLD STYLE SWITCH (Statement)
        ====================================================

        - Yahan switch sirf logic execute karta hai
        - Har case ke baad break lagana mandatory
        - Nahi to fall-through problem hota hai
        */

        /*
        switch (n) {
            case 1:
            case 2:
                System.out.println("Under 2");
                break;

            case 3:
            case 4:
                System.out.println("Over 2 Under 4");
                break;

            default:
                System.out.println("Thank You");
        }
        */

        /*
        ====================================================
         NEW STYLE SWITCH (Expression) – Java 17
        ====================================================

         switch ab ek VALUE return karta hai
         Arrow (->) use hota hai
         break likhne ki zarurat nahi
         Multiple cases ek line me likh sakte ho
        */

        String ans = switch (n) {

            // Agar n = 1 ya 2 ho
            case 1, 2 -> "Under 2";

            // Agar n = 3 ya 4 ho
            case 3, 4 -> "second";

            // Agar koi aur value ho
            default -> "Wow";
        };

        // 🔹 Returned value print kar rahe hain
        System.out.println("ans = " + ans);

        /*
        ====================================================
         IMPORTANT POINTS (Interview Ready)
        ====================================================

         switch expression semicolon (;) se end hota hai
         default mandatory hota hai (safety ke liye)
         Direct value assign kar sakte ho
         Java 14+ me introduce hua (stable in Java 17)

         switch expression me break allowed nahi
         fall-through allowed nahi
        */
    }
}
