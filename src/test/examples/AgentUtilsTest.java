package test.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import main.examples.AgentUtils;

public class AgentUtilsTest {


    //write junit tests for binarySearchRecursive


    @Test
    void testIsPalindrome2_basic() {
        Assertions.assertTrue(AgentUtils.isPalindrome2("abcba"));
        Assertions.assertTrue(AgentUtils.isPalindrome2("aba"));
        Assertions.assertTrue(AgentUtils.isPalindrome2("madam"));
        Assertions.assertTrue(AgentUtils.isPalindrome2("radar"));

        Assertions.assertFalse(AgentUtils.isPalindrome2("ab"));
        Assertions.assertFalse(AgentUtils.isPalindrome2("hello"));
    }

    @Test
    void testIsPalindrome_basic() {
        Assertions.assertTrue(AgentUtils.isPalindrome("abcba"));
        Assertions.assertTrue(AgentUtils.isPalindrome("aba"));
        Assertions.assertTrue(AgentUtils.isPalindrome("madam"));
        Assertions.assertTrue(AgentUtils.isPalindrome("radar"));

        Assertions.assertFalse(AgentUtils.isPalindrome("ab"));
        Assertions.assertFalse(AgentUtils.isPalindrome("hello"));
    }

    @Test
    void testToPalindrome_basic() {
        Assertions.assertEquals("abcba", AgentUtils.toPalindrome("abcba"));
        Assertions.assertEquals("aba", AgentUtils.toPalindrome("aba"));
        Assertions.assertEquals("madam", AgentUtils.toPalindrome("madam"));
        Assertions.assertEquals("aba", AgentUtils.toPalindrome("ab"));
    }

    @Test
    void testToPalindrome_edgeCases() {
        Assertions.assertNull(AgentUtils.toPalindrome(null));
        Assertions.assertEquals("", AgentUtils.toPalindrome(""));
        Assertions.assertEquals("a", AgentUtils.toPalindrome("a"));
        Assertions.assertEquals("a b a", AgentUtils.toPalindrome("a b a"));
    }

    @Test
    void testMax_happyAndEdge() {
        Assertions.assertEquals(Integer.valueOf(9), AgentUtils.max(Arrays.asList(1,3,9,2)));
        Assertions.assertEquals(Integer.valueOf(-1), AgentUtils.max(Arrays.asList(-5, -1, -10)));
        Assertions.assertNull(AgentUtils.max(null));
        Assertions.assertNull(AgentUtils.max(new ArrayList<>()));
        Assertions.assertEquals(Integer.valueOf(5), AgentUtils.max(Arrays.asList(null, 5, 2)));
        Assertions.assertNull(AgentUtils.max(Arrays.asList(null, null)));
    }

    @Test
    void testMergeAndSort_happyAndEdge() {
        List<Integer> a = Arrays.asList(1,3);
        List<Integer> b = Arrays.asList(2,4);
        Assertions.assertEquals(Arrays.asList(1,2,3,4), AgentUtils.mergeAndSort(a,b));

        List<Integer> a2 = Arrays.asList(1,2);
        List<Integer> b2 = Arrays.asList(2,3);
        Assertions.assertEquals(Arrays.asList(1,2,2,3), AgentUtils.mergeAndSort(a2,b2));

        Assertions.assertEquals(Arrays.asList(1,2), AgentUtils.mergeAndSort(null, Arrays.asList(1,2)));
        Assertions.assertEquals(Collections.emptyList(), AgentUtils.mergeAndSort(null, null));

        List<Integer> withNulls = Arrays.asList(1, null, 3);
        Assertions.assertEquals(Arrays.asList(1,2,3), AgentUtils.mergeAndSort(withNulls, Arrays.asList(2)));

        // ensure inputs not mutated
        List<Integer> original = new ArrayList<>(a);
        AgentUtils.mergeAndSort(a,b);
        Assertions.assertEquals(original, a);
    }
}
