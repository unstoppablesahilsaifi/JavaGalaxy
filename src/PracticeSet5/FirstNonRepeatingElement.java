package PracticeSet5;

import java.util.*;
import java.util.stream.Collectors;

public class FirstNonRepeatingElement {
    public static void main(String[] args) {
        //[2, 3, 4, 2, 3, 5, 6] → Output: 4
        int[] arr = {2, 3, 4, 2, 3, 5, 6};

        // ---------------------- 🧠 BRUTE FORCE APPROACH ----------------------
        int ans = -1;  // default value if not found
        for (int i = 0; i < arr.length; i++) {   // har element ke liye loop
            boolean isRepeating = false;          // assume ki ye non-repeating hai
            for (int j = 0; j < arr.length; j++) {  // fir uske against har element check karo
                if (i != j && arr[i] == arr[j]) {   // agar same element mil gaya (but diff index)
                    isRepeating = true;              // means repeating hai
                    break;                           // check karne ki zarurat nahi, exit inner loop
                }
            }
            if (!isRepeating) {   // agar repeat nahi hua
                ans = arr[i];     // ye hi pehla non-repeating element hai
                break;            // kyunki hume "first" chahiye
            }
        }

        if (ans != -1) {
            System.out.println("Brute Force → First non-repeating element: " + ans);
        } else {
            System.out.println("Brute Force → No non-repeating element found");
        }

        // ---------------------- ⚡ STREAM APPROACH ----------------------
        Map<Integer, Long> countMap = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        OptionalInt firstNonRepeating = Arrays.stream(arr)
                .filter(num -> countMap.get(num) == 1)
                .findFirst();

        if (firstNonRepeating.isPresent()) {
            System.out.println("Stream → First non-repeating element: " + firstNonRepeating);
        } else {
            System.out.println("Stream → No non-repeating element found");
        }
    }
}
