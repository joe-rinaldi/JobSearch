package CitiBank;

/*
TODO review code

COMMENT OddOccurrencesInArray
COMMENT     int x = 0;
COMMENT     for (int v : A) x ^= v;
COMMENT     return x;

 */
import java.util.Arrays;

public class OddOccurrencesInArray {

    public static int solution(int[] A) {
        int x = 0;
        for (int v : A) x ^= v;
        return x;
    }

    public static void main(String[] args) {
        int[][] tests = {
                {9, 3, 9, 3, 9, 7, 9},
                {1, 1, 2},
                {20, 20, 20, 20, 20, 5, 5, 5}, // odd=20? (depends counts)
                {42}
        };

        for (int[] t : tests) {
            System.out.println("A=" + Arrays.toString(t));
            System.out.println("Odd=" + OddOccurrencesInArray.solution(t));
            System.out.println("----");
        }
    }
}
