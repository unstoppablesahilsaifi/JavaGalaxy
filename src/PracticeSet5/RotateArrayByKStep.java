package PracticeSet5;

public class RotateArrayByKStep {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        int size = arr.length;
        int k = 2;
        k = k % size; // 5 steps == full cycle

        while(k > 0){
            int temp = arr[size - 1];   // last element save

            // shift sabko right by 1
            for(int i = size - 1; i > 0; i--){
                arr[i] = arr[i - 1];
            }

            arr[0] = temp;  // saved element ko front me
            k--;
        }

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
