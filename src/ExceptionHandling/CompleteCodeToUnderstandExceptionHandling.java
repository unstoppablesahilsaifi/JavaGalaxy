package ExceptionHandling;

import java.util.Scanner;

// Custom Exception
class InvalidAge extends Exception {
    InvalidAge(String message) {
        super(message); // parent Exception class ko message bhejna
    }
}

public class CompleteCodeToUnderstandExceptionHandling {

    // Method that can throw custom exception
    public static void checkEligibility(int age) throws InvalidAge {
        if (age < 18) {
            // Custom exception throw karo
            throw new InvalidAge("Age must be 18 or above to vote");
        } else {
            System.out.println("You are eligible to vote!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        try {
            checkEligibility(age);
        } catch (InvalidAge e) {
            System.out.println("Not Valid: " + e.getMessage());
        }
    }
}
