/**************************
 * Author: Aaron Rai
 * Sort  : selectionSort
 **************************/
package SortingVisualizer;

import java.util.Arrays;

public class selectionSort {
    public static void main(String[] args) {
        int arr[] = {3,8,5,4,1,9,-2};
        //Print OG
        System.out.println("Original array");
        System.out.println(Arrays.toString(arr) + "\n");
        
        selectionSorter(arr);
        //Print Sorted
        System.out.println("Sorted array");
        System.out.println(Arrays.toString(arr));
    }
    //Function to perform selection sort
    public static void selectionSorter(int[] arr) {
        //run n-1 times where n is array length
        for(int i = 0; i < arr.length - 1; i++) {
            //find the minimum element in unsorted list
            //swap it with arr[i]
            int min = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr,min,i);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
