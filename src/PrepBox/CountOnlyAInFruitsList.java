package PrepBox;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountOnlyAInFruitsList {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple","Banana","Apple");
        int count= (int) list.stream().flatMap(s->s.chars().mapToObj(c->(char)c)).map(Character::toLowerCase).filter(n->n.equals('a')).count();
        System.out.println("count = " + count);
    }
}
