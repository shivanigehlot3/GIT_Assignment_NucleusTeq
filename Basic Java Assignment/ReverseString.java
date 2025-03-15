// Write a program to reverse a given string.

import java.util.Scanner;
public class ReverseString {

    public static String reverseString(String str){
        String reverse = "";
        for(int i=str.length()-1;i>=0;i--){
            reverse+= str.charAt(i);
        }
        return reverse;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to reverse: ");
        String str = sc.nextLine();

        System.out.println(reverseString(str));

        sc.close();

    }
}
