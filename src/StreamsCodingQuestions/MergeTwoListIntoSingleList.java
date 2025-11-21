package StreamsCodingQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeTwoListIntoSingleList {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> l2 = Arrays.asList(6, 7, 8, 9, 10);

        List<Integer> ans = Stream.concat(l1.stream(), l2.stream())
                .collect(Collectors.toList());

        System.out.println("Merged List = " + ans);
    }
}
