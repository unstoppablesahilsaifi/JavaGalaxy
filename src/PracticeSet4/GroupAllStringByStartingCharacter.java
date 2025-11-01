package PracticeSet4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAllStringByStartingCharacter {
    public static void main(String[] args) {
        // ["apple","ant","bat","ball"] → {a=[apple, ant], b=[bat, ball]}
        String[] words = {"apple", "ant", "bat", "ball"};
        Map<Character, List<String>> ans = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char key = word.charAt(0); // 👈 character key

            if (ans.containsKey(key)) {
                ans.get(key).add(word);
            } else {
                List<String> tempList = new ArrayList<>();
                tempList.add(word);
                ans.put(key, tempList);
            }
        }

        System.out.println("ans = " + ans);
    }
}
