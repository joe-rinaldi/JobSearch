package JPMC;

import java.util.HashSet;
import java.util.Set;
/*
@TODO write your own using hashmap frequency counter
 */
public class FindDuplicates {

    public static void main(String[] args) {
        String input = "programming";
        System.out.println("Input string: " + input);
        System.out.println("Duplicate characters: ");
        findDuplicates(input);

        // Test with an array of integers
        int[] numbers = {1, 2, 3, 2, 4, 5, 1, 6};
        System.out.println("Input array: " +java.util.Arrays.toString(numbers));
        Set<Integer> duplicates = findDuplicates(numbers);
        System.out.println("Duplicate numbers: " + duplicates);
    }

    public static void findDuplicates(String str) {
        int[] charCount = new int[256]; // Assuming ASCII character set

        for (char c : str.toCharArray()) {
            charCount[c]++;
        }

        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] > 1) {
                System.out.println((char) i + ": " + charCount[i]);
            }
        }
    }

    public static Set<Integer> findDuplicates(int[] numbers) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int number : numbers) {
            if (!seen.add(number)) {
                duplicates.add(number);
            }
        }

        return duplicates;
    }
}
