package PracticeSet4;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        String str = "abcabcbb";
        int left = 0;
        int right = 0;
        int maxLength = 0;
        String longest = "";

        HashSet<Character> set = new HashSet<>();

        while (right < str.length()) {
            char current = str.charAt(right);

            // Agar character already set me hai, to left se remove karo
            while (set.contains(current)) {
                set.remove(str.charAt(left));
                left++;
            }

            // Add current character and move right
            set.add(current);
            right++;

            // Max length update
            if (right - left > maxLength) {
                maxLength = right - left;
                longest = str.substring(left, right);
            }
        }

        System.out.println("Longest substring = " + longest);
        System.out.println("Length = " + maxLength);
    }
}
