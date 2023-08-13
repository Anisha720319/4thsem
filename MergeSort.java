import java.util.Arrays;
import java.util.Random;
public class MergeSort {
/**
* Sorts an integer array using the MergeSort algorithm.
*
* @param arr The array to be sorted
*/
public static void mergeSort(int[] arr) {
mergeSort(arr, 0, arr.length - 1);
}
/**
* Recursive helper method to perform MergeSort on a subarray.
*
* @param arr The array to be sorted
* @param low The starting index of the subarray
* @param high The ending index of the subarray
*/
private static void mergeSort(int[] arr, int low, int high) {
if (low < high) {
int mid = (low + high) / 2;
// Recursively sort the subarrays before and after the middle index
mergeSort(arr, low, mid);
mergeSort(arr, mid + 1, high);
// Merge the sorted subarrays
merge(arr, low, mid, high);
}
}
private static void merge(int[] arr, int low, int mid, int high) {
int n1 = mid - low + 1;
int n2 = high - mid;
int[] left = new int[n1];
int[] right = new int[n2];
// Copy elements from the original array into temporary arrays
for (int i = 0; i < n1; i++) {
left[i] = arr[low + i];
}
for (int j = 0; j < n2; j++) {
right[j] = arr[mid + 1 + j];
}
int i = 0;
int j = 0;
int k = low;
// Merge the two subarrays by comparing elements
while (i < n1 && j < n2) {
if (left[i] <= right[j]) {
arr[k] = left[i];
i++;
} else {
arr[k] = right[j];
j++;
}
k++;
}
// Copy any remaining elements from the left subarray
while (i < n1) {
arr[k] = left[i];
i++;
k++;
}
// Copy any remaining elements from the right subarray
while (j < n2) {
arr[k] = right[j];
j++;
k++;
}
}
public static void main(String[] args) {
int[] sizes = {1000, 2000, 3000, 4000, 5000};
// Iterate over different array sizes
for (int size : sizes) {
int[] arr = generateRandomArray(size);
long startTime = System.nanoTime();
mergeSort(arr);
long endTime = System.nanoTime();
long duration = endTime - startTime;
System.out.println("Sorted array of size " + size + " in " + duration + "
nanoseconds.");
}
}
/**
* Generates a random integer array of the specified size.
*
* @param size The size of the array
* @return The generated random array
*/
public static int[] generateRandomArray(int size) {
int[] arr = new int[size];
Random rand = new Random();
for (int i = 0; i < size; i++) {
arr[i] = rand.nextInt(1000); // Generate random integers between 0 and 999
}
return arr;
}
}
