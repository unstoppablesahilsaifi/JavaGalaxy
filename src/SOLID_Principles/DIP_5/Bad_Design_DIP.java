package SOLID_Principles.DIP_5;
//Dependency Inversion Principle (DIP)
/*❓ Why (Kyun zaroori hai?)
👉 Normally hum high-level classes (business logic) ko direct low-level classes (implementation) pe depend kara dete hain.
👉 Problem: Agar low-level class badal jaye, to high-level class bhi toot jaati hai.

DIP kehta hai:

High-level modules should not depend on low-level modules.
Dono ko abstractions (interfaces) pe depend karna chahiye.*/

// Low-level class
class Keyboard {
    void connect() {
        System.out.println("Keyboard connected");
    }
}

// High-level class (depends directly on Keyboard)
class Computer {
    private Keyboard keyboard;

    public Computer() {
        this.keyboard = new Keyboard(); // ❌ Tight coupling
    }

    void start() {
        keyboard.connect();
        System.out.println("Computer started...");
    }
}
public class Bad_Design_DIP {
    public static void main(String[] args) {
        Computer pc = new Computer();
        pc.start();
    }
}

//👉 Problem: Agar kal ko Keyboard ki jagah WirelessKeyboard ya Mouse use karna ho → Computer class modify karni pdegi.
// 🔴 Yaani high-level (Computer) dependent hai low-level (Keyboard) pe.