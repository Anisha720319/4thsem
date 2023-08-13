import java.util.Arrays;
import java.util.Random;
public class QuickSort {
/**
* Sorts an integer array using the QuickSort algorithm.
*
* @param arr The array to be sorted
*/
public static void quickSort(int[] arr) {
quickSort(arr, 0, arr.length - 1);
}
/**
* Recursive helper method to perform QuickSort on a subarray.
*
* @param arr The array to be sorted
* @param low The starting index of the subarray
* @param high The ending index of the subarray
*/
private static void quickSort(int[] arr, int low, int high) {
if (low < high) {
int partitionIndex = partition(arr, low, high);
// Recursively sort the subarrays before and after the partition
quickSort(arr, low, partitionIndex - 1);
quickSort(arr, partitionIndex + 1, high);
}
}

private static int partition(int[] arr, int low, int high) {
int pivot = arr[high];
int i = low - 1;
for (int j = low; j < high; j++) {
if (arr[j] < pivot) {
i++;
swap(arr, i, j);
}
}
swap(arr, i + 1, high);
return i + 1;
}
private static void swap(int[] arr, int i, int j) {
int temp = arr[i];
arr[i] = arr[j];
arr[j] = temp;
}
public static void main(String[] args){
    int[] sizes={1000,2000,3000,4000,5000};
    for(int n:sizes){
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=n-i;
        }
long start=System.nanoTime();
quickSort(arr);
long end=System.nanoTime();
double elapse=(end-start)/1e9;
System.out.println("size:"+n+ "end t" +"="+elapse+"ns");
    }
}
}
