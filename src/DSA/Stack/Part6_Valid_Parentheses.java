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


//package PracticeSet5;
//
//import java.util.Stack;
//
///*Sample Input 1 :
//[()]{}{[()()]()}
//Sample Output 1 :
//Balanced
//Explanation Of the Sample Input 1 :
//There is always an opening brace before a closing brace i.e. '{' before '}', '(' before '), '[' before ']'.
//So the 'S' is Balanced.
//Sample Input 2 :
//[[}[
//Sample Output 2 :
//Not Balanced*/
//public class ValidParenthesisChecker {
//
//    public static void main(String[] args) {
//
//        String s = "[()]{}{[()()]()}";  // You can change input
//
//        if (isValid(s)) {
//            System.out.println("Balanced");
//        } else {
//            System.out.println("Not Balanced");
//        }
//    }
//
//    public static boolean isValid(String s) {
//
//        int length = s.length();
//        if (length == 0)
//            return true;
//
//        Stack<Character> st = new Stack<>();
//
//        for (int i = 0; i < length; i++) {
//            char ch = s.charAt(i);
//
//            // Opening bracket → push
//            if (ch == '(' || ch == '[' || ch == '{') {
//                st.push(ch);
//            }
//
//            // Closing with matching top → pop
//            else if (!st.isEmpty() && ch == ')' && st.peek() == '(') {
//                st.pop();
//            }
//            else if (!st.isEmpty() && ch == ']' && st.peek() == '[') {
//                st.pop();
//            }
//            else if (!st.isEmpty() && ch == '}' && st.peek() == '{') {
//                st.pop();
//            }
//
//            // Otherwise invalid
//            else {
//                return false;
//            }
//        }
//
//        // Final stack empty ⇒ Balanced
//        return st.isEmpty();
//    }
//}