package StreamsCodingQuestionsSet3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionNumberByGreaterThan10 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 12, 8, 20);

        Map<Boolean, List<Integer>> ans =
                list.stream()
                        .collect(Collectors.partitioningBy(n -> n > 10));

        System.out.println(ans);
    }
}
