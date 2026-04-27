package Design_Patterns.Structural_Patterns.Adapter_Pattern;
/*Adapter pattern ka kaam “incompatible interfaces ko compatible banana” hota hai.
Matlab 2 cheeze jo direct connect nahi ho sakti, unke beech bridge banata hai.


🔹 Adapter Pattern kya hai?
👉 Jab ek class ka interface dusri class ke saath match nahi karta
👉 Tab hum Adapter use karke unhe connect karte hain
💡 One-line:
“Convert one interface into another expected interface”


🧠 Real-life example
Mobile charger ⚡
Phone → Type-C
Charger → USB
👉 Adapter lagaya → kaam ho gaya*/


/*❌ WITHOUT Adapter (Problem)

Maan le:

Tumhare paas OldPrinter hai
Tumhara system sirf ModernPrinter interface accept karta hai*/

// Modern system expects this
interface ModernPrinter {
    void print();
}

// Old printer (incompatible)
class OldPrinter {
    void printOld() {
        System.out.println("Printing using old printer");
    }
}

// Client
public class Bad_Design_Adapter_Pattern {
    public static void main(String[] args) {
        OldPrinter oldPrinter = new OldPrinter();

        // ❌ ERROR - method mismatch
        // oldPrinter.print();  // not possible
    }
}

/*❗ Problem:
OldPrinter me printOld() hai
System ko print() chahiye
👉 Direct use nahi kar sakte*/