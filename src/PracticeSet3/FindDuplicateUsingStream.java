package PracticeSet3;

import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicateUsingStream {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 4};

        // Step 1: Convert int[] -> Stream<Integer>
        Map<Integer, Long> countMap = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        System.out.println("Frequency map: " + countMap);

        // Step 2: Find element(s) having count > 1
        List<Integer> duplicates = countMap.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Duplicate elements: " + duplicates);
    }
}
