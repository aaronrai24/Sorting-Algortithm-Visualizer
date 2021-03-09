/**************************
 * Author: Aaron Rai
 * Sort  : bubbleSort
 **************************/
package SortingVisualizer;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int arr[] = {3,8,5,4,1,9,-2};
        //Print OG
        System.out.println("Original array");
        System.out.println(Arrays.toString(arr) + "\n");
        
        bubbleSorter(arr);
        //Print Sorted
        System.out.println("Sorted array");
        System.out.println(Arrays.toString(arr));
    }
    //Function to perform bubble sort
    public static void bubbleSorter(int[] arr) {
        //n-1 passes n is array's length
        for(int k = 0; k < arr.length - 1; k++) {
            //last k is already sorted so inner loop
            //can avoid k
            for(int i = 0; i < arr.length - 1 - k; i++) {
                if(arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
            //Algorithm terminates if inner loop does no swaps
        }
    }
    //Function to swap values
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
