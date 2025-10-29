package PracticeSet3;

public class RotateArrayByKSteps {
    public static void main(String[] args) {
        // Input: nums = [1, 2, 3, 4, 5, 6, 7], k = 3
        // Output: [5, 6, 7, 1, 2, 3, 4]

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int n = arr.length;

        // Step 1: Normalize k (in case k > n)
        k = k % n;

        // Step 2: Repeat rotation k times
        while (k > 0) {
            // Step 2.1: Store last element
            int last = arr[n - 1];

            // Step 2.2: Shift all elements one step to right
            for (int i = n - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }

            // Step 2.3: Put last element at the front
            arr[0] = last;

            // Step 2.4: Decrease rotation count
            k--;
        }

        // Step 3: Print rotated array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
