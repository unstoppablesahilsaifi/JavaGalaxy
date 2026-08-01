package DSA.Stack;
class Stack {

    int[] arr;
    int top;
    int size;

    //Constructor object create hote hi automatically call hota hai.
    Stack(int size){

        this.size=size;
        arr=new int[size];
        top=-1;

    }
/*Stack empty kab hota hai?

top == -1*/
    public boolean isEmpty(){

        return top==-1;

    }
/*Stack full kab hota hai?
* top == size - 1*/
    public boolean isFull(){

        return top==size-1;

    }

    public void push(int value){

        if(isFull()){

            System.out.println("Stack Overflow");

            return;

        }

        arr[++top]=value;

    }

    public int pop(){

        if(isEmpty()){

            System.out.println("Stack Underflow");

            return -1;

        }

        return arr[top--];

    }

    public int peek(){

        if(isEmpty()){

            System.out.println("Stack Underflow");

            return -1;

        }

        return arr[top];

    }

    public void display(){

        for(int i=top;i>=0;i--){

            System.out.println(arr[i]);

        }

    }

}

public class Part3_Stack_Implementation_Using_Array {

    public static void main(String[] args){

        Stack s=new Stack(5);

        s.push(10);
        s.push(20);
        s.push(30);

        s.display();

        System.out.println();

        System.out.println("Peek : "+s.peek());

        System.out.println("Pop : "+s.pop());

        s.display();

    }

}

/*Interview Questions
Q1. arr[++top] = value aur arr[top++] = value me difference?

Bahut important.

Suppose

top = -1
arr[++top] = 10

Pehle top increment hoga.

top = 0

Fir

arr[0] = 10

✅ Correct.

arr[top++] = 10

Pehle

arr[-1] = 10

Fir

top = 0

❌ Wrong. ArrayIndexOutOfBoundsException aa jayegi.

Rule yaad rakho: Push me pre-increment (++top) use karte hain.

Q2. return arr[top--]; kaise kaam karta hai?

Ye post-decrement hai.

Steps:

return arr[top];
top--;

Agar

top = 2
arr[2] = 30

To pehle 30 return hoga, phir top = 1.*/

