package PracticeSet4;

public class ConvertCamelCaseToSnakeCase {
    public static void main(String[] args) {
        // Example: thisIsTest → this_is_test
        String str = "thisIsTest";
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                ans.append("_").append(Character.toLowerCase(ch));
            } else {
                ans.append(ch);
            }
        }

        System.out.println("ans = " + ans);
    }
}
