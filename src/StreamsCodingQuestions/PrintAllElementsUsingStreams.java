package StreamsCodingQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintAllElementsUsingStreams {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> ans=nums.stream().collect(Collectors.toList());
        System.out.println("ans = " + ans);
        //2nd way
        nums.stream().forEach(n-> System.out.println(n+ " "));
    }
}
