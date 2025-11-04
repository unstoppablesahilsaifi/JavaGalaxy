package PrepBox;

public class ReverseAllWordFromStringButExtraSpaceIsThere {
    public static void main(String[] args) {
        String str="Hello my name is    Sahil ";

        String[] words=str.split("\\s+");
        StringBuilder result= new StringBuilder();
        for(int i= words.length-1;i>=0;i--){
            if(i!=0){
                result.append(words[i]).append(" ");
            }
            else{
                result.append(words[i]);
            }

        }
        System.out.println("result = " + result.toString());
    }
}
