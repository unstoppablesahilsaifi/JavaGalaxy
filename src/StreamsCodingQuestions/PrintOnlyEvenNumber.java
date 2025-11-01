package StreamsCodingQuestions;

import java.util.Arrays;
import java.util.List;

public class PrintOnlyEvenNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("Even Number List");
        list.stream().filter(n->n%2==0).forEach(n-> System.out.println(n+ " "));
        System.out.println("Odd Number List");

        //Print only Odd Number
        list.stream().filter(n->n%2!=0).forEach(System.out::println);
    }
}
