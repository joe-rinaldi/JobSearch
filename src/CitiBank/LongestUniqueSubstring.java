package CitiBank;

/*
TODO dont understand solution
 */

import java.lang.classfile.instruction.CharacterRange;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestUniqueSubstring {

    public static int solution(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (lastSeen.containsKey(c)) {
                left = Math.max(left, lastSeen.get(c) + 1);
            }

            lastSeen.put(c, right);

            maxLength = Math.max(
                    maxLength, right - left + 1
            );
        }

        return maxLength;
    }


    public static int solution2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLength = 0;
        Character current = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            Character next = s.charAt(i);
            if (current != next) {
                maxLength++;
            } else {
                maxLength = 0;
            }
            current = next;
        }
        return maxLength;
    }


    public static int solution3(String s) {

        HashSet<Character> set =
                new HashSet<>();

        int left = 0;
        int longest = 0;

        for (int right = 0;
             right < s.length();
             right++) {

            while (set.contains(
                    s.charAt(right))) {

                set.remove(
                        s.charAt(left++));
            }

            set.add(s.charAt(right));

            longest =
                    Math.max(longest,
                            right - left + 1);
        }

        return longest;
    }

    public static void main(String[] args) {
        String[] inputs = {
                "abcabcbb",
                "bbbbb",
                "pwwkew",
                "",
                "abcdef",
                "abba",
                "dvdf",
                "aab"
        };

        int[] expected = {3, 1, 3, 0, 6, 2, 3, 2};

        for (int i = 0; i < inputs.length; i++) {
            int actual = solution3(inputs[i]);

            System.out.printf(
                    "Test %d: \"%s\" expected=%d, actual=%d, %s%n",
                    i + 1, inputs[i], expected[i], actual,
                    actual == expected[i] ? "PASS" : "FAIL"
            );
        }
    }
}
