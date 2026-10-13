package CitiBank;

import java.util.HashSet;
import java.util.Set;

public class CountDistinct {

    public static int solution(int[] intervals) {

        if (intervals.length == 0)
            return 0;

        Set<Integer> set = new HashSet<>();
        for (int i : intervals) {
            set.add(i);
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {2, 1, 1, 2, 3},
                {1, 1, 1},
                {},
                {-1, 0, -1, 2},
                {5},
                {Integer.MIN_VALUE, Integer.MAX_VALUE,
                        Integer.MIN_VALUE}
        };

        int[] expected = {3, 1, 0, 3, 1, 2};

        for (int i = 0; i < inputs.length; i++) {
            int actual = solution(inputs[i]);

            System.out.printf(
                    "Test %d: expected=%d, actual=%d, %s%n",
                    i + 1, expected[i], actual,
                    actual == expected[i] ? "PASS" : "FAIL"
            );
        }
    }
}
