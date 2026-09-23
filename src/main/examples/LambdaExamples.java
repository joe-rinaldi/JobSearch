package main.examples;

/*
https://www.bing.com/search?q=lamda%20examples%20in%20java&qs=n&form=QBRE&sp=-1&ghc=1&lq=0&pq=lamda%20examples%20in%20ja&sc=12-20&sk=&cvid=1089BD6B7C6A4C168D8B7C865EA78E13

Explanation
No parameters → Runnable example.
One parameter → Consumer<T> example.
Multiple parameters → BinaryOperator<T> example.
Block body → Multiple statements inside {}.
Collections sort → Pass lambda as a comparator.
Stream API → Transform and reduce data.
Predicate → Boolean condition check.
✅ Key Points about Lambdas in Java:

Syntax: (parameters) -> expression or (parameters) -> { statements }
Can be used wherever a functional interface is expected (an interface with exactly one abstract method).
Improves code readability and reduces boilerplate.
If you want, I can also give you a version showing custom functional interfaces with lambdas so you
can see how to define and use your own.


 */
import java.util.*;
import java.util.function.*;

public class LambdaExamples {
    public static void main(String[] args) {

        // 1. Simple lambda with no parameters
        Runnable greet = () -> System.out.println("Hello from a lambda!");
        greet.run();

        // 2. Lambda with one parameter
        Consumer<String> printer = name -> System.out.println("Hello, " + name);
        printer.accept("Alice");

        // 3. Lambda with multiple parameters and return value
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("Sum: " + add.apply(5, 3));

        // 4. Lambda with block body
        BinaryOperator<Integer> multiply = (a, b) -> {
            int result = a * b;
            return result;
        };
        System.out.println("Product: " + multiply.apply(4, 6));

        // 5. Using lambda with Collections sort
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        names.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        System.out.println("Sorted names: " + names);

        // 6. Using lambda with Stream API
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sumOfSquares = numbers.stream()
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println("Sum of squares: " + sumOfSquares);

        // 7. Predicate example
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));
        System.out.println("Is 7 even? " + isEven.test(7));
    }
}
