package StreamsCodingQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountEvenAndOddNumber {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        long even = nums.stream().filter(n -> n % 2 == 0).count();
        long odd  = nums.stream().filter(n -> n % 2 != 0).count();

        System.out.println("Even count = " + even);
        System.out.println("Odd count = " + odd);
    }
}
