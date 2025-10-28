package PracticeSet2;

public class MoveAllZeros {
    public static void main(String[] args) {
        int[] arr = {0, 8, 7, 0, 8, 0, 9, 0, 9, 9, 9, 9};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] == 0) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("i = " + arr[i]);
        }
    }
}
