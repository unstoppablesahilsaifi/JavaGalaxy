package PracticeSet4;

import java.util.Map;
import java.util.stream.Collectors;

public class FindMaxOccurringCharacterInString {
    public static void main(String[] args) {
        String str = "sahhhhhil";

        // Step 1: Har character ki frequency count karo
        Map<Character, Long> count = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println("Character Frequency: " + count);

        // Step 2: Max occurring character nikalna
        char max = count.entrySet().stream()
                .max(Map.Entry.comparingByValue())   // value ke base par max entry
                .get()                               // Optional se entry lo
                .getKey();                            // uska character

        System.out.println("Max occurring character = " + max);
        char min=count.entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey();
        System.out.println("min = " + min);
    }
}
