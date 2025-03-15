// 3) Create a program to convert a temperature from Celsius to Fahrenheit and vice versa.

import java.util.Scanner;
public class TemperarureConverter {

    static float convertToFarenheit(float celsius){
        float far = celsius * 9/5 + 32;
        return far;
    }

    static float convertToCelsius(float fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter temperature in Celsius :");
        float celsius = sc.nextFloat();
        System.out.println("Temperature in Farenheit :"+convertToFarenheit(celsius));

        System.out.println("Enter temperature in Farenheit :");
        float far = sc.nextFloat();
        System.out.println("Temperature in Celcius :"+convertToCelsius(far));

        sc.close();
    }
}
