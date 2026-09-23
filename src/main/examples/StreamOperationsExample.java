package main.examples;
/*
https://www.bing.com/search?q=stream%20api%20examples&FORM=ARPSEC&PC=ARPL&PTAG=30149
 */
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class StreamOperationsExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Alice");
        List<String> result = names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}