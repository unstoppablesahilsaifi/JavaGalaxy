package PracticeSet1;

public class ReverseString {
    public static void main(String[] args) {
        String str="Sahil";
        //To Modify as we can not modify String directly
        StringBuilder reversedString=new StringBuilder();
        for(int i=str.length()-1;i>=0;i--){
            reversedString.append(str.charAt(i));
        }
        System.out.println("After Reverse  :   " + reversedString);
    }
}
