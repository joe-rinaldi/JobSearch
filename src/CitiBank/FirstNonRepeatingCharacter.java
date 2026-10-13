package CitiBank;


import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static Character solution(String str) {
        Character[] chars = new Character[26];
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[] inputs = {
                "swiss", "aabbc", "aabb",
                "z", "", "abcabcx", "aAb"
        };

        Character[] expected = {
                'w', 'c', null, 'z', null, 'x', 'a'
        };

        for (int i = 0; i < inputs.length; i++) {
            Character actual = solution(inputs[i]);

            if (java.util.Objects.equals(actual, expected[i])) {
                System.out.println("PASS: " + inputs[i]
                        + " -> " + actual);
            } else {
                System.out.println("FAIL: " + inputs[i]
                        + " expected " + expected[i]
                        + " but got " + actual);
            }
        }
    }
}
