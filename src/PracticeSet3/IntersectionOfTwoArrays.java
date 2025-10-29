package PracticeSet3;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        // Input
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};

        // Step 1: Convert arr1 into a set
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set1.add(arr1[i]);
        }

        // Step 2: Create another set for intersection
        Set<Integer> intersection = new HashSet<>();

        // Step 3: Compare using normal for loop
        for (int j = 0; j < arr2.length; j++) {
            if (set1.contains(arr2[j])) {
                intersection.add(arr2[j]);
            }
        }

        // Step 4: Print intersection
        System.out.println(intersection);
    }
}
