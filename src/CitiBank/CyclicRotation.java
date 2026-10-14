package CitiBank;
/*
TODO review code

COMMENT CyclicRotation
COMMENT            if (A == null || A.length == 0 || K % A.length == 0) return A;
COMMENT            int n = A.length;
COMMENT            K = K % n; // Avoid redundant rotations
COMMENT            int[] rotated = new int[n];
COMMENT            for (int i = 0; i < n; i++) {
COMMENT                int newIndex = (i + K) % n;
COMMENT                rotated[newIndex] = A[i];}
COMMENT            return rotated;

Question
Given an array A of N integers and an integer K, rotate the array to the right by K steps.

✅ Key Points
Rotation by K % N only matters.
Handle N=0 and N=1.
💡 Solution Idea
Create new array result.
For each index i, destination is (i + K) % N.
 */
import java.util.Arrays;

public class CyclicRotation {

    public static class Solution {
        public int[] solution(int[] A, int K) {
            if (A == null || A.length == 0 || K % A.length == 0) {
                return A;
            }

            int n = A.length;
            K = K % n; // Avoid redundant rotations
            int[] rotated = new int[n];

            for (int i = 0; i < n; i++) {
                int newIndex = (i + K) % n;
                rotated[newIndex] = A[i];
            }

            return rotated;
        }
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        System.out.println("\n--- Testing Question 2: Cyclic Rotation ---");

        // Test 1: Standard rotation
        int[] result1 = solver.solution(new int[]{3, 8, 9, 7, 6}, 3);
        System.out.println("Test 1: " + Arrays.toString(result1) + " | Expected: [9, 7, 6, 3, 8]");

        // Test 2: K larger than array length
        int[] result2 = solver.solution(new int[]{1, 2, 3, 4}, 6); // 6 % 4 = 2 rotations
        System.out.println("Test 2: " + Arrays.toString(result2) + " | Expected: [3, 4, 1, 2]");

        // Test 3: Empty array edge case
        int[] result3 = solver.solution(new int[]{}, 4);
        System.out.println("Test 3: " + Arrays.toString(result3) + " | Expected: []");

        // Test 4: Single element array
        int[] result4 = solver.solution(new int[]{10}, 100);
        System.out.println("Test 4: " + Arrays.toString(result4) + " | Expected: [10]");
    }
}
