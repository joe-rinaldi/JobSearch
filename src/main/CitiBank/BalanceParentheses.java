package CitiBank;
/*

COMMENT BalanceParentheses
COMMENT     int left = 0; int right = input.length() - 1;
COMMENT     while (left <= right) {
COMMENT         if (input.charAt(left) == '(' && input.charAt(right) == ')') {//ok}
COMMENT         else if (input.charAt(left) == '[' && input.charAt(right) == ']') {//ok}
COMMENT         else if (input.charAt(left) == '{' && input.charAt(right) == '}') {//ok}
COMMENT         else return false;
COMMENT     left++;right--;
COMMENT }
COMMENT return true;

 */
import java.util.Stack;

public class BalanceParentheses {

    public static boolean solution(String input) {

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


    public static boolean solution2(String input) {

        //input validation
        if (input == null  || input.length() % 2 != 0) {
            return false;
        }
        //this is a hack
        input = input.replace("[]","");
        input = input.replace("()","");
        input = input.replace("{}","");

        //not sure why this is true?!
        if (input.isEmpty() )
            return true;

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
        String[] inputs = {
                "()", "()[]{}", "(]", "([)]",
                "{[]}", "(((", "", "){", "[()]"
        };

        boolean[] expected = {
                true, true, false, false,
                true, false, true, false, true
        };

        for (int i = 0; i < inputs.length; i++) {
            boolean actual = solution2(inputs[i]);

            System.out.printf(
                    "Test %d: \"%s\" -> %s (%s)%n",
                    i + 1, inputs[i], actual,
                    actual == expected[i] ? "PASS" : "FAIL"
            );
        }
    }

}
