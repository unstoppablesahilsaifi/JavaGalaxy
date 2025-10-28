package PracticeSet1;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class FindOccurrenceOfEachWordInSentence {
    public static void main(String[] args) {
        String str="I am Sahil Saifi because I am Sahil Saifi Because sahil is saifi";
        str=str.toLowerCase();
        String[] words=str.split(" ");
        Map<String,Long> countFrequency= Arrays.stream(words).collect(Collectors.groupingBy(c->c,Collectors.counting()));
        System.out.println("countFrequency = " + countFrequency);

    }
}
