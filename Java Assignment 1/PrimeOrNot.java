// 1) Write a program to check if a given number is prime using an if-else statement.
import java.util.Scanner;
public class PrimeOrNot {

    static boolean checkPrime(int num){
        if(num==1){
            return false;
        }
        if(num==2 || num==3){
            return true;
        }
        if(num%2==0 || num%3==0){
            return false;
        }

        for(int i=5; i<= Math.sqrt(num); i=i+6){
            if(num%i==0 || num%(i+2)==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number you want to check whether it is prime or not: ");
        int num = sc.nextInt();
        System.out.println(checkPrime(num));

        sc.close();
    }
}
