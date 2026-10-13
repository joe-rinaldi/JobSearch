package CitiBank;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingPositive {


    public static int solution(int[] A) {
        int n = A.length;

        // Put each value v in position v - 1,
        // when v is between 1 and n.
        for (int i = 0; i < n; i++) {
            while (A[i] >= 1 && A[i] <= n
                    && A[A[i] - 1] != A[i]) {

                int target = A[i] - 1;
                int temp = A[i];
                A[i] = A[target];
                A[target] = temp;
            }
        }

        // The first position not containing i + 1
        // identifies the missing positive integer.
        for (int i = 0; i < n; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }


    public static int solution2(int[] A) {
        Set<Integer> numbers = new HashSet<>();

        for (int num : A) {
            if (num > 0) {
                numbers.add(num);
            }
        }

        int smallest = 1;

        while (numbers.contains(smallest)) {
            smallest++;
        }

        return smallest;
    }


    public static int solution3(int[] A) {
        Arrays.sort(A);

        int expected = 1;

        for (int num : A) {
            if (num == expected) {
                expected++;
            }
        }

        return expected;
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {1, 3, 6, 4, 1, 2},
                {1, 2, 3},
                {-1, -3},
                {2},
                {1},
                {1, 1, 2, 2},
                {100, 200, 300},
                {}
        };

        int[] expected = {5, 4, 1, 1, 2, 3, 1, 1};

        for (int i = 0; i < inputs.length; i++) {
            int actual = solution3(Arrays.copyOf(inputs[i],
                    inputs[i].length));

            System.out.printf(
                    "Test %d: expected=%d, actual=%d, %s%n",
                    i + 1, expected[i], actual,
                    actual == expected[i] ? "PASS" : "FAIL"
            );
        }
    }
}
