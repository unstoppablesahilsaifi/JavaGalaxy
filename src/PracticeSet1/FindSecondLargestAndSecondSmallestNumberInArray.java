package PracticeSet1;

import java.util.Arrays;
import java.util.Comparator;

public class FindSecondLargestAndSecondSmallestNumberInArray {
    public static void main(String[] args) {
        int[] arr={3,4,5,2,1};
        //Second Largest element
        // Desi bhasha m samjho, list kaam krti h object per, per hm use kr rhe h Array. and reverseOrder kaam krta h
        // object per isliye hmee primitive data type ko boxed krna pdega
        int secondLargest= Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1);
        System.out.println("secondLargest = " + secondLargest);

        //Second Smallest
        int secondSmallest=Arrays.stream(arr).sorted().skip(1).findFirst().orElse(-1);
        System.out.println("secondSmallest = " + secondSmallest);
    }
}
