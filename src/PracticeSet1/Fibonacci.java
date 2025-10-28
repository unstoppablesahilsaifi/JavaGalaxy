package PracticeSet1;

public class Fibonacci {
    public static void main(String[] args) {
        // 0 1 1 2 3 5 8 13-----
        int f=0;
        int s=1;
        int next = 0;
        System.out.println(f);
        System.out.println(s);
        for(int i=2;i<10;i++){
            next = f + s;
            System.out.println(next);
            f = s;
            s = next;
        }
    }
}
