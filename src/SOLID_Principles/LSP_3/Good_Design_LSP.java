package SOLID_Principles.LSP_3;
//Ab hum behaviour separate karenge.
class Vehicle {
    void move() {
        System.out.println("I can move on road");
    }
}

// Only Engine-based vehicles
class EngineVehicle extends Vehicle {
    void startEngine() {
        System.out.println("Engine started...");
    }
}

// Car is an engine-based vehicle
class Car extends EngineVehicle {
    @Override
    void startEngine() {
        System.out.println("Car engine started...");
    }
}

// Bicycle is NOT engine-based, so it won't override startEngine
class Bicycle extends Vehicle {
    @Override
    void move() {
        System.out.println("Bicycle pedals forward...");
    }
}


public class Good_Design_LSP {
    public static void main(String[] args) {
        Vehicle cycle = new Bicycle();
        cycle.move();
        // ✅ Output: Bicycle pedals forward...

        EngineVehicle car = new Car();
        car.startEngine();
        // ✅ Output: Car engine started...
    }
}
