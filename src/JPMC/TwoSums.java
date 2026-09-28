package JPMC;

import java.util.HashMap;
import java.util.Map;

public class TwoSums {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }

    //write a main method to test the twoSum method
    public static void main(String[] args) {
        TwoSums twoSums = new TwoSums();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSums.twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}