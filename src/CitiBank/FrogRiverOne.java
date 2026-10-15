package CitiBank;
/*
A frog starts at position 0 and wants to reach position X.
Leaves fall at positions in array A. Each position can have at most one leaf.

Return the earliest time (index) when the frog can cross.

✅ Key Points
Need leaves on all positions from 1..X.
If impossible, return -1.
💡 Solution Idea
Use boolean array or set.
Track how many unique positions are covered.
Once count == X, return index.

COMMENT FrogRiverOne
COMMENT        HashSet<Integer> positions = new HashSet<>();
COMMENT        for (int i = 0; i < A.length; i++) {
COMMENT            positions.add(A[i]);
COMMENT            if (positions.size() == X) return i;
COMMENT        }
COMMENT        return -1;

 */
import java.util.HashSet;

public class FrogRiverOne {

    public static int solution(int X, int[] A) {

        HashSet<Integer> positions = new HashSet<>();

        for (int i = 0; i < A.length; i++) {

            positions.add(A[i]);

            if (positions.size() == X)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] leaves = {1, 3, 1, 4, 2, 3, 5, 4};

        System.out.println(solution(5, leaves));
    }
}
