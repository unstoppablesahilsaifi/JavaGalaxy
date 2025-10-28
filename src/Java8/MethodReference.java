package Java8;

import java.util.Arrays;
import java.util.List;

// A method reference is shorthand for a lambda expression to call a method directly using ::
//Syntax: ClassName::methodName
public class MethodReference {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Sahil", "Amit", "Rohan", "Priya");

        // Lambda Expression
        names.forEach(name -> System.out.println(name));

        // Method Reference — shortcut for above lambda
        names.forEach(System.out::println);
    }


}
