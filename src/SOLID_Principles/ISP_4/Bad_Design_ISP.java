package SOLID_Principles.ISP_4;
//Interface Segregation Principle (ISP)
//Clients should not be forced to depend on methods they do not use.
//Simple language:
//Ek bada interface mat banao
//Chhote specific interfaces banao
//Matlab:
//❌ Fat interface (bahut saare methods)
//✅ Multiple small interfaces

/*👉 Agar ek bada interface bana diya jisme unnecessary methods hain, to client classes ko un methods ko implement karna padta hai jinki unko zaroorat hi nahi.
👉 Ye hi violation hai → fat interfaces = problem.

ISP kehta hai:

⚡ Clients should not be forced to depend on methods they do not use.
🪶 (Chhote-chhote specific interfaces banao, unnecessary burden mat do.)*/

//Suppose ek Worker interface bana diya.
interface Worker {

    void work();
    void eat();
}
//Human dono kaam karta hai.
class HumanWorker implements Worker {

    public void work() {
        System.out.println("Human working");
    }

    public void eat() {
        System.out.println("Human eating");
    }
}

//RobotWorker
//Robot kaam karta hai but eat nahi karta.
//Phir bhi interface force karega implement karne ko.

class RobotWorker implements Worker {

    public void work() {
        System.out.println("Robot working");
    }

    public void eat() {
        // Robot does not eat
        throw new UnsupportedOperationException("Robot cannot eat");
    }
}
public class Bad_Design_ISP {
    public static void main(String[] args) {

        Worker human = new HumanWorker();
        human.work();
        human.eat();

        Worker robot = new RobotWorker();
        robot.work();
        robot.eat();  // ❌ Problem
    }
}
/*Problem

RobotWorker ko useless method implement karna pada.

eat() robot ke kaam ka nahi hai

Ye Interface Segregation violation hai.*/