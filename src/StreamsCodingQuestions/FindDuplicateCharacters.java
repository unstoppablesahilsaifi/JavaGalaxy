package StreamsCodingQuestions;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindDuplicateCharacters {
    public static void main(String[] args) {
        String str = "sahiill";

        // Step 1: char → groupingBy → frequency map
        Map<Character, Long> count = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        // Step 2: frequency > 1 wale characters filter karo
        List<Character> duplicates = count.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)   // only duplicates
                .map(Map.Entry::getKey)                  // sirf character chahiye
                .collect(Collectors.toList());           // list me collect

        System.out.println("Duplicate chars = " + duplicates);
    }
}
