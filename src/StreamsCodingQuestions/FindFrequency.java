package StreamsCodingQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindFrequency {
    public static void main(String[] args) {
        //Frequency In a List
        List<Integer> list = Arrays.asList(3, 4, 5, 2, 1,4,5,6,7,2,3,4);
        Map<Integer,Long> intFreq=list.stream().collect(Collectors.groupingBy(n->n,Collectors.counting()));
        System.out.println("intFreq = " + intFreq);

        String str="SahilSaifi";
        Map<Character,Long> charFreq=str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting()));
        System.out.println("charFreq = " + charFreq);

    }
}
