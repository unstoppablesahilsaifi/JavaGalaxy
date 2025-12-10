package StreamsCodingQuestionsSet3;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class HighestFrequencyCharacter {
    public static void main(String[] args) {
        String str = "programmingg";

        Map<Character, Long> count =
                str.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println("count = " + count);

        // most frequent character using entrySet
        char c = count.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))   // highest frequency
                .map(Map.Entry::getKey)                                // extract character
                .orElse('\0');                                         // default

        System.out.println("Most frequent = " + c);
    }
}
