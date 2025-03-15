// 3) Create a program to search for a specific element within an array using linear search.
import java.util.Scanner;
public class LinearSearch {

    public static int linearSearch(int numbers[],int key){
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==key){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int numbers[]={10,20,30,40,50,60};
        System.out.println("Enter key value :");
        int key=sc.nextInt();

        int index=linearSearch(numbers,key);
        if(index==-1){
            System.out.println("Not Found");
        }
        else{
            System.out.println("key is at index :"+index);
        }

        sc.close();
    }
}
