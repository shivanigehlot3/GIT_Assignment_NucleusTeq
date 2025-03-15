// 1) Write a program to find the average of elements in an array.
import java.util.Scanner;

public class ArrayAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements: ");
        int size = sc.nextInt();

        int[] numbers = new int[size];
        int sum = 0;

        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            numbers[i] = sc.nextInt();
            sum += numbers[i];
        }

        double average = (double) sum / size;
        System.out.println("Average of the elements: " + average);

        sc.close();
    }
}
