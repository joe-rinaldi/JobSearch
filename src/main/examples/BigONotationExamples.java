package main.examples;

public class BigONotationExamples {

    // O(1) - Constant Time
    public static void constantTimeExample(int[] arr) {
        if (arr.length > 0) {
            System.out.println("First element: " + arr[0]);
        }
    }

    // O(n) - Linear Time
    public static void linearTimeExample(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // O(n^2) - Quadratic Time
    public static void quadraticTimeExample(int[] arr) {
        for (int i : arr) {
            for (int j : arr) {
                System.out.print("(" + i + "," + j + ") ");
            }
            System.out.println();
        }
    }

    // O(log n) - Logarithmic Time (Binary Search)
    public static int binarySearch(int[] sortedArr, int target) {
        int left = 0, right = sortedArr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedArr[mid] == target) return mid;
            else if (sortedArr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1; // Not found
    }

    //write binary search method using recursion





    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("O(1) Example:");
        constantTimeExample(arr);

        System.out.println("\nO(n) Example:");
        linearTimeExample(arr);

        System.out.println("\nO(n^2) Example:");
        quadraticTimeExample(arr);

        System.out.println("\nO(log n) Example (Binary Search):");
        int index = binarySearch(arr, 4);
        System.out.println("Found at index: " + index);
    }
}
