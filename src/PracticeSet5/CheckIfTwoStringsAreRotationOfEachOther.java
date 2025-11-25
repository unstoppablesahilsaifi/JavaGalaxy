package PracticeSet5;

public class CheckIfTwoStringsAreRotationOfEachOther {
    public static void main(String[] args) {

        //"abcd" & "cdab" → TRUE
        String s1 = "abcd";
        String s2 = "cdab";

        // Step 1: Length must be same
        if(s1.length() != s2.length()){
            System.out.println("FALSE");
            return;
        }

        // Step 2: s2 must be a substring of s1+s1
        String combined = s1 + s1;

        if(combined.contains(s2)){
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
    }
}
