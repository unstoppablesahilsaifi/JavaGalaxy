package PracticeSet2;

public class FindFirstNonRepeatingCharacter {
    public static void main(String[] args) {

        /* Input: "aabbcdeff"
           Output: c */

        //
        String str = "aabbcdeff";

        //  Har character ka frequency count
        int[] countFreq = new int[26]; // assuming only lowercase letters

        for (int i = 0; i < str.length(); i++) {
            countFreq[str.charAt(i) - 'a']++;
        }

        //  Frequency array loop chalao aur jis index pe count == 1 ho,
        // wahi pehla non-repeating character hoga
        char ans = '\0';
        for (int i = 0; i < countFreq.length; i++) {
            if (countFreq[i] == 1) {
                ans = (char) (i + 'a'); // index se char banaya
                break; // pehla hi chahiye
            }
        }


        if (ans != '\0')
            System.out.println("First non-repeating character = " + ans);
        else
            System.out.println("No non-repeating character found");
    }
}

//
//        countFreq[str.charAt(i) - 'a']++;
//        ```
//
//        Toh agar `str.charAt(i)` `'c'` hai,
//        toh `'c' - 'a' = 99 - 97 = 2`
//        → `countFreq[2]++`
//        Matlab index 2 pe count store ho gaya `'c'` ka.
//
//        ---
//
//       Ab reverse chahiye (Index → Character)
//
//        Ab jab hume ye maloom ho gaya ki `countFreq[2] == 1`,
//        toh hume actual character chahiye (yani `'c'`).
//
//        Toh hum reverse karte hain:
//
//        ```java
//        (char)(i + 'a')
//        ```
//
//         agar `i = 2`,
//        then `'a'` = 97,
//        `97 + 2 = 99`,
//        `(char)99 = 'c'`
//
