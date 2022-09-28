package concepts.sorting;
/*
 * Arrays in methods in java are passed by reference and variables by value
 */
import concepts.utils.*;

public class MergeSort {
    public static void divide(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2; // to save addition overflow
        divide(arr, start, mid);
        divide(arr, mid + 1, end);
        conquer(arr, start, mid, end);
    }

    public static void conquer(int[] arr, int start, int mid, int end) {
        int merged[] = new int[end - start + 1];
        int idx1 = start, idx2 = mid + 1, x = 0;
        while (idx1 <= mid && idx2 <= end) {
            if (arr[idx1] < arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else {
                merged[x++] = arr[idx2++];
            }
        }

        while(idx1 <= mid){
            merged[x++] = arr[idx1++];
        }

        while(idx2 <= end){
            merged[x++] = arr[idx2++];
        }

        // populate the sorted array
        for(int i=0,j=start; i<merged.length; i++, j++){
            arr[j] = merged[i];
        }
    }

    public static int[] sort(int[] arr) {
        divide(arr, 0, arr.length - 1);
        return arr;
    }

    public static void main(String args[]) {
        int[] test = InputUtils.inputTestArray();
        int[] result = sort(test);
        OutputUtils.printArray(result);
    }
}
