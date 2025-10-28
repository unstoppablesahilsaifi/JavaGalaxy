package PracticeSet1;

public class ReverseEachWordWithReverseArrayOfString {
    public static void main(String[] args) {
        String str="Java is Love";
        String[] words=str.split(" ");
        StringBuilder finalOutPut=new StringBuilder();
        for(int i= words.length-1;i>=0;i--){
            String temp=words[i];
            StringBuilder reverseString=new StringBuilder();
            for(int j=temp.length()-1;j>=0;j--){
                reverseString.append(temp.charAt(j));

            }
            finalOutPut.append(reverseString).append(" ");
        }
        System.out.println("finalOutPut = " + finalOutPut);
    }
}
