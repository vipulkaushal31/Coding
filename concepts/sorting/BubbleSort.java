package concepts.sorting;

import concepts.utils.InputUtils;
import concepts.utils.OutputUtils;

public class BubbleSort{
    public static int[] sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;
    }

    public static void main(String args[]) {
        int[] test = InputUtils.inputTestArray();
        int[] result = sort(test);
        OutputUtils.printArray(result);
    }
}