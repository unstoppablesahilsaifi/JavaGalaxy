package PracticeSet4;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacter {

    public static void main(String[] args) {

        // 🔹 Input string jisme hume longest substring without repeating characters find karni hai
        String str = "abcabcbb";

        // 🔹 'left' window ka start index track karega
        int left = 0;

        // 🔹 'maxLength' me ab tak ki longest substring ki length store hogi
        int maxLength = 0;

        // 🔹 'longest' me actual substring store hogi (string khud)
        String longest = "";

        // 🔹 HashSet use kar rahe hain unique characters track karne ke liye
        //    Isme ek time pe sirf current window ke unique characters honge
        HashSet<Character> set = new HashSet<>();

        // 🔹 'right' pointer window ke end ko represent karta hai
        //    For loop poori string traverse karega
        for (int right = 0; right < str.length(); right++) {

            // Current character nikal lo
            char current = str.charAt(right);

            // Agar current character already set me mil gaya, iska matlab duplicate hai
            // To left pointer ko aage badhao jab tak duplicate remove na ho jaye
            while (set.contains(current)) {
                // left pointer ke character ko set se remove karo
                set.remove(str.charAt(left));

                // aur left pointer ek step aage badhao
                left++;
            }

            // Ab current character unique ho gaya, to usse set me add kar lo
            set.add(current);

            // Ab current window ki length = (right - left + 1)
            // Agar ye ab tak ki maxLength se badi hai to update kar do
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;

                // substring(left, right+1) actual unique substring deti hai
                longest = str.substring(left, right + 1);
            }
        }

        // 🔹 Final Output
        System.out.println("Longest substring without repeating characters = " + longest);
        System.out.println("Length = " + maxLength);
    }
}
