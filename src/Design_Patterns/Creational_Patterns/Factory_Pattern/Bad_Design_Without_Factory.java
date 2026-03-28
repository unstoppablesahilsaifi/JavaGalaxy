package Design_Patterns.Creational_Patterns.Factory_Pattern;
/*👉 Factory Pattern ek Pattern hai jo object creation logic ko ek dedicated class (Factory) ke andar daal deta hai.
 * Client ko `new` karke objects banane ki zarurat nahi hoti.
 * Client sirf factory se bolta hai: “Mujhe is type ka object chahiye” → Factory return kar deti hai.
 * 🍕 **Pizza Shop** → Tum order doge: "Cheese Pizza" ya "Veg Pizza" → Shop banake ready karegi aur tumhe serve karegi. Tumhe andar ka process (ingredients, oven, time) pata nahi.
 * 🚗 **Car Showroom** → Tum bolte ho “Sedan chahiye” → Factory se Sedan ready milta hai, tumhe engine assemble karna nahi padta.


 */
interface Shape_Bad {
    void draw();
}

class Circle_Bad implements Shape_Bad {
    public void draw() {
        System.out.println("Drawing Circle...");
    }
}

class Square_Bad implements Shape_Bad {
    public void draw() {
        System.out.println("Drawing Square...");
    }
}


public class Bad_Design_Without_Factory {
    public static void main(String[] args) {
        // Client ko pata hona chahiye kaunsa class use karna hai
        Shape_Bad s1 = new Circle_Bad();
        Shape_Bad s2 = new Square_Bad();

        s1.draw();
        s2.draw();
    }

}

/*❌ Issues:
Client ko exact class names pata hone chahiye (new Circle(), new Square()).
Agar kal ko Triangle add ho gaya → client code me changes karne padenge.
Tight coupling ho gayi.*/