package JPMC;

import java.util.Arrays;
/*
@TODO add method using hashmap or hasset
 */
public class IsAnagram {

    public static boolean isAnagram(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }

        char[] first = a.toLowerCase().toCharArray();
        char[] second = b.toLowerCase().toCharArray();

        Arrays.sort(first);
        Arrays.sort(second);

        return Arrays.equals(first, second);
    }

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        boolean result = isAnagram(str1, str2);
        System.out.println("Are \"" + str1 + "\" and \"" + str2 + "\" anagrams? " + result);
    }
}
