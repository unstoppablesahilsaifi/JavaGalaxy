package StreamsCodingQuestionsSet3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupNumbersByEvenAndOdd {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        Map<String, List<Integer>> grouped = list.stream()
                .collect(Collectors.groupingBy(
                        n -> n % 2 == 0 ? "EVEN" : "ODD"   // key ban rahi hai
                ));

        System.out.println(grouped);
    }
}
