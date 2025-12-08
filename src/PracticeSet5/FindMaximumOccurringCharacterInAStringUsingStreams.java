package PracticeSet5;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class FindMaximumOccurringCharacterInAStringUsingStreams {
    public static void main(String[] args) {

        String input = "aabbbccccddddddee";

        // Frequency count
        Map<Character, Long> count = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println("count = " + count);

        // Find max occurring character
        char maxChar = count.entrySet().stream()
                .max(Map.Entry.comparingByValue())  // highest value
                .map(Entry::getKey)                 // entry → char
                .orElse('\0');                      // if string empty

        System.out.println("Maximum occurring character = " + maxChar);
    }
}
