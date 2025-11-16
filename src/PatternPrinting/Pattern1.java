package PatternPrinting;

public class Pattern1 {
    public static void main(String[] args) {
        /*
         Output:
         1  2  3  4  5
         10 9  8  7  6
         11 12 13 14 15
         20 19 18 17 16
        */

        int n = 5; // rows/columns

        for(int i = 0; i < n; i++) {

            // Row ka start number calculate karo
            int start = i * n + 1;

            // Agar row even -> straight print
            if(i % 2 == 0) {
                for(int j = 0; j < n; j++) {
                    System.out.print((start + j) + " ");
                }
            }
            // Agar row odd -> reverse print
            else {
                for(int j = 0; j < n; j++) {
                    System.out.print((start + (n - 1 - j)) + " ");
                }
            }

            System.out.println(); // next line
        }
    }
}
