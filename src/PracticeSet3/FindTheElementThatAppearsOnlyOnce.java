package PracticeSet3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindTheElementThatAppearsOnlyOnce {
    // Input= [2, 3, 5, 4, 5, 3, 4]
    // Output= 2
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(2,3,5,4,5,3,4);
        Map<Integer,Long> count=list.stream().collect(Collectors.groupingBy(n->n,Collectors.counting()));
        System.out.println(count);
       int ans= count.entrySet().stream().filter(n->n.getValue()==1).map(Map.Entry::getKey).findFirst().orElse(-1);
        System.out.println(ans);
//
    }
}
