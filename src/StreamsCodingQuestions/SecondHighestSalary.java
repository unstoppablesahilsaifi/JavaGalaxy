package StreamsCodingQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondHighestSalary {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(40000, 90000, 75000, 90000, 30000);
        int ans=list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1);
        System.out.println("Second Highest Salary:  " + ans);
    }
}
