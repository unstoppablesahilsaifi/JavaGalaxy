package SOLID_Principles.LSP_3;
//Liskov Substitution Principle (LSP)
//Subclasses should be able to replace their parent class without breaking the program.
// Simple Language: Child class ko parent class ki jagah use kar sako
//aur program ka behaviour break na ho

/*Real Life Example
Socho:
Bird → parent class
Bird kar sakta hai:
fly()

Ab agar:
Penguin extends Bird
Penguin fly nahi kar sakta.
Agar Penguin ko force karo fly() implement karne ko → system break ho jayega.
Ye LSP violation hai.*/

class Bird {

    public void fly() {
        System.out.println("Bird is flying");
    }
}
class Sparrow extends Bird {

    public void fly() {
        System.out.println("Sparrow flying");
    }
}
class Penguin extends Bird {

    public void fly() {
        throw new UnsupportedOperationException("Penguin cannot fly");
    }
}

public class Bad_Design_LSP {
    public static void main(String[] args) {

        Bird bird = new Sparrow();
        bird.fly();

        Bird penguin = new Penguin();
        penguin.fly();   // ❌ Runtime error
    }
}
/*Problem
Penguin ko parent class ki jagah use kiya → system break ho gaya.

Matlab:
Child class parent ko safely replace nahi kar pa rahi
Ye LSP violation hai.*/