package PracticeSet2;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9};

        int s = 0;
        int e = arr.length - 1;

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int mid = s + (e - s) / 2;

        while (s <= e) {   // s <= e hona chahiye
            mid = s + (e - s) / 2;

            if (arr[mid] == num) {
                System.out.println("Found at index: " + mid);
                return;
            }
            else if (num > arr[mid]) {  // right side jao
                s = mid + 1;
            }
            else {                      // left side jao
                e = mid - 1;
            }
        }

        System.out.println("Not Found");
    }
}
