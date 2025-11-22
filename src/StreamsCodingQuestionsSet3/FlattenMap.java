package StreamsCodingQuestionsSet3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlattenMap {
    public static void main(String[] args) {
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(2, 3, 4),
                Arrays.asList(4, 5)
        );

        List<Integer> ans = list.stream()               // Stream<List<Integer>>
                .flatMap(n -> n.stream())// Stream<Integer>
                .collect(Collectors.toList());

        System.out.println(ans);
    }
}
