package main.examples;

import java.util.ArrayList;
import java.util.List;

/*
https://archive.ph/vOh3R#selection-975.2-985.1

Write a function to find the maximum number in a list of integers.
Given a list of integers, write a function that returns the maximum number in the list.
If the list is empty, return None.
 */
public class MaxNumberInList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>( List.of(1,2,3,4,5,6,7,8,9));
        MaxNumberInList maxNumberInList = new MaxNumberInList();
        System.out.println("Max is "+maxNumberInList.findMaxIntegerInList(list));
    }

    public Integer findMaxIntegerInList(List<Integer> list){
        Integer max = 0;
        //find max integer in list
        for (Integer test : list)
        {
            if (test > max)
                max = test;
        }
        return max;
    }
}