package PracticeSet3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaximumOccurringCharacterInString {
    public static void main(String[] args) {
        String str = "aabbbbbbcd";

        // Step 1️⃣: frequency map banao using groupingBy
        Map<Character, Long> freq = str.chars()                 // stream of int (ASCII)
                .mapToObj(c -> (char) c)                        // convert to Character
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        // Step 2️⃣: max frequency nikalne ke liye variables
        char maxChar = ' ';
        long maxCount = 0;

        // Step 3️⃣: normal for loop se iterate karo (no for-each)
        List<Character> keys = new ArrayList<>(freq.keySet());
        for (int i = 0; i < keys.size(); i++) {
            char ch = keys.get(i);
            long count = freq.get(ch);
            if (count > maxCount) {
                maxCount = count;
                maxChar = ch;
            }
        }

        System.out.println("Character with maximum frequency: " + maxChar);
        System.out.println("It occurs " + maxCount + " times.");

    }
}
