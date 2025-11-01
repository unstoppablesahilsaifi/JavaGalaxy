package PracticeSet2;

public class Sort0s1s2s_DNF_Algo {
    public static void main(String[] args) {
        // arr = [0, 1, 2, 1, 0, 2, 1, 0] -> [0, 0, 0, 1, 1, 1, 2, 2]
        int[] arr = {0, 1, 2, 1, 0, 2, 1, 0};
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        // count each
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count0++;
            } else if (arr[i] == 1) {
                count1++;
            } else if (arr[i] == 2) {
                count2++;
            }
        }

        // overwrite 0s
        for (int i = 0; i < count0; i++) {
            arr[i] = 0;
        }

        // overwrite 1s
        for (int i = count0; i < count0 + count1; i++) {
            arr[i] = 1;
        }

        // overwrite 2s
        for (int i = count0 + count1; i < arr.length; i++) {
            arr[i] = 2;
        }

        // print result
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
