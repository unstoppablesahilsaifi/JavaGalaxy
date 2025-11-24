package PracticeSet5;

public class ReverseOnlyVowelsInAString {
    public static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
    public static void main(String[] args) {
        String str = "hello";
        char[] arr = str.toCharArray();

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {

            if (!isVowel(arr[i])) {
                i++;
            }
            else if (!isVowel(arr[j])) {
                j--;
            }
            else {
                // swap vowels
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        }

        System.out.println(new String(arr));  // Output: holle
    }
}
