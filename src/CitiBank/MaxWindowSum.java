package CitiBank;


public class MaxWindowSum {

    public static long solution(int[] A, int K) {
        if (A == null || K <= 0 || K > A.length) {
            throw new IllegalArgumentException(
                    "K must be between 1 and array length"
            );
        }


        long windowSum = 0;

        for (int i = 0; i < K; i++) {
            windowSum += A[i];
        }

        long maxSum = windowSum;

        for (int i = K; i < A.length; i++) {
            windowSum += A[i];
            windowSum -= A[i - K];

            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {2, 1, 5, 1, 3, 2},
                {1, 2, 3, 4},
                {-5, -2, -8},
                {10},
                {1, 1, 1, 1},
                {-10, 5, 2, 7}
        };

        int[] kValues = {3, 2, 2, 1, 4, 2};
        long[] expected = {9, 7, -7, 10, 4, 9};

        for (int i = 0; i < inputs.length; i++) {
            long actual = solution(inputs[i], kValues[i]);

            System.out.printf(
                    "Test %d: expected=%d, actual=%d, %s%n",
                    i + 1, expected[i], actual,
                    expected[i] == actual ? "PASS" : "FAIL"
            );
        }
    }
}

