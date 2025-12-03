package PracticeSet5;

public class RemoveDuplicateBruteForce {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5};

        int k = 0; // unique index

        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;

            // check if arr[i] already exists in arr[0..k-1]
            for (int j = 0; j < k; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                arr[k] = arr[i];
                k++;
            }
        }

        System.out.println("Unique Count = " + k);
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
