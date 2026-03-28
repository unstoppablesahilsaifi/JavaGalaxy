package Design_Patterns.Creational_Patterns.Factory_Pattern;
interface Shape {
    void draw();
}

// Step 2: Implementations
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle...");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing Square...");
    }
}

// Step 3: Factory Class
class ShapeFactory {
    public static Shape getShape(String shapeType) {
        if (shapeType == null) return null;
        if (shapeType.equalsIgnoreCase("CIRCLE")) return new Circle();
        if (shapeType.equalsIgnoreCase("SQUARE")) return new Square();
        return null;
    }
}

// Step 4: Client Code
public class Good_Design_With_Factory {
    public static void main(String[] args) {
        Shape s1 = ShapeFactory.getShape("CIRCLE");
        Shape s2 = ShapeFactory.getShape("SQUARE");

        s1.draw();
        s2.draw();
    }
}
//👉 Ab client ko new karne ki zarurat nahi hai. Sirf factory ko bolna hai → object mil gaya.
/*💡 Where Factory Pattern is Used
🗄️ DriverManager.getConnection() (JDBC) → alag DB ke liye alag connection object deta hai.
📝 Logging frameworks → Logger factory se alag loggers milte hain.
🌱 Spring Framework → BeanFactory.

👍 Pros
Object creation logic centralize ho gaya.
Client aur concrete classes ke beech loose coupling.
Easily extendable (naye shapes add karne par client code change nahi hoga).

👎 Cons
Factory class thoda complex lag sakta hai agar bahut saare objects banane ho.



🔍 More Explanation
Triangle class to dono me banani hi padegi (kyunki vo nayi functionality hai).
👉 Matlab Factory Pattern tumhe naye class banane se nahi bachata.
Ye to obvious hai — agar naya shape chahiye, to uska code likhna hi padega.

Fayda kahan hai? Fayda hai client code ko untouched rakhne me.



❌ Without Factory:
Har jagah client me changes karne padenge.
Example:

Shape s3 = new Triangle();  // new class ka naam client me likhna pada
Agar kal ko 100 alag jagah shapes use ho rahi hain → sab jagah client ko modify karna hoga.





✅ With Factory:
Tumne sirf Factory class me ek line add kari.
Client code unchanged raha:
Shape s3 = ShapeFactory.getShape("TRIANGLE");
Kal ko tum Triangle ki jagah EquilateralTriangle bana doge → client ko koi pata hi nahi chalega, bas factory update hogi.



🌎 Real World Example (Factory ka asli fayda)
JDBC Example:

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "1234");
Client ko pata hi nahi hota ki MySQL, Oracle, PostgreSQL ke liye kaunsa Connection class ban rha hai.
Bas factory (DriverManager) ko bolna hai.
👉 Agar tumhe direct new MySQLConnection() likhna padta, to kal ko Oracle pe switch karne ke liye har jagah client code change karna padta.




Chalo or depth m samjhte h


*/