package Java17;
/*Pattern Matching for instanceof
allows us to test an object’s type and extract it into a variable in a single, concise step.

Matlab:
Pehle hum instanceof se type check karte the aur alag se cast karte the,
ab dono kaam ek hi step me ho jaata hai.*/


public class PatternMatching {
    public static void main(String[] args) {
        Object obj="Hello Java 17";
        // Old way: instanceof + explicit casting
        if (obj instanceof String) {
            String s = (String) obj;  // Manual type casting
            System.out.println("Length: " + s.length());
            System.out.println("Uppercase: " + s.toUpperCase());
        } else {
            System.out.println("Not a String");
        }


        Object obj1 = "Hello Java 17";

        // New way: instanceof with pattern variable
        if (obj1 instanceof String s) {
            System.out.println("Length: " + s.length());
            System.out.println("Uppercase: " + s.toUpperCase());
        } else {
            System.out.println("Not a String");
        }
    }

}
