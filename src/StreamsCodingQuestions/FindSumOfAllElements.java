package StreamsCodingQuestions;

import java.util.Arrays;
import java.util.List;

public class FindSumOfAllElements {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30, 40);
        int sum=list.stream().reduce(0, (a, b) -> a + b);
        System.out.println("sum = " + sum);
    }
}
