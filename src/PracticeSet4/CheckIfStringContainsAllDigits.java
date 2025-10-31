package PracticeSet4;

public class CheckIfStringContainsAllDigits {
    public static void main(String[] args) {
        String str="123a";
        Boolean checker=true;
        for(int i=0;i<str.length();i++){
            if(!Character.isDigit(str.charAt(i))){
                checker=false;
            }
        }
        if(checker){
            System.out.println("Saari Digits h");
        }
        else {
            System.out.println("Saari Digits nhi h");
        }
    }
}
