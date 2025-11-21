package StreamsCodingQuestionsSet2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Basic8_UniqueCharactersFromWords {
    public static void main(String[] args) {
        // Input: ["java", "spring"]
        // Expected Output: [a, g, i, j, n, p, r, s, v]

        List<String> list = Arrays.asList("java", "spring");

        List<Character> ans = list.stream()
                .flatMap(s -> s.chars()                 // IntStream
                        .mapToObj(c -> (char) c) // Stream<Character>
                )
                .distinct()      // remove duplicates across all words
                .sorted()        // sort characters
                .collect(Collectors.toList());

        System.out.println("Unique sorted characters = " + ans);
    }
}
