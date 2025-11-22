package StreamsCodingQuestionsSet3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitSentenceIntoWords {
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "I love Java",
                "Streams are powerful",
                "flatMap flattens streams"
        );

        List<String> ans = sentences.stream()                     // Stream<String> (each is a sentence)
                .flatMap(s -> Arrays.stream(s.split(" ")))        // Stream<String> (each is a word)
                .collect(Collectors.toList());                    // List<String>

        System.out.println(ans);
    }
}
