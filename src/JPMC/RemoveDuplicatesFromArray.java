package JPMC;

import java.util.*;

public class RemoveDuplicatesFromArray {

    public static int[] removeDuplicates(int[] numbers) {

        return Arrays.stream(numbers)
                .distinct()
                .toArray();
    }

    public static List<Integer> removeDuplicates2(int[] numbers) {

        Set<Integer> set = new LinkedHashSet<>();

        for (int number : numbers) {
            set.add(number);
        }

        return new ArrayList<>(set);
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5};

        int[] result = removeDuplicates(nums);
        System.out.println("Array after removing duplicates: " + java.util.Arrays.toString(result));

        List<Integer> result2 = removeDuplicates2(nums);
        System.out.println("List after removing duplicates: " + result2);

    }
}
