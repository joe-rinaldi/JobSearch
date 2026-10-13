package CitiBank;


public class BinarySearch {

    public static int solution(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (A[mid] == target) {
                return mid;
            }

            if (A[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {-5, -1, 0, 3, 8, 12},
                {1, 3, 5, 7},
                {10},
                {},
                {1, 2, 3, 4, 5},
                {-10, 0, 10}
        };

        int[] targets = {8, 4, 10, 5, 1, -10};
        int[] expected = {4, -1, 0, -1, 0, 0};

        for (int i = 0; i < inputs.length; i++) {
            int actual = solution(inputs[i], targets[i]);

            System.out.printf(
                    "Test %d: expected=%d, actual=%d, %s%n",
                    i + 1, expected[i], actual,
                    actual == expected[i] ? "PASS" : "FAIL"
            );
        }
    }
}

