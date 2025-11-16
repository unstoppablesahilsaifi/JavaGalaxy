package PracticeSet5;

import java.util.Stack;

/*Sample Input 1 :
[()]{}{[()()]()}
Sample Output 1 :
Balanced
Explanation Of the Sample Input 1 :
There is always an opening brace before a closing brace i.e. '{' before '}', '(' before '), '[' before ']'.
So the 'S' is Balanced.
Sample Input 2 :
[[}[
Sample Output 2 :
Not Balanced*/
public class ValidParenthesisChecker {

    public static void main(String[] args) {

        String s = "[()]{}{[()()]()}";  // You can change input

        if (isValid(s)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
    }

    public static boolean isValid(String s) {

        int length = s.length();
        if (length == 0)
            return true;

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);

            // Opening bracket → push
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            }

            // Closing with matching top → pop
            else if (!st.isEmpty() && ch == ')' && st.peek() == '(') {
                st.pop();
            }
            else if (!st.isEmpty() && ch == ']' && st.peek() == '[') {
                st.pop();
            }
            else if (!st.isEmpty() && ch == '}' && st.peek() == '{') {
                st.pop();
            }

            // Otherwise invalid
            else {
                return false;
            }
        }

        // Final stack empty ⇒ Balanced
        return st.isEmpty();
    }
}
