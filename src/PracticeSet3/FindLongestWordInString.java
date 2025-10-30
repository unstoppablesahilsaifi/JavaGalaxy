package PracticeSet3;

public class FindLongestWordInString {
    public static void main(String[] args) {
        String str="I am sahil saifi and I am Java Developer";
        String[] arr=str.split(" ");
        String temp=arr[0];
        String ans="";
        for(int  i=0;i<arr.length;i++){
            if(temp.length()<arr[i].length()){
                ans=arr[i];
            }
        }
        System.out.println("ans = " + ans);
    }
}
