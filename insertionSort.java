/**************************
 * Author: Aaron Rai
 * Sort  : insertionSort
 **************************/
package SortingVisualizer;

import java.util.Arrays;

public class insertionSort {
    public static void main(String[] args) {
        int arr[] = {3,8,5,4,1,9,-2};
        //Print OG
        System.out.println("Original array");
        System.out.println(Arrays.toString(arr) + "\n");
        
        insertionSorter(arr);
        //Print Sorted
        System.out.println("Sorted array");
        System.out.println(Arrays.toString(arr));
    }

    //Function to perform insertionSort(int[] arr)
    public static void insertionSorter(int[] arr) {
        //Start from second element(element 0 is "sorted")
        for(int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i;

            //Find index j within sorrted array (where i belongs)
            while(j > 0 && arr[j-1] > value) {
                arr[j] = arr[j-1];
                j--;
            }
            //j is shifted to the right by one position 
            arr[j] = value;
        }
    }
}
