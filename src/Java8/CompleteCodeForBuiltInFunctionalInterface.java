package Java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CompleteCodeForBuiltInFunctionalInterface {
    public static void main(String[] args) {
        //Built-in Functional Interfaces (MUST)
        //1. Predicate- it is used to test a condition, which return the true or false only.
        Predicate<Integer> isEven= n->n%2==0;
        System.out.println(isEven.test(6));

        //2. Function- it takes the input and return the output.
        Function<String,Integer> checkFucntion= s->s.length();
        System.out.println(checkFucntion.apply("Java"));

        //3.Consumer-it takes the input and return nothing, printing ya logging k liye use krte h
        Consumer<String> checkConsumer= s-> System.out.println(s);
        checkConsumer.accept("Java is Java");

        //4. Supplier- it dones not take any input but return the output, jaise koi random value generate krni ho
        Supplier<Double> checkSupplier=()->Math.random();
        System.out.println(checkSupplier.get());
    }
}
