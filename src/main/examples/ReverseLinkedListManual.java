package main.examples;

import java.util.LinkedList;
import java.util.ListIterator;

public class ReverseLinkedListManual {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        System.out.println("Original LinkedList: " + list);

        LinkedList<String> reversed = new LinkedList<>();
        ListIterator<String> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            reversed.add(iterator.previous());
        }

        System.out.println("Reversed LinkedList: " + reversed);
    }
}

