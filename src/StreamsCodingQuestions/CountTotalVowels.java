package StreamsCodingQuestions;

import java.util.Arrays;
import java.util.List;

public class CountTotalVowels {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("java","flatmap","stream");
        long vowels = list.stream()
                .flatMap(s -> s.chars().mapToObj(c -> (char)c))
                .filter(ch -> "aeiou".indexOf(ch) != -1)
                .count();
        System.out.println(vowels);

        // Brute Force
        int countV = 0;
        for (int i = 0; i < list.size(); i++) {
            String temp = list.get(i);
            for (int j = 0; j < temp.length(); j++) {
                char ch = temp.charAt(j);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    countV++;
                }
            }
        }
        System.out.println("countV = " + countV);


    }
}
