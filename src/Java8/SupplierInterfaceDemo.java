package Java8;

import java.util.function.Supplier;

public class SupplierInterfaceDemo {

    /*
     * Supplier ek Functional Interface hai (Java 8)
     * ➜ Ye koi input nahi leta
     * ➜ Sirf output provide karta hai
     *
     * Supplier ka sirf 1 abstract method hota hai:
     * T get();
     */

    public static void main(String[] args) {

        /*
         * Why Supplier?
         *
         * Kuch situations hoti hain jaha:
         * ➜ Data generate karna hota hai
         * ➜ Input available nahi hota
         *
         * Examples:
         * ➜ Random value
         * ➜ New object creation
         * ➜ Lazy loading
         */

        /*
         * Supplier<Double> ka matlab:
         * ➜ Input  = none
         * ➜ Output = Double
         *
         * () -> Math.random()
         * ➜ Lambda expression
         * ➜ get() method ki implementation
         */
        Supplier<Double> randomValue = () -> Math.random();

        /*
         * get() call karte hi
         * ➜ New random value generate hoti hai
         */
        System.out.println(randomValue.get());
        System.out.println(randomValue.get());
    }

    /*
     * YAAD RAKHNE KA RULE (INTERVIEW):
     *
     * 👉 Supplier = Sirf deta hai
     * 👉 Input kuch nahi leta
     *
     * Examples:
     * Random number
     * Current date/time
     * New object
     */
}
