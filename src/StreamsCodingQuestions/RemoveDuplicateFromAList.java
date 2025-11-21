package StreamsCodingQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicateFromAList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,3,4,5,6);
//        //Without Java 8
//        Set<Integer> ans=new HashSet<>();
//        for(int i=0;i< list.size();i++){
//            ans.add(list.get(i));
//        }
//        System.out.println("ans = " + ans);

        // With Java 8
        List<Integer> uniqueList = list.stream()
                .distinct()              // remove duplicates
                .collect(Collectors.toList()); // back to List

        System.out.println("Unique List = " + uniqueList);
    }
}
