package StringCodingQuestions;

import java.util.Scanner;

/*Input: chars = ["a","a","b","b","c","c","c"]
Output: 6
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".

Example 2:
Input: chars = ["a"]
Output: 1
Explanation: The only group is "a", which remains uncompressed since it's a single character.
Example 3:

Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: 4
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".

*/
public class StringCompression_LeetCode443 {
    public static void main(String[] args) {
        char[] name = {'a','a','b','b','c','c','c'};

        StringBuilder ssbb = new StringBuilder();
        int count = 0;

        for(int i = 0; i < name.length; i++) {

            count++;

            // group end condition
            if(i == name.length - 1 || name[i] != name[i + 1]) {

                ssbb.append(name[i]);

                if(count > 1) {
                    ssbb.append(count);
                }

                count = 0; // reset for next group
            }
        }

        int output = ssbb.length();

        System.out.println("Compressed String: " + ssbb.toString());
        System.out.println("Output Length: " + output);

    }
}
