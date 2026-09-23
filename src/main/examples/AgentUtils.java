package main.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Utility methods used for small exercises: palindrome generation, max in list, and merge+sort.
 */
public final class AgentUtils {

    private AgentUtils() {
        // utility class
    }

    /**
     * Returns a palindrome by appending characters to the end of the input string.
     * Behavior:
     * - null -> null
     * - empty -> empty
     * - returns the shortest palindrome formed by appending characters to the end
     */

    public static Boolean isPalindrome2(String s){
        if (s == null) return false;
        if (s.isEmpty()) return false;

        boolean isPalindrome = true;
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }


    public static Boolean isPalindrome(String s)
    {
        return s.contentEquals(new StringBuilder(s).reverse());
    }


    public static String toPalindrome(String input) {
        if (input == null) return null;
        if (input.isEmpty()) return input;
        int n = input.length();
        // find smallest i (0..n-1) such that substring(i..n-1) is palindrome
        for (int i = 0; i < n; i++) {
            if (isPalindrome(input, i, n - 1)) {
                StringBuilder sb = new StringBuilder(input);
                // append reverse of prefix [0..i-1]
                for (int j = i - 1; j >= 0; j--) sb.append(input.charAt(j));
                return sb.toString();
            }
        }
        // fallback (should not be reached): mirror whole string
        return input + new StringBuilder(input).reverse();
    }

    private static boolean isPalindrome(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo++) != s.charAt(hi--)) return false;
        }
        return true;
    }

    /**
     * Returns the maximum Integer in the provided list.
     * - null -> null
     * - empty or all-null elements -> null
     * - ignores null elements inside the list
     */
    public static Integer max(List<Integer> list) {
        if (list == null) return null;
        Integer currentMax = null;
        for (Integer v : list) {
            if (v == null) continue;
            if (currentMax == null || v > currentMax) currentMax = v;
        }
        return currentMax;
    }

    /**
     * Merges two lists of Integer and returns a new sorted list (ascending). Inputs are not mutated.
     * - null input treated as empty
     * - null elements inside lists are ignored
     */
    public static List<Integer> mergeAndSort(List<Integer> a, List<Integer> b) {
        List<Integer> out = new ArrayList<>();
        if (a != null) {
            for (Integer v : a) if (v != null) out.add(v);
        }
        if (b != null) {
            for (Integer v : b) if (v != null) out.add(v);
        }
        Collections.sort(out);
        return out;
    }

    /**
     * Recursive binary search on a sorted List<Integer>.
     * Returns the index of target if found, otherwise -1.
     * Behavior:
     * - null list or null target -> -1
     * - expects the list to be sorted in ascending order and contain non-null elements
     */
    public static int binarySearch(List<Integer> list, Integer target) {
        if (list == null || target == null) return -1;
        return binarySearchRecursive(list, target, 0, list.size() - 1);
    }

    private static int binarySearchRecursive(List<Integer> list, Integer target, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        Integer midVal = list.get(mid);
        if (midVal == null) return -1; // defensive: treat nulls as not-findable
        int cmp = Integer.compare(target, midVal);
        if (cmp == 0) return mid;
        if (cmp < 0) return binarySearchRecursive(list, target, lo, mid - 1);
        return binarySearchRecursive(list, target, mid + 1, hi);
    }
}
