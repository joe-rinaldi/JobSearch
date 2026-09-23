package test.examples;

import main.examples.Test2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Test2Test {

    @Test
    void testFindMaxIntegerInList_withPositiveNumbers() {
        Test2 t = new Test2();
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Assertions.assertEquals(Integer.valueOf(9), t.findMaxIntegerInList(list));
    }

    @Test
    void testFindMaxIntegerInList_withNegativeNumbers() {
        // current implementation initializes max = 0, so negative-only lists return 0
        Test2 t = new Test2();
        List<Integer> list = Arrays.asList(-5, -3, -1);
        Assertions.assertEquals(Integer.valueOf(0), t.findMaxIntegerInList(list));
    }

    @Test
    void testFindMaxIntegerInList_emptyList() {
        // current implementation returns 0 for empty list
        Test2 t = new Test2();
        List<Integer> empty = new ArrayList<>();
        Assertions.assertEquals(Integer.valueOf(0), t.findMaxIntegerInList(empty));
    }

    @Test
    void testFindMaxIntegerInListUsingStreams() {
        Test2 t = new Test2();
        List<Integer> list = Arrays.asList(1,2,3);
        Assertions.assertEquals(Integer.valueOf(3), t.findMaxIntegerInListUsingStreams(list));

        List<Integer> empty = new ArrayList<>();
        // streams implementation uses orElse(null)
        Assertions.assertNull(t.findMaxIntegerInListUsingStreams(empty));
    }

    @Test
    void testFindMaxIntegerInListUsingCollections() {
        Test2 t = new Test2();
        List<Integer> list = Arrays.asList(1,9,5);
        Assertions.assertEquals(Integer.valueOf(9), t.findMaxIntegerInListUsingCollections(list));

        List<Integer> empty = new ArrayList<>();
        // Collections.max throws NoSuchElementException on empty
        Assertions.assertThrows(NoSuchElementException.class, () -> t.findMaxIntegerInListUsingCollections(empty));
    }

    @Test
    void testFindMaxIntegerInListUsingForLoop() {
        Test2 t = new Test2();
        List<Integer> list = Arrays.asList(1,9,5);
        Assertions.assertEquals(Integer.valueOf(9), t.findMaxIntegerInListUsingForLoop(list));

        List<Integer> empty = new ArrayList<>();
        // for-loop version initializes to Integer.MIN_VALUE so empty returns that
        Assertions.assertEquals(Integer.valueOf(Integer.MIN_VALUE), t.findMaxIntegerInListUsingForLoop(empty));
    }
}

