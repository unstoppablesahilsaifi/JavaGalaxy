package PracticeSet3;

public class CompressTheString {
    public static void main(String[] args) {
        String str = "aabccc";
        StringBuilder compressed = new StringBuilder();

        int count = 1; // first character count
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++; // same char mila to count badhao
            } else {
                // different mila to current char + count add karo
                compressed.append(str.charAt(i)).append(count);
                count = 1; // reset for next character
            }
        }

        // last character group ko bhi add karo
        compressed.append(str.charAt(str.length() - 1)).append(count);

        System.out.println(compressed.toString());
    }
}
