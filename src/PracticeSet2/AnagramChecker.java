package PracticeSet2;

public class AnagramChecker {
    public static void main(String[] args) {
        String s1="silent";
        String s2="listen";

        int[] count=new int[26];
        for(int i=0;i<s1.length();i++){
            count[s1.charAt(i)-'a']++;
            count[s2.charAt(i)-'a']--;
        }
        for(int i=0;i<count.length;i++){
            if(count[i]!=0){
                System.out.println("Not Anagram");
                break;
            }
        }
        System.out.println("Yaha tak aa gye mtlb anagaram h kyuki pura array traverse ho gya sab zero mile ");
    }
}
