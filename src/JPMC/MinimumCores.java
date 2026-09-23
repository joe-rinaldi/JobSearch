package JPMC;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCores {

    public static int minCoresRequired(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // 1. Sort tasks by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // 2. Min-heap to keep track of end times of active cores
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 3. Process each task
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            // Reuse a core if the earliest finished task is done before/at current start
            if (!minHeap.isEmpty() && minHeap.peek() <= start) {
                minHeap.poll();
            }

            // Allocate core (either reused or new) with current end time
            minHeap.add(end);
        }

        // 4. The size of the heap represents total cores needed
        return minHeap.size();
    }

    public static void main(String[] args) {
        // Sample Input: [start, end] intervals for tasks
        /*
        int[][] tasks = {
                {0, 30},
                {5, 10},
                {15, 20},
                {10, 15}
        };
        */
        int[][] tasks = {
                {1,4},
                {2,6},
                {8,9},
                {7,10}
        };
        int result = minCoresRequired(tasks);

        System.out.println("Tasks Schedule:");
        for (int[] task : tasks) {
            System.out.println(Arrays.toString(task));
        }
        System.out.println("\nMinimum Cores Required: " + result);
    }
}