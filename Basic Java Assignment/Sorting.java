// 2) Implement a function to sort an array in ascending order using bubble sort or selection sort.

import java.util.Scanner;

public class Sorting {
    //Bubble Sort --->
    public static void bubbleSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    //Selection sort --->
    public static void selectionsort(int arr[]){
       for(int i=0;i<arr.length-1;i++){
        int minPos=i;
        for(int j=i+1;j<arr.length;j++){
            if(arr[minPos]>arr[j]){
                minPos=j;
            }
        }
        int temp=arr[i];
        arr[i]=arr[minPos];
        arr[minPos]=temp;
       }
    }
   

    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter " + size + " elements in array:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        print(arr);
        System.out.println("After sorting :");

        // bubbleSort(arr);
        selectionsort(arr);

        print(arr);
        sc.close();
    }
}
