/**************************
 * Author: Aaron Rai
 * Sort  : MergeSort
 **************************/

package SortingVisualizer;

import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        int arr[] = {3,8,5,4,1,9,-2};
        //Print OG
        System.out.println("Original array");
        System.out.println(Arrays.toString(arr) + "\n");
        
        mergeSorter(arr, arr.length);
        //Print Sorted
        System.out.println("Sorted array");
        System.out.println(Arrays.toString(arr));
    }
    //Fucntion to sort 
    public static void mergeSorter(int[] arr, int i) {
        if(i < 2) {
            return;
        }
        int mid = i/2;
        int [] left_arr = new int[mid];
        int [] right_arr = new int[i-mid];

        //Divide arrays into two and copy to left and right
        int k = 0;
        for(int l = 0; l < i; l++) {
            if(l<mid) {
                left_arr[l] = arr[l];
            }
            else {
                right_arr[k] = arr[l];
                k++;
            }
        }
        //Recursively call to divde arrays down to individual parts
        mergeSorter(left_arr, mid);
        mergeSorter(right_arr, i-mid);
        //Call merge method on each division
        merge(left_arr, right_arr, arr, mid, i-mid);
    }
    public static void merge(int[] left_arr, int[] right_arr, int[] arr, int left_size, int right_size) {
        int i = 0, l = 0, r = 0;
        //While check for conditions when merging
        while(l<left_size && r<right_size) {
            if(left_arr[l]<right_arr[r]) {
                arr[i++] = left_arr[l++];
            }
            else{
                arr[i++] = right_arr[r++];
            }
        }
        while(l < left_size) {
            arr[i++] = left_arr[l++];
        }
        while(r < right_size) {
            arr[i++] = right_arr[r++];
        }
    }
}
