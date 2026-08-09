package DSA.Queue;

/*
===============================================================================
                           QUEUE - COMPLETE SOP
===============================================================================

TOPIC:
Queue Data Structure

IMPLEMENTATION:
Array Based Queue

PRINCIPLE:
FIFO → First In, First Out


===============================================================================
1. WHAT IS QUEUE?
===============================================================================

A Queue is a Linear Data Structure that follows the FIFO
(First In First Out) principle.

Simple language me:

Jo sabse pehle aayega,
wahi sabse pehle bahar jayega.


Example:

Front                         Rear
  ↓                            ↓
[10] [20] [30] [40]

Insertion → Rear
Deletion  → Front


===============================================================================
2. QUEUE POINTERS
===============================================================================

Queue me do important pointers hote hain:

1. Front
2. Rear


Front:
Jahan se deletion hogi.


Rear:
Jahan insertion hogi.


Example:

Front                         Rear
  ↓                            ↓
[10] [20] [30] [40]


Here:

front = 0
rear  = 3


===============================================================================
3. INITIAL STATE
===============================================================================

Initially Queue empty hoti hai.

front = -1
rear  = -1


Example:

Index
  0     1     2     3     4
+-----+-----+-----+-----+-----+
|     |     |     |     |     |
+-----+-----+-----+-----+-----+


===============================================================================
4. QUEUE OPERATIONS
===============================================================================

Queue ke main operations:

1. enqueue()  → Insert element
2. dequeue()  → Remove element
3. peek()     → View Front element
4. isEmpty()  → Check Queue empty
5. isFull()   → Check Queue full
6. size()     → Count elements
7. display()  → Display elements


===============================================================================
5. ENQUEUE() - INSERTION
===============================================================================

Definition:

enqueue() ka matlab:

Queue ke Rear par ek naya element add karna.


Example:

Current Queue:

Front             Rear
  ↓                 ↓
[10] [20] [30]


Operation:

enqueue(40)


Result:

Front                    Rear
  ↓                       ↓
[10] [20] [30] [40]


40 hamesha Rear par aayega.


Important:

❌ Front par insert nahi karte
❌ Middle me insert nahi karte
✅ Rear par insert karte hain


Logic:

1. Check Queue full hai ya nahi.
2. Agar full hai → Overflow.
3. Agar Queue empty hai:
       front = 0
4. rear ko increase karo.
5. queue[rear] par element insert karo.


===============================================================================
6. DEQUEUE() - DELETION
===============================================================================

Definition:

dequeue() ka matlab:

Queue ke Front se element remove karna.


Current Queue:

Front                    Rear
  ↓                       ↓
[10] [20] [30] [40]


dequeue()


10 → removed


Remaining:

Front             Rear
  ↓                 ↓
[20] [30] [40]


Important:

✅ Front se deletion hoti hai.
❌ Rear se deletion nahi hoti.


Logic:

1. Check Queue empty hai ya nahi.
2. Agar empty hai → Underflow.
3. Front element ko store karo.
4. Agar sirf ek element hai:
       front = -1
       rear = -1
5. Otherwise:
       front++


===============================================================================
7. PEEK() - FRONT ELEMENT DEKHNA
===============================================================================

Definition:

peek() ka kaam:

Front element ko dekhna,
remove nahi karna.


Queue:

Front
 ↓
[20] [30] [40]


peek()


Output:

20


Queue same rahegi:

[20] [30] [40]


Difference:

Stack:

peek() → Top


Queue:

peek() → Front


Logic:

1. Check Queue empty hai ya nahi.
2. Agar empty hai → No element.
3. Otherwise:
       queue[front] return karo.


===============================================================================
8. isEmpty()
===============================================================================

Definition:

Check karta hai:

Queue empty hai ya nahi.


Empty Queue:

front = -1
rear  = -1


Result:

true


Agar elements hain:

[10] [20]


Result:

false


Logic:

return front == -1;


===============================================================================
9. isFull()
===============================================================================

Definition:

Check karta hai:

Queue ki fixed capacity full hai ya nahi.


Suppose capacity = 5


Index:

  0    1    2    3    4
[10] [20] [30] [40] [50]


Queue full hai.


Agar:

enqueue(60)


karne ki koshish karte hain:

Queue → Overflow


Logic:

return rear == queue.length - 1;


IMPORTANT:

Ye simple Linear Queue implementation hai.

Is implementation me agar Front se elements remove ho gaye hain,
to unki empty space reuse nahi hoti.

Example:

Initially:

[10] [20] [30] [40] [50]


dequeue()

[  ] [20] [30] [40] [50]

Ab front = 1

Agar aur dequeue():

[  ] [  ] [30] [40] [50]

Ab:

front = 2
rear  = 4


Array me starting ke 2 positions empty hain.

Lekin:

rear already last index par hai.

Isliye:

enqueue(60)

Overflow dega.

Isi problem ko Circular Queue solve karti hai.


===============================================================================
10. SIZE()
===============================================================================

Definition:

Queue me currently kitne elements hain.


Example:

[10] [20] [30]


Size:

3


Agar:

enqueue(40)


Then:

[10] [20] [30] [40]


Size:

4


Agar:

dequeue()


Then:

[20] [30] [40]


Size:

3


Logic:

Agar Queue empty hai:

size = 0


Otherwise:

size = rear - front + 1


===============================================================================
11. DISPLAY()
===============================================================================

Definition:

Queue ke elements ko:

Front → Rear

order me display karna.


Example:

Front                    Rear
  ↓                       ↓
[10] [20] [30] [40]


Output:

10 20 30 40


Logic:

front se start karo.

rear tak loop chalao.

Har element print karo.


===============================================================================
12. COMPLETE DRY RUN
===============================================================================


Initial State:

Queue = Empty

front = -1
rear  = -1


-------------------------------------------------------------------------------
Operation 1
-------------------------------------------------------------------------------

enqueue(10)


Queue:

Front
 ↓
[10]
 ↑
Rear


front = 0
rear  = 0


-------------------------------------------------------------------------------
Operation 2
-------------------------------------------------------------------------------

enqueue(20)


Queue:

Front       Rear
 ↓           ↓
[10] [20]


front = 0
rear  = 1


-------------------------------------------------------------------------------
Operation 3
-------------------------------------------------------------------------------

enqueue(30)


Queue:

Front              Rear
 ↓                   ↓
[10] [20] [30]


front = 0
rear  = 2


-------------------------------------------------------------------------------
Operation 4
-------------------------------------------------------------------------------

dequeue()


10 remove hoga.


Queue:

Front          Rear
 ↓               ↓
[20] [30]


front = 1
rear  = 2


-------------------------------------------------------------------------------
Operation 5
-------------------------------------------------------------------------------

enqueue(40)


Queue:

Front                 Rear
 ↓                      ↓
[20] [30] [40]


front = 1
rear  = 3


-------------------------------------------------------------------------------
Operation 6
-------------------------------------------------------------------------------

peek()


Output:

20


Queue same rahegi:

[20] [30] [40]


-------------------------------------------------------------------------------
Operation 7
-------------------------------------------------------------------------------

dequeue()


20 remove hoga.


Final Queue:

Front          Rear
 ↓               ↓
[30] [40]


front = 2
rear  = 3


===============================================================================
13. FRONT AUR REAR MOVEMENT
===============================================================================

Suppose:

Index

  0     1     2     3     4
[10]  [20]  [30]  [  ]  [  ]
  ↑            ↑
Front         Rear


front = 0
rear  = 2


enqueue(40)


  0     1     2     3     4
[10]  [20]  [30]  [40]  [  ]
  ↑                  ↑
Front              Rear


front = 0
rear  = 3


dequeue()


10 logically remove.


  0     1     2     3     4
[  ]  [20]  [30]  [40]  [  ]
        ↑                  ↑
      Front              Rear


front = 1
rear  = 3


Notice:

Front right ki taraf move hua.

Rear bhi right ki taraf move hota hai.


===============================================================================
14. OVERFLOW vs UNDERFLOW
===============================================================================

OVERFLOW:

Queue already full
       ↓
    enqueue()


UNDERFLOW:

Queue already empty
       ↓
    dequeue()


Interview me important.


===============================================================================
15. TIME COMPLEXITY
===============================================================================

+-----------+----------------------+----------+
| Operation | Purpose              | Time     |
+-----------+----------------------+----------+
| enqueue   | Insert at Rear       | O(1)     |
| dequeue   | Remove from Front    | O(1)     |
| peek      | View Front           | O(1)     |
| isEmpty   | Check Empty          | O(1)     |
| isFull    | Check Full           | O(1)     |
| size      | Count Elements       | O(1)     |
| display   | Display Elements     | O(n)     |
+-----------+----------------------+----------+


===============================================================================
16. SPACE COMPLEXITY
===============================================================================

Array Queue ki capacity agar n hai:

Space Complexity = O(n)


===============================================================================
17. COMPLETE IMPLEMENTATION
===============================================================================
*/

public class Part2_Queue_Operations {

    // =========================================================================
    // Queue Storage
    // =========================================================================

    private int[] queue;

    // Points to the Front element
    private int front;

    // Points to the Rear element
    private int rear;


    // =========================================================================
    // Constructor
    // =========================================================================

    public Part2_Queue_Operations(int capacity) {

        queue = new int[capacity];

        // Initially Queue is empty
        front = -1;
        rear = -1;
    }


    // =========================================================================
    // 1. ENQUEUE()
    // =========================================================================

    /*
     * Purpose:
     * Insert a new element at Rear.
     *
     * Time Complexity:
     * O(1)
     */

    public void enqueue(int value) {

        // Check if Queue is full
        if (isFull()) {

            System.out.println("Queue Overflow");
            return;
        }


        // If Queue is empty,
        // initialize Front
        if (isEmpty()) {

            front = 0;
        }


        // Move Rear
        rear++;


        // Insert element at Rear
        queue[rear] = value;


        System.out.println(value + " inserted into Queue.");
    }


    // =========================================================================
    // 2. DEQUEUE()
    // =========================================================================

    /*
     * Purpose:
     * Remove element from Front.
     *
     * Time Complexity:
     * O(1)
     */

    public int dequeue() {

        // Check if Queue is empty
        if (isEmpty()) {

            System.out.println("Queue Underflow");
            return -1;
        }


        // Store Front element
        int removedElement = queue[front];


        /*
         * If only one element is present,
         * after removing it Queue becomes empty.
         */
        if (front == rear) {

            front = -1;
            rear = -1;

        } else {

            // Move Front
            front++;
        }


        System.out.println(
                removedElement + " removed from Queue."
        );


        return removedElement;
    }


    // =========================================================================
    // 3. PEEK()
    // =========================================================================

    /*
     * Purpose:
     * View Front element without removing it.
     *
     * Time Complexity:
     * O(1)
     */

    public int peek() {

        // Check if Queue is empty
        if (isEmpty()) {

            System.out.println("Queue is Empty.");
            return -1;
        }


        // Return Front element
        return queue[front];
    }


    // =========================================================================
    // 4. isEmpty()
    // =========================================================================

    /*
     * Purpose:
     * Check whether Queue is empty.
     *
     * Time Complexity:
     * O(1)
     */

    public boolean isEmpty() {

        return front == -1;
    }


    // =========================================================================
    // 5. isFull()
    // =========================================================================

    /*
     * Purpose:
     * Check whether Queue is full.
     *
     * Time Complexity:
     * O(1)
     */

    public boolean isFull() {

        return rear == queue.length - 1;
    }


    // =========================================================================
    // 6. SIZE()
    // =========================================================================

    /*
     * Purpose:
     * Return number of elements currently present in Queue.
     *
     * Time Complexity:
     * O(1)
     */

    public int size() {

        // Queue is empty
        if (isEmpty()) {

            return 0;
        }


        return rear - front + 1;
    }


    // =========================================================================
    // 7. DISPLAY()
    // =========================================================================

    /*
     * Purpose:
     * Display Queue elements from Front to Rear.
     *
     * Time Complexity:
     * O(n)
     */

    public void display() {

        // Check if Queue is empty
        if (isEmpty()) {

            System.out.println("Queue is Empty.");
            return;
        }


        System.out.print("Queue: ");


        // Traverse from Front to Rear
        for (int i = front; i <= rear; i++) {

            System.out.print(queue[i] + " ");
        }


        System.out.println();
    }


    // =========================================================================
    // MAIN METHOD - COMPLETE TEST
    // =========================================================================

    public static void main(String[] args) {


        // =====================================================================
        // Create Queue
        // =====================================================================

        Part2_Queue_Operations queue =
                new Part2_Queue_Operations(5);


        // =====================================================================
        // Initial State
        // =====================================================================

        System.out.println("Is Queue Empty? "
                + queue.isEmpty());


        // =====================================================================
        // ENQUEUE OPERATIONS
        // =====================================================================

        System.out.println("\n--- ENQUEUE ---");

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();


        // =====================================================================
        // SIZE
        // =====================================================================

        System.out.println("\n--- SIZE ---");

        System.out.println(
                "Queue Size: " + queue.size()
        );


        // =====================================================================
        // PEEK
        // =====================================================================

        System.out.println("\n--- PEEK ---");

        System.out.println(
                "Front Element: " + queue.peek()
        );


        // =====================================================================
        // DEQUEUE
        // =====================================================================

        System.out.println("\n--- DEQUEUE ---");

        queue.dequeue();

        queue.display();


        // =====================================================================
        // ENQUEUE AFTER DEQUEUE
        // =====================================================================

        System.out.println("\n--- ENQUEUE AFTER DEQUEUE ---");

        queue.enqueue(40);

        queue.display();


        // =====================================================================
        // PEEK AGAIN
        // =====================================================================

        System.out.println("\n--- PEEK ---");

        System.out.println(
                "Front Element: " + queue.peek()
        );


        // =====================================================================
        // SIZE AGAIN
        // =====================================================================

        System.out.println("\n--- SIZE ---");

        System.out.println(
                "Queue Size: " + queue.size()
        );


        // =====================================================================
        // DEQUEUE
        // =====================================================================

        System.out.println("\n--- DEQUEUE ---");

        queue.dequeue();

        queue.display();


        // =====================================================================
        // CHECK EMPTY
        // =====================================================================

        System.out.println("\n--- isEmpty() ---");

        System.out.println(
                "Is Queue Empty? " + queue.isEmpty()
        );


        // =====================================================================
        // CHECK FULL
        // =====================================================================

        System.out.println("\n--- isFull() ---");

        System.out.println(
                "Is Queue Full? " + queue.isFull()
        );


        // =====================================================================
        // FINAL STATE
        // =====================================================================

        System.out.println("\n--- FINAL QUEUE ---");

        queue.display();

        System.out.println(
                "Front Element: " + queue.peek()
        );

        System.out.println(
                "Queue Size: " + queue.size()
        );
    }
}


/*
===============================================================================
                    QUEUE USING SIMPLE ARRAY - PROBLEM
===============================================================================


# ⚠️ Queue Using Simple Array ki Problem

Ab ek important situation dekho.


Capacity = 5


Initially:

[10] [20] [30] [40] [50]
 ↑                        ↑
Front                    Rear


Ab 2 dequeue:

dequeue() → 10
dequeue() → 20


Array physically:

[  ] [  ] [30] [40] [50]
          ↑              ↑
        Front           Rear


Ab dekho:

Index 0 → empty
Index 1 → empty


Matlab space available hai.

Lekin `rear` already last index `4` par pahunch chuka hai.


Ab:

enqueue(60)


Simple linear implementation bolega:

Queue Full


😕 But actually:

[  ] [  ] [30] [40] [50]

me 2 spaces khali hain!


===============================================================================
11. YE PROBLEM IMPORTANT KYU HAI?
===============================================================================

Isi ko kehte hain:

## Wasted Space


Simple Array Queue me Front ke peeche jo space free ho gayi,
wo reuse nahi ho rahi.


Diagram:

Index

 0    1    2    3    4
[ ]  [ ]  [30] [40] [50]
 ↑    ↑              ↑
Free Free           Rear


Rear aage nahi ja sakta.


===============================================================================
12. SOLUTION → CIRCULAR QUEUE 🔄
===============================================================================

Circular Queue me hum array ko circular treat karte hain.


Matlab:

0 → 1 → 2 → 3 → 4
↑                 ↓
└─────────────────┘


Last index ke baad:

4 → 0


So agar:

rear = 4


aur index `0` free hai, to next element:

rear = 0


par insert ho sakta hai.


Isi concept ko hum Circular Queue me detail me padhenge.


===============================================================================
13. QUEUE OPERATIONS SUMMARY
===============================================================================

+-------------+-------------+----------------+
| Operation   | Meaning     | Where?         |
+-------------+-------------+----------------+
| enqueue()   | Insert      | Rear           |
| dequeue()   | Remove      | Front          |
| peek()      | View        | Front          |
| isEmpty()   | Check empty | —              |
| isFull()    | Check full  | —              |
| size()      | Count       | —              |
| display()   | Print       | Front → Rear   |
+-------------+-------------+----------------+


===============================================================================
14. QUEUE VS STACK — OPERATIONS
===============================================================================

+----------------+------------------+
| Stack          | Queue            |
+----------------+------------------+
| push()         | enqueue()        |
| pop()          | dequeue()        |
| peek() → Top   | peek() → Front   |
| isEmpty()      | isEmpty()        |
| isFull()       | isFull()         |
| LIFO           | FIFO             |
+----------------+------------------+


### Ek line me:


Stack:

Insert → Top
Delete → Top


Queue:

Insert → Rear
Delete → Front


===============================================================================
15. TIME COMPLEXITY
===============================================================================

A properly implemented Queue me:


+-------------+--------------+
| Operation   | Complexity   |
+-------------+--------------+
| Enqueue     | O(1)         |
| Dequeue     | O(1)         |
| Peek        | O(1)         |
| isEmpty()   | O(1)         |
| isFull()    | O(1)         |
+-------------+--------------+


⚠️ Lekin ek important catch:


Agar dequeue ke baad saare elements shift kar doge:


[10][20][30][40]
 ↓
remove 10

[20][30][40]


aur har baar elements shift karoge,
to `dequeue()` O(n) ho jayega.


Hum aisa nahi karenge.


Isi problem ko avoid karne ke liye `front` pointer use karte hain,
aur later Circular Queue aur `ArrayDeque` samjhenge.


===============================================================================
🧠 INTERVIEWER'S MIND
===============================================================================


Q1. Queue me insertion kaha hoti hai?

Answer:

Rear


Q2. Deletion kaha hoti hai?

Answer:

Front


Q3. Queue FIFO kyu follow karti hai?

Answer:

Because the element that enters first is processed first.


Q4. Simple array Queue ki major problem?

Answer:

Wasted space / false overflow after dequeue operations.


Q5. Is problem ka solution?

Answer:

Circular Queue.

*/