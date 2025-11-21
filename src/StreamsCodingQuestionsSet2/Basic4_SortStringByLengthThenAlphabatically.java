package StreamsCodingQuestionsSet2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Basic4_SortStringByLengthThenAlphabatically {
    public static void main(String[] args) {
        /* Strings ko pehle length ke hisaab se,
           agar length same ho to alphabetically sort karo.

           Input:  ["bb", "a", "ccc", "ab", "aa"]
           Output: ["a", "aa", "ab", "bb", "ccc"]
        */

        List<String> list = Arrays.asList("bb", "a", "ccc", "ab", "aa");

        List<String> sorted = list.stream()
                .sorted(
                        Comparator
                                .comparingInt(String::length)   // 1. sort by length
                                .thenComparing(Comparator.naturalOrder()) // 2. same length → alphabetically
                )
                .collect(Collectors.toList());

        System.out.println("Sorted list = " + sorted);
    }
}
