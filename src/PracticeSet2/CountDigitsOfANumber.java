package PracticeSet2;

public class CountDigitsOfANumber {
    public static void main(String[] args) {
        int num = 1234;
        int count = 0;

        while (num > 0) {
            count++;      // har digit ke liye +1
            num = num / 10;  // last digit hatao
        }

        System.out.println("Total digits = " + count);
    }
}
