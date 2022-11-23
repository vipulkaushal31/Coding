class Solution {
    public int mySqrt(int x) {
        if(x < 2){
            return x;
        }
        int start = 0, end = x, mid = 0;
        while(start <= end){
            mid = (start + end)/2;
            int divisionResult = x / mid;

            if(mid < divisionResult){
                start = mid + 1;
            } else if (mid > divisionResult) {
                end = mid - 1;
            } else return mid;
        }

        return start - 1;
    }
}