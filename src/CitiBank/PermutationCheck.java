package CitiBank;

import java.util.Arrays;

/*
@TODO review solution

📌 Question
Check whether array A of length N is a permutation of numbers 1..N.

A permutation contains all values 1..N exactly once.
✅ Solution Idea
If any value out of range → false
Track seen values with boolean.

 */
public class PermutationCheck {

    public static int solution(int[] A) {
        int n = A.length;
        boolean[] seen = new boolean[n + 1];

        for (int v : A) {
            if (v < 1 || v > n) return 0;
            if (seen[v]) return 0;
            seen[v] = true;
        }
        return 1;
    }

    public static void main(String[] args) {
        int[][] tests = {
                {4, 1, 3, 2},
                {4, 1, 3},
                {1, 1, 2, 3},
                {2, 3, 4, 5},
                {}
        };

        for (int[] t : tests) {
            System.out.println("A=" + Arrays.toString(t));
            System.out.println("Permutation? " + PermutationCheck.solution(t));
            System.out.println("----");
        }
    }
}
