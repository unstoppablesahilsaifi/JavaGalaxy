package StreamsCodingQuestionsSet2;

import java.util.Arrays;
import java.util.List;

public class Basic10_CheckAllPostiveAnyNegativeNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        // Check: Are all numbers positive?
        boolean allPositive = list.stream()
                .allMatch(n -> n > 0);

        // Check: Is there any negative number?
        boolean anyNegative = list.stream()
                .anyMatch(n -> n < 0);

        System.out.println("All numbers are positive? " + allPositive);
        System.out.println("Any negative number present? " + anyNegative);
    }
}
