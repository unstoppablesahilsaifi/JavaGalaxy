package StreamsCodingQuestionsSet2;

import java.util.Arrays;
import java.util.List;

public class Basic5_FindMaxNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 40, 20, 90, 70);
        int max=list.stream().mapToInt(Integer::intValue).max().orElse(-1);
        System.out.println("max = " + max);
    }
}
