package SOLID_Principles.ISP_4;
//Ab hum interface split karenge.

// Small and specific interfaces
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

// Human does both work and eat
class HumanWorkerISP implements Workable, Eatable {
    @Override
    public void work() {
        System.out.println("Human is working...");
    }

    @Override
    public void eat() {
        System.out.println("Human is eating...");
    }
}

// Robot only works, no need to eat
class RobotWorkerISP implements Workable {
    @Override
    public void work() {
        System.out.println("Robot is working...");
    }
}
public class Good_Design_ISP {
    public static void main(String[] args) {
        Workable human = new HumanWorkerISP();
        human.work();  // ✅ Human is working...

        Eatable eater = new HumanWorkerISP();
        eater.eat();   // ✅ Human is eating...

        Workable robot = new RobotWorkerISP();
        robot.work();  // ✅ Robot is working...
    }
}
