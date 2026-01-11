package Java8;

import java.util.function.Consumer;

public class ConsumerInterfaceDemo {

    /*
     * Consumer ek Functional Interface hai (Java 8)
     * ➜ Ye input leta hai
     * ➜ Kuch kaam karta hai
     * ➜ Kuch return nahi karta (void)
     *
     * Consumer ka sirf 1 abstract method hota hai:
     * void accept(T t);
     */

    public static void main(String[] args) {

        /*
         * Why Consumer?
         *
         * Kuch kaam aise hote hain jisme:
         * ➜ Sirf print karna hota hai
         * ➜ Logging karni hoti hai
         * ➜ Data save karna hota hai
         *
         * 👉 Return value ki koi zarurat nahi hoti
         */

        /*
         * Consumer<String> ka matlab:
         * ➜ Input = String
         * ➜ Output = nothing (void)
         *
         * s -> System.out.println(s)
         * ➜ Lambda expression
         * ➜ accept() method ki implementation
         */
        Consumer<String> printer = s -> System.out.println(s);

        /*
         * accept("Sahil Bhaiyaa") call hoga:
         * ➜ String print ho jayegi
         */
        printer.accept("Sahil Bhaiyaa");

        /*
         * accept("Java Badhiya cheej h") call hoga:
         * ➜ String print ho jayegi
         */
        printer.accept("Java Badhiya cheej h");
    }

    /*
     * YAAD RAKHNE KA RULE (INTERVIEW):
     *
     * 👉 Consumer = Consume karta hai (input leta hai)
     * 👉 Kuch return nahi karta
     *
     * Examples:
     * Print
     * Log
     * Save to DB
     */
}
