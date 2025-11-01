package StreamsCodingQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertAllElementToSquare {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);
        List<Integer> ans=list.stream().map(n->n*n).collect(Collectors.toList());
        System.out.println("ans = " + ans);
    }
}