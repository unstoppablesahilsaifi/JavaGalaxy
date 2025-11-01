package PracticeSet4;

public class ConvertSnakeCaseToCamelCase {
    public static void main(String[] args) {
        // this_is_test → thisIsTest

        String str = "this_is_test";
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '_') {
                // underscore skip karo aur next character ko uppercase banao
                i++;

                ans.append(Character.toUpperCase(str.charAt(i)));

            } else {
                ans.append(ch);
            }
        }

        System.out.println("ans = " + ans);
    }
}
