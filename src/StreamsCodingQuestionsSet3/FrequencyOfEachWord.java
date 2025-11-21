package StreamsCodingQuestionsSet3;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyOfEachWord {
    public static void main(String[] args) {
        String str="Java is great and java stream is also great";
        Map<String,Long> frequency= Arrays.stream(str.split(" ")).collect(Collectors.groupingBy(c->c,Collectors.counting()));
        System.out.println("frequency = " + frequency);
    }
}
