package StreamsCodingQuestionsSet2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Basic3_CountNamesStartingWithA {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Aman", "Vikas", "ajay", "Rohit", "anil");

        // Case-insensitive filter (A / a dono)
        List<String> ans = list.stream()
                .filter(s -> s.toLowerCase().startsWith("a"))
                .collect(Collectors.toList());

        long count = ans.size();          // ya direct stream se count() bhi kar sakte ho

        System.out.println("Names starting with A/a = " + ans);
        System.out.println("Count = " + count);
    }
}
