package JPMC;

import java.util.HashSet;
import java.util.Set;
/*
@TODO write your own using chararrays

 */
public class FirstDuplicateCharacter {
    public static Character firstDuplicate(String str) {

        Set<Character> seen = new HashSet<>();

        for (char c : str.toCharArray()) {

            if (!seen.add(c)) {
                return c;
            }
        }
        return null;
    }



    public static void main(String[] args) {
        String testInput = "abca";
        Character result = firstDuplicate(testInput);
        if (result != null) {
            System.out.println("First duplicate character: " + result);
        } else {
            System.out.println("No duplicate characters found.");
        }
    }
}
