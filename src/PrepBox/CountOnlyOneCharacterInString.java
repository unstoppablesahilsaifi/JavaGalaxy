package PrepBox;

import java.util.Arrays;
import java.util.List;

public class CountOnlyOneCharacterInString {
    public static void main(String[] args) {
        List<String> list=Arrays.asList("apple","orange","banana");
        // a comes 5 times So output should be 5

        long countA = list.stream()
                .flatMap(s -> s.chars().mapToObj(c -> (char)c))
                .filter(ch -> ch == 'a')
                .count();

        System.out.println(countA);

    }
}
