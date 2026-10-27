package Leidos;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/*
Design a class that processes a stream of integers one at a time and supports two operations:
add(num), which records a new number, and
hasPair(target), which returns True if any two numbers currently in the last W numbers added sum to target.
Numbers that fall outside the most recent W adds no longer count.
W = 3
add(1)
add(5)
add(3)
hasPair(8)   -> True  # 5 + 3
add(9)       # window is now [5, 3, 9]; the 1 has expired
hasPair(6)   -> False # 1 + 5 no longer counts, 1 has expired
hasPair(12)  -> True  # 3 + 9

 */

public class RecentPairSum {
    private final int windowSize;
    private final ArrayDeque<Integer> window = new ArrayDeque<>();
    private final Map<Integer, Integer> frequencies = new HashMap<>();

    public RecentPairSum(int windowSize) {
        if (windowSize <= 0) {
            throw new IllegalArgumentException("windowSize must be positive");
        }
        this.windowSize = windowSize;
    }

    public void add(int num) {
        if (window.size() == windowSize) {
            int expired = window.removeFirst();
            int remaining = frequencies.get(expired) - 1;
            if (remaining == 0) {
                frequencies.remove(expired);
            } else {
                frequencies.put(expired, remaining);
            }
        }

        window.addLast(num);
        frequencies.merge(num, 1, Integer::sum);
    }

    public boolean hasPair(int target) {
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            long complement = (long) target - entry.getKey();
            if (complement < Integer.MIN_VALUE || complement > Integer.MAX_VALUE) {
                continue;
            }

            int other = (int) complement;
            if (other == entry.getKey()) {
                if (entry.getValue() >= 2) {
                    return true;
                }
            } else if (frequencies.containsKey(other)) {
                return true;
            }
        }
        return false;
    }
}
