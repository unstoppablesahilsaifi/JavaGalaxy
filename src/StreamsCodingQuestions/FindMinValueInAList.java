package StreamsCodingQuestions;

import java.util.Arrays;
import java.util.List;

public class FindMinValueInAList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 4, 5, 2, 1);
        int min=list.stream().mapToInt(Integer::intValue).min().orElse(-1);
        System.out.println("Minimum :" + min);


    }
}
