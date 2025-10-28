package PracticeSet1;

public class CheckPrimeNumber {
    public static void main(String[] args) {
        int n=9;
        boolean check=true;
        for(int i=2;i<n;i++){
            if(n%i==0){
                check=false;
            }
        }
        if(check){
            System.out.println("Prime h");
        }else{
            System.out.println("Nahi h");
        }
    }
}
