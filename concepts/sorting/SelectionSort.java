package concepts.sorting;

import concepts.utils.*;

public class SelectionSort {
    public static int[] sort(int[] arr) {
        for(int i=0; i<arr.length - 1; i++){
            int min = arr[i],currEl = arr[i], minInd = i;
            for(int j= i + 1; j < arr.length; j ++){
                if(min > arr[j]){
                    min = arr[j];
                    minInd = j;
                }
            }

            arr[i] = min;
            arr[minInd] = currEl;
        }

        return arr;
    }

    public static void main(String args[]) {
        int[] test = InputUtils.inputTestArray();
        int[] result = sort(test);
        OutputUtils.printArray(result);
    }
}
