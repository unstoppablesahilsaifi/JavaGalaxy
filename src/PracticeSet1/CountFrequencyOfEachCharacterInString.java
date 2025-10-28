package PracticeSet1;

import java.util.Map;
import java.util.stream.Collectors;

public class CountFrequencyOfEachCharacterInString {
    public static void main(String[] args) {
        String str="Sahhiiiiill";
        Map<Character,Long> frequency=str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting()));
        System.out.println("frequency = " + frequency);
    }
}
