package StreamsCodingQuestionsSet2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Basic9_Top3LargestNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 1, 9, 3, 14, 7);
        List<Integer> ans=list.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
        System.out.println("ans = " + ans);
    }
}
