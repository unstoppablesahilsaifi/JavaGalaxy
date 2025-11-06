package PracticeSet5;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountMaxFrequencyOfANumber {


        public static void main(String[] args) {

            // Step 1️⃣: Input list
            List<Integer> list = Arrays.asList(5, 2, 5, 3, 2, 4, 5, 3);

            // Step 2️⃣: Count frequency of each number using groupingBy + counting
            Map<Integer, Long> countMap = list.stream()
                    .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

            System.out.println("Count Map = " + countMap);

            // Step 3️⃣: Find the entry with the maximum count
            Map.Entry<Integer, Long> maxEntry = countMap.entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue())   // Compare by value (frequency)
                    .orElse(null);                      // In case map is empty

            // Step 4️⃣: Print result
            if (maxEntry != null) {
                System.out.println("Element: " + maxEntry.getKey() + ", Count: " + maxEntry.getValue());
            }
        }
    }

