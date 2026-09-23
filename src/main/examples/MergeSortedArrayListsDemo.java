package main.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeSortedArrayListsDemo {

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(List.of(2,5,8,1,3));
        ArrayList<Integer> list2 = new ArrayList<>(List.of(3,4,9,4,6));

        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);

        // Merge the two sorted lists
        List<Integer> mergeSortedArrayLists = mergeSortedArrayLists(list1, list2);
        System.out.println("mergeSortedArrayLists: " + mergeSortedArrayLists);

        List<Integer> mergeArrayListsAndSort = mergeArrayListsAndSort(list1, list2);
        System.out.println("mergeArrayListsAndSort: " + mergeArrayListsAndSort);
    }

    public static List<Integer> mergeArrayListsAndSort(ArrayList<Integer> list1, ArrayList<Integer> list2){
        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(list1);
        result.addAll(list2);
        Collections.sort(result);
        return result;
    }


    // Function to merge two sorted ArrayLists into a single sorted ArrayList
    public static List<Integer> mergeSortedArrayLists(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        // Append remaining elements from list1, if any
        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }

        // Append remaining elements from list2, if any
        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;
    }

}

