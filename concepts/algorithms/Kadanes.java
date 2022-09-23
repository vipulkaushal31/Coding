package concepts.algorithms;

import concepts.utils.InputUtils;

/*
    The idea of Kadane’s algorithm is to maintain a variable maxEndingHere that stores
     the maximum sum contiguous subarray ending at current index and a variable maxSoFar stores the
     maximum sum of contiguous subarray found so far,
     Everytime there is a positive-sum value in maxEndingHere
     compare it with maxSoFar and update maxSoFar if it is greater than maxSoFar.

    Initialize:
        maxSoFar = INT_MIN
        maxEndingHere = 0

    Loop for each element of the array

      (a) maxEndingHere = maxEndingHere + a[i]
      (b) if(maxSoFar < maxEndingHere)
                maxSoFar = maxEndingHere
      (c) if(maxEndingHere < 0)
                maxEndingHere = 0
    return maxSoFar
*/
public class Kadanes {
    public static int LargestSumContiguousArray(int arr[]) {
        int maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0;
        for(int i=0; i<arr.length; i++){
            maxEndingHere = maxEndingHere + arr[i];
            if(maxSoFar < maxEndingHere){
                maxSoFar = maxEndingHere;
            }
            if(maxEndingHere < 0){
                maxEndingHere = 0;
            }
        }

        return maxSoFar;
    }

    public static void main(String args[]){
        int[] test = InputUtils.inputTestNegArray();
        System.out.println(LargestSumContiguousArray(test));
    }
}
