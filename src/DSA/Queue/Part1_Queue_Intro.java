package DSA.Queue;

/*
===============================================================================
                              QUEUE - INTRODUCTION
===============================================================================

A Queue is a Linear Data Structure that follows the FIFO (First In First Out)
principle.

Simple language me:

Jo sabse pehle aayega, wahi sabse pehle bahar jayega.


===============================================================================
QUEUE REPRESENTATION
===============================================================================

Queue ke do important pointers hote hain.

Front

Rear


Visualization

Initially

Front = -1
Rear  = -1


Memory

Index

  0     1     2     3     4
+-----+-----+-----+-----+-----+
|     |     |     |     |     |
+-----+-----+-----+-----+-----+


===============================================================================
7. FRONT AUR REAR KYA HOTE HAIN?
===============================================================================

Suppose

10

20

30


Memory

Index

  0     1     2     3     4
+-----+-----+-----+-----+-----+
| 10  | 20  | 30  |     |     |
+-----+-----+-----+-----+-----+


Pointers


Front
  ↓

10

20

30

↑
Rear


Meaning

Front

Jahan se deletion hogi.


Rear

Jahan insertion hogi.


===============================================================================
WHY TWO POINTERS?
===============================================================================

Stack me sirf

Top

tha.


Queue me do pointers kyu?

Because


Insertion

   ↓

Rear

se hoti hai.


Deletion

   ↓

Front

se hoti hai.


Agar ek hi pointer hota to FIFO maintain nahi hota.


===============================================================================

*/

public class Part1_Queue_Intro {

}