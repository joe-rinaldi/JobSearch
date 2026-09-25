package JPMC;
/*
@TODO write your own
 */
public class ReverseString {
    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }

        return reversed.toString();
    }

    public static String reverse(String str) {
        char[] chars = str.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String testString = "Hello, World!";
        System.out.println("Original string: " + testString);
        System.out.println("Reversed string: " + reverseString(testString));
        System.out.println("Reversed string (in-place): " + reverse(testString));
    }
}
