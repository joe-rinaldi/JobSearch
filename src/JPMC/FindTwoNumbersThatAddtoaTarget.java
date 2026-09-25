package JPMC;

import java.util.HashMap;
import java.util.Map;
/*
@TODO implement using 2 for loops and return the first pair found
 */
public class FindTwoNumbersThatAddtoaTarget {

    public static int[] findTwoNumbers(int[] numbers, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {

            int complement = target - numbers[i];

            if (map.containsKey(complement)) {
                return new int[]{
                        complement,
                        numbers[i]
                };
            }

            map.put(numbers[i], i);
        }

        return new int[0];
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = findTwoNumbers(nums, target);
        if (result.length == 2) {
            System.out.println("Found numbers: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No two numbers found that add up to the target.");
        }
    }
}
