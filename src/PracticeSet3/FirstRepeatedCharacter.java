package PracticeSet3;

public class FirstRepeatedCharacter {
    public static void main(String[] args) {
/*Input: abca
Output: a */
        String str = "abca";

        //  Har character ka frequency count
        int[] countFreq = new int[26]; // assuming only lowercase letters

        for (int i = 0; i < str.length(); i++) {
            countFreq[str.charAt(i) - 'a']++;
        }

        //  Frequency array loop chalao aur jis index pe count == 1 ho,
        // wahi pehla non-repeating character hoga
        char ans = '\0';
        for (int i = 0; i < countFreq.length; i++) {
            if (countFreq[i] !=0) {
                ans = (char) (i + 'a'); // index se char banaya
                break; // pehla hi chahiye
            }
        }
        System.out.println("ans = " + ans);
    }
}
