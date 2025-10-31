package PracticeSet4;

import java.util.Scanner;

public class ConvertNumberToWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String input = sc.nextLine().trim(); // Step 1: input as string (trimmed)

        // Step 2: handle empty input
        if (input.isEmpty()) {
            System.out.println("Invalid input");
            return;
        }

        // Step 3: sign handling
        boolean isNegative = false;


        // Step 5: mapping digits to words
        String[] words = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

        StringBuilder result = new StringBuilder();



        // Step 7: convert each digit
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int digit = c - '0'; // char to int
            result.append(words[digit]);

            // add space between words except after last word
            if (i != input.length() - 1) {
                result.append(" ");
            }
        }

        // Step 8: print final output
        System.out.println(result.toString());
    }
}
