package PracticeSet1;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFromArrayAndList {
    public static void main(String[] args) {
        // From Array
        int[] arr={1,2,3,4,4,5};
        // We will use Set here because Set m Duplicate allowed nhi hote.
        Set<Integer> afterDuplicate=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            afterDuplicate.add(arr[i]);
        }
        System.out.println("afterDuplicate = " + afterDuplicate);
    }
}
