package StreamsCodingQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionIntoEvenAndOdd {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // partitioningBy -> true / false key ke basis par list ko tod deta hai
        Map<Boolean, List<Integer>> partitioned =
                numbers.stream()
                        .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        List<Integer> evenNumbers = partitioned.get(true);   // condition true -> even
        List<Integer> oddNumbers  = partitioned.get(false);  // condition false -> odd

        System.out.println("Even numbers : " + evenNumbers);
        System.out.println("Odd numbers  : " + oddNumbers);
    }
}
