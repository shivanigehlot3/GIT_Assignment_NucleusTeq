// 4) Create a program to calculate the sum of even numbers from 1 to 10 using a while loop.
public class EvenSum {
    public static void main(String[] args) {
        int i = 1;
        int sum = 0;
        while(i<=10){
            if(i % 2 == 0){
                sum+= i;
            }
            i++;
        }

        System.out.println("sum of even numbers from 1 to 10 is : "+sum);
    }
}
