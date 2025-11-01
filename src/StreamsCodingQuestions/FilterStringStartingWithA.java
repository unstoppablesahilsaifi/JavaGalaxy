package StreamsCodingQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterStringStartingWithA {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple", "Banana", "Avocado", "Cherry");
        List<String> ans=list.stream().filter(String->String.startsWith("A")).collect(Collectors.toList());
        System.out.println("ans = " + ans);
    }
}
