package main.examples;

import java.util.Collections;
import java.util.LinkedList;

public class ReverseLinkedListExample {
    public static void main(String[] args) {
        // Create and populate the LinkedList
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        System.out.println("Original LinkedList: " + list);

        // Reverse the LinkedList in place
        Collections.reverse(list);

        System.out.println("Reversed LinkedList: " + list);
    }
}

