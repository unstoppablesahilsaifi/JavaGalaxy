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
example JDBC wala hi best hai “Oracle pe switch” samjhane ke liye.

🔥 Dekh ab step by step:
❌ Case 1: Without Factory
public class Main {
    public static void main(String[] args) {
        // Abhi MySQL use kar rahe ho
        Connection con = new MySQLConnection();

        // Kal Oracle pe switch karna ho...
        Connection con = new OracleConnection();  // 👈 YE line badalni padegi

        // Aur agar 50 jagah MySQLConnection likha hai
        // to sab jagah replace karna padega 😩
    }
}
👉 Matlab tum client code har jagah modify karoge. Isko bolte hain tight coupling.

✅ Case 2: With Factory
class ConnectionFactory {
    public static Connection getConnection(String dbType) {
        if (dbType.equalsIgnoreCase("MYSQL")) {
            return new MySQLConnection();
        } else if (dbType.equalsIgnoreCase("ORACLE")) {
            return new OracleConnection();
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        // Client ko sirf yeh bolna hai
        Connection con = ConnectionFactory.getConnection("MYSQL");

        // Kal Oracle pe switch karna ho to
        Connection con = ConnectionFactory.getConnection("ORACLE"); // 👈 Bas ek jagah badlo
    }
}
👉 Ab tum client ke andar new MySQLConnection() likh hi nahi rahe. Sirf ek string / config change karke Oracle pe switch kar liya. Baaki client code untouched hai.

🎯 Real JDBC Example
Connection con = DriverManager.getConnection(
    "jdbc:oracle:thin:@localhost:1521:xe", "system", "1234"
);
Tumhe OracleConnection ka class dikh bhi nahi raha.
DriverManager (Factory) decide karta hai internally kaunsa object banana hai.
Client ka code same hi rehta hai, chahe MySQL use karo ya Oracle.
✅ Summary
Without Factory → Har jagah client code badalna padta hai (Oracle switch karte waqt).
With Factory → Sirf Factory update hoti hai, client same rehta hai.
👉 Matlab bhai, Factory Pattern = Ek baar extra code likh ke future me dard bachana. Ab bada project me iska fayda bahut bada hota hai (maintenance cost ↓, bugs ↓).

*/