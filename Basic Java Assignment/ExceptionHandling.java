// Create a program to handle exceptions using try-catch blocks.

import java.util.Scanner;

public class ExceptionHandling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter the numerator: ");
            int numerator = sc.nextInt();
            
            System.out.print("Enter the denominator: ");
            int denominator = sc.nextInt();
            
            int result = numerator / denominator;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter integers only.");
        } finally {
            System.out.println("Execution completed.");
            sc.close();
        }
    }
}
