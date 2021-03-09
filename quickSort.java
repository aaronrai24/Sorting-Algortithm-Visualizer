/**************************
 * Author: Aaron Rai
 * Sort  : quickSort
 **************************/
import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
         //OG array
         Integer[] array = new Integer[] { 12, 13, 24, 10, 3, 6, 90, 70 };
         System.out.println("Unsorted array");
         System.out.println(Arrays.toString(array) + "\n");
 
         quickSort( array, 0, array.length - 1 );
  
         //Sorted array
         System.out.println("Sorted array");
         System.out.println(Arrays.toString(array));
     }
  
     public static void quickSort(Integer[] arr, int low, int high) {
         //check for empty or null array
         if (arr == null || arr.length == 0){
             return;
         }
         if (low >= high){
             return;
         }
         //Get the pivot element from the middle of the list
         int middle = low + (high - low) / 2;
         int pivot = arr[middle];
         // make left < pivot and right > pivot
         int i = low, j = high;
         while (i <= j) {
             //Check until all values on left side array are lower than pivot
             while (arr[i] < pivot) {
                 i++;
             }
             //Check until all values on left side array are greater than pivot
             while (arr[j] > pivot) {
                 j--;
             }
             //Now compare values from both side of lists to see if they need swapping 
             //After swapping move the iterator on both lists
             if (i <= j) {
                 swap (arr, i, j);
                 i++;
                 j--;
             }
         }
         //Recursively call for lower than pivot
         if (low < j){
             quickSort(arr, low, j);
         }
         //Recursively call for higher than pivot
         if (high > i){
             quickSort(arr, i, high);
         }
     }
      
     public static void swap (Integer array[], int x, int y){
         int temp = array[x];
         array[x] = array[y];
         array[y] = temp;
     }  
}
