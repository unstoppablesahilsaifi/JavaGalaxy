package PracticeSet1;

public class CheckPalindromStringOrNumber {
    public static void main(String[] args) {
        // Check Number
        int n=121;
        int ans=0;
        int temp=n;
        while(temp>0){
            int rem=temp%10;
            ans=ans*10+rem;
            temp=temp/10;
        }
        if(ans==n){
            System.out.println("Yes Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }

        //Check String
        String str="pop";
        //To Modify as we can not modify String directly
        StringBuilder reversedString=new StringBuilder();
        for(int i=str.length()-1;i>=0;i--){
            reversedString.append(str.charAt(i));
        }
        if(str.equals(reversedString.toString())){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
