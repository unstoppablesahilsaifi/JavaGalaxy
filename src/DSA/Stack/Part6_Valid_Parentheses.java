package DSA.Stack;

import java.util.Stack;

/*Example 1

Input
()
Output
true

Example 2
Input
()[]{}
Output
true

Example 3
Input
([{}])
Output
true

Example 4
Input
(]
Output
false


Example 5
Input
([)]
Output
false
*/
public class Part6_Valid_Parentheses {
    public static boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // Opening brackets
            if (ch == '(' || ch == '[' || ch == '{') {

                stack.push(ch);

            } else {

                // Closing brackets

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();

                if (ch == ')' && top != '(') {
                    return false;
                }

                if (ch == ']' && top != '[') {
                    return false;
                }

                if (ch == '}' && top != '{') {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(isValid("([{}])"));
    }
}
