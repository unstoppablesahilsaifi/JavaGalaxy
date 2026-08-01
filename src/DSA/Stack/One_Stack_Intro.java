package DSA.Stack;

/*
===============================================================================
                           STACK - COMPLETE NOTES
===============================================================================

1. WHAT IS STACK?
-------------------------------------------------------------------------------
Definition:
A Stack is a linear data structure that follows the LIFO
(Last In First Out) principle.

Simple Language:
Jo element sabse last me andar jayega,
wahi sabse pehle bahar niklega.


Real Life Example 1 : Browser Back Button
-------------------------------------------------------------------------------

Google
   ↓
YouTube
   ↓
Instagram
   ↓
Facebook

Back dabaya
↓

Facebook remove

Fir Back
↓

Instagram remove

Fir
↓

YouTube

Exactly Stack.


Real Life Example 2 : Undo (Ctrl + Z)
-------------------------------------------------------------------------------

Typing
   ↓
A
   ↓
B
   ↓
C
   ↓
D

Undo
↓

D remove

Undo
↓

C remove

Undo
↓

B remove

Again Stack.


===============================================================================
2. WHY DO WE NEED STACK?
===============================================================================

Question:

Array bhi data store karta hai.

Linked List bhi data store karti hai.

To Stack ki zarurat hi kya hai?


Answer:

Stack storage ke liye nahi,
restricted access dene ke liye banaya gaya hai.


Array me

10   20   30   40   50

Tum kisi bhi element ko access kar sakte ho.

arr[2]

arr[4]

arr[0]


Lekin Stack me nahi.

Sirf

Top

accessible hota hai.


Example

40   ← Top
30
20
10

Tum

20

directly nahi nikal sakte.

Pehle

40

niklega.

Fir

30

Fir

20

Ye restriction hi Stack ko useful banati hai.


===============================================================================
3. WHERE IS STACK USED?
===============================================================================

Almost har jagah.

• Browser History
• Undo/Redo
• Function Calls
• Recursion
• DFS
• Parenthesis Matching
• Expression Evaluation
• Compiler
• XML Parsing
• HTML Parsing

Agar Stack na hota to Recursion bhi nahi chalti.


===============================================================================
4. INTERVIEW QUESTION
===============================================================================

Q. Why is Stack called a restricted data structure?

Answer:

Because insertion and deletion are allowed only at one end
(the Top).


===============================================================================
5. ADVANTAGES
===============================================================================

✅ Easy implementation

✅ O(1) insertion

✅ O(1) deletion

✅ Less memory movement


===============================================================================
6. DISADVANTAGES
===============================================================================

❌ Random access nahi

❌ Middle element access nahi

❌ Search efficient nahi


===============================================================================
7. STACK OPERATIONS
===============================================================================


----------------------------------
Operation 1 : Push
----------------------------------

Definition

Push ka matlab:

Stack ke top par naya element insert karna.


Suppose stack khali hai.

Top = -1

Empty


Push(10)

10
↑
Top


Push(20)

20 ← Top
10


Push(30)

30 ← Top
20
10


Dhyan do:

Har naya element sabse upar aata hai.



----------------------------------
Operation 2 : Pop
----------------------------------

Definition

Top element ko remove karna.


Suppose

40 ← Top
30
20
10


Pop()

Remove

40


Stack

30 ← Top
20
10


Ek aur Pop()

20

Wait...

Galat 😄

Pehle Top tha

30

To remove hoga

30


Remaining

20 ← Top
10



Empty Stack

Suppose

Empty

Aur Pop kar diya.

Kya hoga?

Isko kehte hain

Stack Underflow

Interview me bahut important.



----------------------------------
Operation 3 : Peek
----------------------------------

Definition

Top element dekhna.

Remove nahi karna.


Suppose

90
80
70


Peek()

Answer

90


Stack same rahega.

90
80
70


Difference

Pop
→ Remove

Peek
→ Only See



----------------------------------
Operation 4 : isEmpty()
----------------------------------

Question

Stack khali hai ya nahi?

Return

true

or

false



===============================================================================
8. OVERFLOW vs UNDERFLOW
===============================================================================

Overflow

Already Full
      ↓
    Push


Underflow

Already Empty
       ↓
      Pop

Interview ka favourite.


===============================================================================
9. SUMMARY TABLE
===============================================================================

+-----------+-----------------------+---------+
| Operation | Purpose               | Time    |
+-----------+-----------------------+---------+
| Push      | Insert at Top         | O(1)    |
| Pop       | Remove Top            | O(1)    |
| Peek      | View Top              | O(1)    |
| isEmpty   | Check Empty           | O(1)    |
| isFull    | Check Full (Array)    | O(1)    |
| Size      | Count Elements        | O(1)    |
+-----------+-----------------------+---------+

===============================================================================

*/
public class One_Stack_Intro {

}