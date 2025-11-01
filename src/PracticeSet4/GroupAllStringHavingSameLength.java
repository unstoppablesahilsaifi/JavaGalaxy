package PracticeSet4;

import java.util.*;

public class GroupAllStringHavingSameLength {
    public static void main(String[] args) {
        // Input: ["abc","de","fgh","ij"] → {3=[abc, fgh], 2=[de, ij]}
        List<String> str = Arrays.asList("abc", "de", "fgh", "ij");
        Map<Integer, List<String>> ans = new HashMap<>();

        // simple for loop
        for (int i = 0; i < str.size(); i++) {
            String s = str.get(i);
            int len = s.length();

            // agar map me length pehle se hai
            if (ans.containsKey(len)) {
                ans.get(len).add(s); // existing list me add karo
            }
            else {
                // nahi hai to new list banao aur map me daal do
                List<String> temp = new ArrayList<>();
                temp.add(s);
                ans.put(len, temp);
            }
        }

        System.out.println("ans = " + ans);
    }
}
