import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Declare variables for first and second rational numbers, and operation results
        Rational first = null;
        Rational second = null;
        boolean validInput = false; // Flag to track valid input
        boolean equals = false; // Flag to track equality between rational numbers
        boolean greaterThan = false; // Flag to track which rational number is greater
        Rational plus = null; // Result of addition operation
        Rational minus = null; // Result of subtraction operation
        Rational multiply = null; // Result of multiplication operation
        Rational divide = null; // Result of division operation

        // Input loop to ensure valid rational numbers are provided
        do {
            try {
                // Input for first rational number
                System.out.print("Enter your Numerator for first number: ");
                Integer firstNumerator = scanner.nextInt();
                System.out.print("\nEnter your denominator for first number: ");
                Integer firstDenominator = scanner.nextInt();
                first = new Rational(firstNumerator, firstDenominator);

                // Input for second rational number
                System.out.print("\nEnter your Numerator for second number: ");
                Integer secondNumerator = scanner.nextInt();
                System.out.print("\nEnter your denominator for second number: ");
                Integer secondDenominator = scanner.nextInt();
                second = new Rational(secondNumerator, secondDenominator);

                // Set validInput flag to true if input is successful
                validInput = true;

                // Compute various operations and set flags
                equals = first.equals(second);
                greaterThan = first.greaterThan(second);
                plus = first.plus(second);
                minus = first.minus(second);
                multiply = first.multiply(second);
                divide = first.divide(second);
            } catch (ArithmeticException | InputMismatchException | NullPointerException | IllegalArgumentException e) {
                // Handle exceptions and prompt user to try again
                System.out.println(e.getMessage() + " Please try again.");
                scanner.nextLine(); // Clear input buffer
            }
        } while(!validInput); // Repeat input until valid input is provided

        // Output results of comparisons and operations
        System.out.println("Is first equals to the Second: " + equals);
        System.out.println("Is first greater than Second: " + greaterThan);

        // Output addition result or error message
        if (plus != null) {
            System.out.println(first + " + " + second + " = " + plus.reduce());
        } else {
            System.out.println("Cannot perform addition operation.");
        }

        // Output subtraction result or error message
        if (minus != null) {
            System.out.println(first + " - " + second + " = " + minus.reduce());
        } else {
            System.out.println("Cannot perform subtraction operation.");
        }

        // Output multiplication result or error message
        if (multiply != null) {
            System.out.println(first + " * " + second + " = " + multiply.reduce());
        } else {
            System.out.println("Cannot perform multiplication operation.");
        }

        // Output division result or error message
        if (divide != null) {
            System.out.println(first + " / " + second + " = " + divide.reduce());
        } else {
            System.out.println("Cannot perform division operation.");
        }

    }
}
