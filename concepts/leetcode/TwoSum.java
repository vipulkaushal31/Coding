// 1. Two Sum
import java.util.HashMap;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0; i< nums.length; i++){
            int compliment = target - nums[i];
            if(map.containsKey(compliment)){
                return new int[]{i, map.get(compliment)};
            }
            map.put(nums[i], i);
        }

        return new int[2];
    }
}