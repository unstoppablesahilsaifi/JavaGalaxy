package PracticeSet4;

import java.util.Map;
import java.util.stream.Collectors;

public class SecondMostOccerredCharacterInString {
    public static void main(String[] args) {
        String str="aaaabbaabdd";
        Map<Character,Long> count=str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting()));
        System.out.println("count = " + count);
        char ans = count.entrySet()
                .stream()
                // count ke basis pe descending sort
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                // most occurred ko skip karo
                .skip(1)
                // second element uthao
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Second element not found"));

        System.out.println("Second most occurred character = " + ans);
    }
}
