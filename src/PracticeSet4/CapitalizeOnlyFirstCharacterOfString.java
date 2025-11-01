package PracticeSet4;

public class CapitalizeOnlyFirstCharacterOfString {
    public static void main(String[] args) {
        String str = "sahil is java developer";
        String[] words = str.split(" ");  // String ko words me tod diya
        StringBuilder ans = new StringBuilder(); // final result yahan store hoga

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder temp = new StringBuilder(); // har word ke liye naya builder

            temp.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1));

            // ab temp ko ans me add karo
            ans.append(temp);

            // har word ke baad ek space add karo (except last)
            if (i < words.length - 1) {
                ans.append(" ");
            }
        }

        System.out.println("ans = " + ans);
    }
}
