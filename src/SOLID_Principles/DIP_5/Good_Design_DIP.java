package SOLID_Principles.DIP_5;

// 👉 Abstraction
interface InputDevice {
    void connect();
}

// Low-level implementations
class KeyboardDIP implements InputDevice {
    @Override
    public void connect() {
        System.out.println("Keyboard connected");
    }
}

class Mouse implements InputDevice {
    @Override
    public void connect() {
        System.out.println("Mouse connected");
    }
}

// High-level class depends on abstraction
class ComputerDIP {
    private InputDevice device;

    // Inject dependency via constructor
    public ComputerDIP(InputDevice device) {
        this.device = device;
    }

    void start() {
        device.connect();
        System.out.println("Computer started...");
    }
}

public class Good_Design_DIP {

    public static void main(String[] args) {

        // Computer works with any input device now
        ComputerDIP pc1 = new ComputerDIP(new KeyboardDIP());
        pc1.start();
        // Output: Keyboard connected + Computer started...

        ComputerDIP pc2 = new ComputerDIP(new Mouse());
        pc2.start();
        // Output: Mouse connected + Computer started...
    }
}

//With DIP: High-level Computer depends only on abstraction (InputDevice). Actual device (Keyboard / Mouse) inject hota hai → ✅ Flexible, ✅ Maintainable.