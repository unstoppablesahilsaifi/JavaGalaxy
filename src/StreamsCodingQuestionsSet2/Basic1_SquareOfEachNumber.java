package StreamsCodingQuestionsSet2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Basic1_SquareOfEachNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> ans=list.stream().map(n->n*n).collect(Collectors.toList());
        System.out.println("ans = " + ans);
    }
}
