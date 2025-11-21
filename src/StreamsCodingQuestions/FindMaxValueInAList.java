package StreamsCodingQuestions;

import java.util.Arrays;
import java.util.List;

public class FindMaxValueInAList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 4, 5, 2, 1);

        int max = list.stream()
                .mapToInt(Integer::intValue) // Integer → int
                .max()                       // OptionalInt
                .orElse(Integer.MIN_VALUE);  // agar list empty ho

        System.out.println("Max value = " + max);
    }
}
