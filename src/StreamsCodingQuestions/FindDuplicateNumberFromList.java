package StreamsCodingQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDuplicateNumberFromList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 2, 4, 1, 2, 5, 3);
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {  // 👈 notice: j = 0 se start hai
                if (i != j && list.get(i).equals(list.get(j))) { // 👈 comparing all pairs except same index
                    if (!duplicates.contains(list.get(i))) {
                        duplicates.add(list.get(i));
                    }
                }
            }
        }

        System.out.println("Duplicate Numbers: " + duplicates);
    }
}
