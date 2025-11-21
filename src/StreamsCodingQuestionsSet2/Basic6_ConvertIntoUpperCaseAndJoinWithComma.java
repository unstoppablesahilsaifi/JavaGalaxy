package StreamsCodingQuestionsSet2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Basic6_ConvertIntoUpperCaseAndJoinWithComma {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("java", "spring", "microservices");
        List<String> ans=list.stream().map(s->s.toUpperCase()).collect(Collectors.toList());
        System.out.println("ans = " + ans);
    }
}
