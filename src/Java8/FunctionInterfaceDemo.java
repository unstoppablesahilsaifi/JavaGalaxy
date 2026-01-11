package Java8;

import java.util.function.Function;

public class FunctionInterfaceDemo {

    /*
     * Function ek Functional Interface hai (Java 8)
     * ➜ Ye input leta hai aur output return karta hai
     * ➜ Return type mandatory hota hai (void nahi hota)
     *
     * Function ka sirf 1 abstract method hota hai:
     * R apply(T t);
     *
     * T = Input type
     * R = Return type
     */

    public static void main(String[] args) {

        /*
         * Java 8 se pehle:
         * ➜ Transformation logic hard-coded hota tha
         * ➜ Reuse mushkil hota tha
         *
         * Java 8 Function Interface:
         * ➜ Input → Output ka logic reusable ban jata hai
         */

        /*
         * Function<String, Integer> ka matlab:
         * ➜ Input  = String
         * ➜ Output = Integer
         *
         * s -> s.length()
         * ➜ Lambda expression
         * ➜ apply() method ki implementation
         */
        Function<String, Integer> lengthFunction = s -> s.length();

        /*
         * apply("Sahil") call hoga:
         * "Sahil".length() → 5
         */
        System.out.println(lengthFunction.apply("Sahil")); // 5

        /*
         * apply("Java is Java") call hoga:
         * length → 12
         */
        System.out.println(lengthFunction.apply("Java is Java")); // 12
    }

    /*
     * YAAD RAKHNE KA RULE (INTERVIEW):
     *
     * 👉 Function = Convert / Transform karta hai
     *
     * Examples:
     * String   → Integer
     * Employee → Salary
     * Object   → DTO
     */
}
