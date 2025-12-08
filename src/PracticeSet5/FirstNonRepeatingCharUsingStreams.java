package PracticeSet5;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharUsingStreams {
    public static void main(String[] args) {

        String str = "abacdbef";

        // 1. Count frequency of each character (LinkedHashMap preserves order)
        Map<Character, Long> count = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c,
                        LinkedHashMap::new,
                        Collectors.counting()));

        System.out.println("count = " + count);

        // 2. First non-repeating character
        char ans = count.entrySet().stream()
                .filter(e -> e.getValue() == 1)      // value = frequency
                .map(Map.Entry::getKey)              // convert entry → key (char)
                .findFirst()                         // take first non-repeating char
                .orElse('\0');                       // default if none found

        System.out.println("First non-repeating char = " + ans);
    }
}
