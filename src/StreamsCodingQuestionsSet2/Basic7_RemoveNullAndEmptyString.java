package StreamsCodingQuestionsSet2;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Basic7_RemoveNullAndEmptyString {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("java", null, " ", "", "streams", " api ");
        List<String> ans=list.stream().filter(Objects::nonNull).map(String::trim).filter(s->!s.isEmpty()).collect(Collectors.toList());
        System.out.println("ans = " + ans);

    }
}
