package PracticeSet1;

import java.util.Arrays;
import java.util.List;

public class FindDuplicateElementInAnArrayOrList {
    public static void main(String[] args) {

        // For Array
        int[] arr = {1, 2, 3, 4, 4, 5, 6};
        int ans1 = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    ans1 = arr[i];
                }
            }
        }
        System.out.println("Duplicate in Array = " + ans1);

        // For List
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 5, 6);
        int ans2 = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j && list.get(i).equals(list.get(j))) {
                    ans2 = list.get(i);
                }
            }
        }
        System.out.println("Duplicate in List = " + ans2);
    }
}
