// 2) Create a program to check if a number is even or odd.

import java.util.Scanner;

public class EvenOddNumber {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
       
        if(num%2 == 0){
            System.out.println(num + " is even number");
        } else{
            System.out.println(num + " is odd number");
        }
        sc.close();
    }
}
