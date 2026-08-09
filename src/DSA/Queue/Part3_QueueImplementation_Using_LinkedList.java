package DSA.Queue;

/*
===============================================================================
                         QUEUE IN JAVA
===============================================================================

Ab hum theory se actual Java implementation par aate hain.

Pichhle lectures me humne Queue ka behavior samjha:

FIFO
↓
First In First Out

Insertion → Rear
Deletion  → Front

Aaj hum Java me Queue create aur use karna seekhenge.


===============================================================================
1. JAVA ME QUEUE KYA HAI?
===============================================================================

Java me Queue ek interface hai.

Isliye hum directly ye nahi likh sakte:

Queue queue = new Queue<>();

❌ Ye compile nahi hoga.


Hume Queue ko implement karne wali class use karni hogi.


Common implementations:

Queue
│
├── LinkedList
├── ArrayDeque
└── PriorityQueue


Abhi hum LinkedList ke through Queue samjhenge.


===============================================================================
2. QUEUE CREATE KAISE KAREIN?
===============================================================================

Import:

import java.util.Queue;
import java.util.LinkedList;


Create:

Queue queue = new LinkedList<>();


Breakdown:

Queue
↑
Interface + Data Type


queue
↑
Reference variable


new LinkedList<>()
↑
Actual object


===============================================================================
3. EMPTY QUEUE
===============================================================================

Initially:

Queue

Front
 ↓
[ ]

Rear


Java me:

Queue queue = new LinkedList<>();


Queue empty hai.


Check:

System.out.println(queue.isEmpty());


Output:

true


===============================================================================
4. add() — ENQUEUE
===============================================================================

Queue me element insert karna ho to:

queue.add(10);


Then:

queue.add(20);
queue.add(30);


Queue:

Front                  Rear
 ↓                       ↓
[10] [20] [30]


Print:

System.out.println(queue);


Output:

[10, 20, 30]


===============================================================================
5. offer() — ANOTHER WAY TO ENQUEUE
===============================================================================

Queue me insertion ke liye:

queue.offer(40);


Result:

[10, 20, 30, 40]


To:

add()

aur

offer()

dono insertion ke liye use hote hain.


Lekin ek important difference hai.


===============================================================================
6. add() vs offer() ⭐
===============================================================================

Ye interview question hai.


+---------+--------------------+
| Method  | Failure par        |
+---------+--------------------+
| add()   | Exception throw    |
| offer() | false return       |
+---------+--------------------+


Simple language:


add()
 ↓
Insert nahi hua
 ↓
Exception


while:


offer()
 ↓
Insert nahi hua
 ↓
false


Normal LinkedList Queue me capacity issue practically nahi aata
jab tak memory available ho, isliye difference usually visible nahi hota.

Lekin bounded queues me ye difference important hai.


===============================================================================
7. remove() — DEQUEUE
===============================================================================

Queue:

Front
 ↓
[10] [20] [30]


Run:

queue.remove();


10 remove hoga.


Remaining:

[20, 30]


Return value bhi milegi:

int value = queue.remove();

System.out.println(value);


Output:

10


===============================================================================
8. poll() — ANOTHER WAY TO DEQUEUE
===============================================================================

queue.poll();


Ye bhi Front se element remove karta hai.


[10] [20] [30]

poll()

↓

10 removed

[20] [30]


===============================================================================
9. remove() vs poll() ⭐⭐⭐
===============================================================================

Very important.


Empty Queue:

Queue queue = new LinkedList<>();


remove()

queue.remove();


Throws:

NoSuchElementException


poll()

queue.poll();


Returns:

null


So:


remove()
→ Empty par Exception


poll()
→ Empty par null


Interview me ye difference zarur yaad rakhna.


===============================================================================
10. peek() — FRONT DEKHNA
===============================================================================

Queue:

Front
 ↓
[10] [20] [30]


queue.peek();


Returns:

10


Lekin remove nahi karta.


Queue remains:

[10] [20] [30]


===============================================================================
11. element() — ANOTHER WAY TO SEE FRONT
===============================================================================

queue.element();


Ye bhi Front return karta hai.


So:

peek()

element()


dono front element dete hain.


Difference empty Queue par hai.


===============================================================================
12. peek() vs element() ⭐⭐⭐
===============================================================================

Empty Queue:


peek()

queue.peek();


returns:

null


element()

queue.element();


throws:

NoSuchElementException


Remember:


peek()
→ Empty = null


element()
→ Empty = Exception


===============================================================================
13. COMPLETE OPERATION TABLE
===============================================================================

Ye table screenshot le lena. 📌


+-----------+----------------+---------------------+
| Operation | Purpose        | Empty Queue par     |
+-----------+----------------+---------------------+
| add()     | Insert         | Exception           |
| offer()   | Insert         | false               |
| remove()  | Remove Front   | Exception           |
| poll()    | Remove Front   | null                |
| element() | View Front     | Exception           |
| peek()    | View Front     | null                |
+-----------+----------------+---------------------+


===============================================================================
EASY TRICK 🧠
===============================================================================

add()       ↔ offer()

remove()    ↔ poll()

element()   ↔ peek()


Pairs yaad rakho.


===============================================================================
COMPLETE CODE
===============================================================================
*/

import java.util.Queue;
import java.util.LinkedList;

public class Part3_QueueImplementation_Using_LinkedList {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        // Enqueue
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Queue: " + queue);

        // Peek
        System.out.println("Front: " + queue.peek());

        // Dequeue
        System.out.println("Removed: " + queue.poll());

        System.out.println("Queue after poll: " + queue);

        // Size
        System.out.println("Size: " + queue.size());

        // Empty check
        System.out.println("Is Empty: " + queue.isEmpty());
    }
}