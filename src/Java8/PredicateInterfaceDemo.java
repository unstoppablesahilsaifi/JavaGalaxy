package Java8;

import java.util.function.Predicate;

public class PredicateInterfaceDemo {

    /*
     * Predicate ek Functional Interface hai (Java 8)
     * ➜ Iska use condition check karne ke liye hota hai
     * ➜ Ye hamesha boolean (true / false) return karta hai
     *
     * Predicate ka sirf 1 abstract method hota hai:
     * boolean test(T t);
     *
     * Isi wajah se Predicate = Functional Interface
     */

    public static void main(String[] args) {

        /*
         * Predicate<Integer> ka matlab:
         * ➜ Input: Integer
         * ➜ Output: boolean
         *
         * n -> n % 2 == 0
         * ➜ Lambda expression
         * ➜ Ye test() method ki implementation hai
         */
        Predicate<Integer> isEven = n -> n % 2 == 0;

        /*
         * test(10) call hoga:
         * 10 % 2 == 0 → true
         */
        System.out.println(isEven.test(10)); // true

        /*
         * test(7) call hoga:
         * 7 % 2 == 0 → false
         */
        System.out.println(isEven.test(7));  // false
    }

    /*
     * FINAL INTERVIEW LINE::
     * Predicate is a functional interface in Java 8
     * used for condition checking and returns a boolean value.
     */
}
