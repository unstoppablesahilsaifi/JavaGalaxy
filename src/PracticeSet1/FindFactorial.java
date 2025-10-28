package PracticeSet1;

public class FindFactorial {
    public static void main(String[] args) {
        int n=5;
        int fact=1;
        for(int i=5;i>=1;i--){
            fact=fact*i;
        }
        System.out.println("fact = " + fact);
    }
}
