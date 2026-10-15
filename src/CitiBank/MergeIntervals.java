package CitiBank;

/*
COMMENT MergeIntervals
COMMENT     int[][] sorted = new int[intervals.length][];
COMMENT     for (int i = 0; i < intervals.length; i++) {sorted[i] = intervals[i].clone();}
COMMENT     Arrays.sort(sorted,(a, b) -> Integer.compare(a[0], b[0]));
COMMENT     List<int[]> merged = new ArrayList<>();
COMMENT     int[] current = sorted[0];
COMMENT     for (int i = 1; i < sorted.length; i++) {
COMMENT         int[] next = sorted[i];
COMMENT         if (next[0] <= current[1]) {current[1] = Math.max(current[1], next[1]);}
COMMENT         else {merged.add(current);current = next;}
COMMENT     }
COMMENT     merged.add(current);
COMMENT     return merged.toArray(new int[merged.size()][]);

 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static int[][] solution(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        // Copy the input so sorting does not reorder
        // the caller's outer array.
        int[][] sorted = new int[intervals.length][];
        for (int i = 0; i < intervals.length; i++) {
            sorted[i] = intervals[i].clone();
        }

        Arrays.sort(sorted,
                (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        int[] current = sorted[0];

        for (int i = 1; i < sorted.length; i++) {
            int[] next = sorted[i];

            if (next[0] <= current[1]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                merged.add(current);
                current = next;
            }
        }

        merged.add(current);

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][][] inputs = {
                {{1, 3}, {2, 6}, {8, 10}, {15, 18}},
                {{1, 4}, {4, 5}},
                {{1, 2}},
                {{5, 7}, {1, 3}, {2, 6}},
                {},
                {{1, 10}, {2, 3}, {4, 8}}
        };

        int[][][] expected = {
                {{1, 6}, {8, 10}, {15, 18}},
                {{1, 5}},
                {{1, 2}},
                {{1, 7}},
                {},
                {{1, 10}}
        };

        for (int i = 0; i < inputs.length; i++) {
            int[][] actual = solution(inputs[i]);

            boolean pass = Arrays.deepEquals(actual, expected[i]);

            System.out.printf(
                    "Test %d: expected=%s, actual=%s, %s%n",
                    i + 1,
                    Arrays.deepToString(expected[i]),
                    Arrays.deepToString(actual),
                    pass ? "PASS" : "FAIL"
            );
        }
    }
}

