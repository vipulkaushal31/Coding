package concepts.sorting;

import concepts.utils.*;

public class InsertionSort {
    public static int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currElem = arr[i], pivotIndex = i - 1, j = i;

            while(pivotIndex >= 0 && currElem < arr[pivotIndex]){
                arr[j--] = arr[pivotIndex--]; 
            }

            arr[j] = currElem;
        }

        return arr;
    }

    public static void main(String args[]) {
        int[] test = InputUtils.inputTestArray();
        int[] result = sort(test);
        OutputUtils.printArray(result);
    }
}
