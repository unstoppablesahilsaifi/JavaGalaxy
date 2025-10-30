package PracticeSet3;

public class DecompressTheString {
    public static void main(String[] args) {
        String compressed = "a2b1c3";  // Input string
        String result = "";

        // har baar ek character aur uske baad ka number lelo
        for (int i = 0; i < compressed.length(); i += 2) {
            char ch = compressed.charAt(i);      // character lo
            int count = compressed.charAt(i + 1) - '0'; // uska count nikalo

            // count times us character ko add karo
            for (int j = 0; j < count; j++) {
                result += ch;
            }
        }

        System.out.println(result); // Output: aabccc
    }
}
