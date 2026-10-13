package CitiBank;

/*
TODO review solution2
 */

public class MaxStockProfit {

    public static int solution(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }

    public static int solution2(int[] A) {
        if (A == null || A.length < 2) {
            return 0;
        }

        int minPrice = A[0];
        int maxProfit = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i] < minPrice) {
                minPrice = A[i];
            } else {
                int currentProfit = A[i] - minPrice;
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {7, 1, 5, 3, 6, 4},
                {7, 6, 4, 3, 1},
                {1, 2},
                {5},
                {2, 2, 2},
                {3, 10, 1, 12},
                {10, 1, 10}
        };

        int[] expected = {5, 0, 1, 0, 0, 11, 9};

        for (int i = 0; i < inputs.length; i++) {
            int actual = solution2(inputs[i]);

            System.out.printf(
                    "Test %d: expected=%d, actual=%d, %s%n",
                    i + 1, expected[i], actual,
                    expected[i] == actual ? "PASS" : "FAIL"
            );
        }
    }
}
