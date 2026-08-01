package DSA.Stack;

import java.util.Stack;

public class Two_Stack_Operations {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack : " + stack);

        System.out.println("Peek : " + stack.peek());

        System.out.println("Pop : " + stack.pop());

        System.out.println("After Pop : " + stack);

        System.out.println("Size : " + stack.size());

        System.out.println("Is Empty : " + stack.isEmpty());

        System.out.println("Search 10 : " + stack.search(10));
    }
}

/*| Method    | Complexity |
| --------- | ---------- |
| push()    | O(1)       |
| pop()     | O(1)       |
| peek()    | O(1)       |
| isEmpty() | O(1)       |
| size()    | O(1)       |
| search()  | O(n)       |

🤔 Why is search() O(n)?

Suppose Stack hai:

Top
↓
50
40
30
20
10

Agar search(10) karna hai, to Java ko 50 → 40 → 30 → 20 → 10 tak dekhna padega. Worst case me har element check karna padega.

Isliye O(n).

Q. Kya Stack me middle element access kar sakte hain?

Technically Stack class Vector ko extend karti hai, isliye methods jaise get(index) available hain.
Lekin DSA Stack ke concept ke hisaab se aisa nahi karna chahiye,
kyunki Stack ka abstraction sirf Top se access allow karta hai. Interview me yahi expected answer hota hai.
*/