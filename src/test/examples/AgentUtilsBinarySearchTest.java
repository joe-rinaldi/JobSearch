package test.examples;

import main.examples.AgentUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class AgentUtilsBinarySearchTest {

    // helper to invoke the private static binarySearchRecursive method via reflection
    private int callPrivateBinarySearchRecursive(List<Integer> list, Integer target, int lo, int hi) throws Exception {
        Method m = AgentUtils.class.getDeclaredMethod("binarySearchRecursive", List.class, Integer.class, int.class, int.class);
        m.setAccessible(true);
        return (Integer) m.invoke(null, list, target, lo, hi);
    }

    @Test
    void testRecursiveFoundMiddle() throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(2, callPrivateBinarySearchRecursive(list, 3, 0, 4));
    }

    @Test
    void testRecursiveNotFound() throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 4, 5);
        assertEquals(-1, callPrivateBinarySearchRecursive(list, 3, 0, 3));
    }

    @Test
    void testRecursiveNullElementAtMidReturnsMinusOne() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(null); // will be mid when lo=0, hi=2
        list.add(3);
        assertEquals(-1, callPrivateBinarySearchRecursive(list, 3, 0, 2));
    }

    @Test
    void testRecursiveLoGreaterThanHiReturnsMinusOne() throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 3);
        assertEquals(-1, callPrivateBinarySearchRecursive(list, 2, 2, 1));
    }

    @Test
    void testPublicBinarySearchBehavior() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        assertEquals(1, AgentUtils.binarySearch(list, 2));     // found
        assertEquals(-1, AgentUtils.binarySearch(list, 4));    // not found
        assertEquals(-1, AgentUtils.binarySearch(null, 1));    // null list -> -1 per implementation
        assertEquals(-1, AgentUtils.binarySearch(list, null)); // null target -> -1 per implementation
    }
}

