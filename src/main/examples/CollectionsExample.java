package main.examples;
/*
https://www.bing.com/search?q=collections%20examples%20in%20java&qs=n&form=QBRE&sp=-1&lq=0&pq=collections%20examples%20in%20java&sc=12-28&sk=&cvid=A765A6D922AF4ADA97C39CC2774EEB52
 */
import java.util.*;

public class CollectionsExample {

    public static void main(String[] args) {
        // ===== LIST EXAMPLE =====
        // List allows duplicates and maintains insertion order
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Apple"); // duplicate allowed
        System.out.println("List (ArrayList) contents: " + fruits);

        // Accessing elements safely
        if (!fruits.isEmpty()) {
            System.out.println("First fruit: " + fruits.get(0));
        }

        // ===== SET EXAMPLE =====
        // Set does not allow duplicates and has no guaranteed order (HashSet)
        Set<String> uniqueFruits = new HashSet<>(fruits);
        System.out.println("Set (HashSet) contents: " + uniqueFruits);

        // ===== MAP EXAMPLE =====
        // Map stores key-value pairs, keys are unique
        Map<String, Integer> fruitCount = new HashMap<>();
        for (String fruit : fruits) {
            fruitCount.put(fruit, fruitCount.getOrDefault(fruit, 0) + 1);
        }
        System.out.println("Map (HashMap) contents: " + fruitCount);

        // Accessing a value safely
        String searchFruit = "Apple";
        if (fruitCount.containsKey(searchFruit)) {
            System.out.println(searchFruit + " count: " + fruitCount.get(searchFruit));
        } else {
            System.out.println(searchFruit + " not found in map.");
        }

        // ===== QUEUE EXAMPLE =====
        // Queue follows FIFO (First-In-First-Out)
        Queue<String> queue = new LinkedList<>();
        queue.offer("Task 1");
        queue.offer("Task 2");
        queue.offer("Task 3");
        System.out.println("Queue contents: " + queue);

        // Processing queue
        while (!queue.isEmpty()) {
            System.out.println("Processing: " + queue.poll());
        }

        // ===== SORTING EXAMPLE =====
        Collections.sort(fruits); // Sort list alphabetically
        System.out.println("Sorted List: " + fruits);

        // ===== IMMUTABLE COLLECTION =====
        List<String> immutableList = List.of("One", "Two", "Three");
        System.out.println("Immutable List: " + immutableList);
        // immutableList.add("Four"); // This will throw UnsupportedOperationException
    }
}
