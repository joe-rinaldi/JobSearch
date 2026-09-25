package JPMC;

import java.util.Stack;

public class BalanceParentheses {

    public static boolean isBalanced(String input) {

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {

                if (stack.isEmpty()) {
                    return false;
                }

                char open = stack.pop();

                if ((c == ')' && open != '(') ||
                        (c == ']' && open != '[') ||
                        (c == '}' && open != '{')) {

                    return false;
                }
            }
        }

        return stack.isEmpty();
    }


    
    public static boolean isBalanced2(String input) {

        //input validation
        if (input == null || input.length() == 0 || input.length() % 2 != 0) {
            return false;
        }

        int left = 0;
        int right = input.length() - 1;

        while (left <= right) {
            if (input.charAt(left) == '(' && input.charAt(right) == ')') {
                //ok
            } else if (input.charAt(left) == '[' && input.charAt(right) == ']') {
                //ok
            } else if (input.charAt(left) == '{' && input.charAt(right) == '}') {
                //ok
            } else
                return false;

            left++;
            right--;
        }

        return true;
    }


    public static void main(String[] args) {
        String test1 = "()";
        String test2 = "([{}])";
        String test3 = "([)]";
        String test4 = "((()))";

        System.out.println(test1 + " is balanced: " + isBalanced2(test1));
        System.out.println(test2 + " is balanced: " + isBalanced2(test2));
        System.out.println(test3 + " is balanced: " + isBalanced2(test3));
        System.out.println(test4 + " is balanced: " + isBalanced2(test4));
    }
}
