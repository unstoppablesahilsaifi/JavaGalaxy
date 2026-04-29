package Design_Patterns.Structural_Patterns.Adapter_Pattern;
// Step 1: Target interface (expected by client)
interface ModernPrinter_Good {
    void print();
}

// Step 2: Existing class (incompatible)
class OldPrinter_Good {
    void printOld() {
        System.out.println("Printing using old printer");
    }
}

// Step 3: Adapter
class PrinterAdapter implements ModernPrinter_Good {

    private OldPrinter_Good oldPrinter;

    public PrinterAdapter(OldPrinter_Good oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    @Override
    public void print() {
        // convert call
        oldPrinter.printOld();
    }
}

// Step 4: Client
public class Good_Design_Adapter_Pattern {
    public static void main(String[] args) {

        OldPrinter_Good oldPrinter = new OldPrinter_Good();

        // Adapter use kiya
        ModernPrinter_Good printer = new PrinterAdapter(oldPrinter);

        printer.print();  // ✅ Works
    }
}

/*🎯 Samajhne ka shortcut

👉 Without Adapter
❌ System aur class baat nahi kar pa rahe

👉 With Adapter
✅ Beech me translator aa gaya

🧠 Interview Line

Adapter pattern allows incompatible interfaces to work together by acting as a bridge between them.*/