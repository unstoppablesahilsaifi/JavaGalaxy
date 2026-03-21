package Design_Patterns.Creational_Patterns.Singleton_Pattern;
/*🔧 Singleton ka basic logic (samajh lo)

1. Constructor ko private kar do
👉 koi bahar se object na bana paaye

2. Ek static variable bana lo (same class ka)
👉 wahi single object store karega

3. Ek method (getInstance()) bana lo
👉 wahi object return karega*/


class DatabaseConnection_With_Singleton {
    // Step 1: Single instance ko hold karne ke liye static variable
    private static DatabaseConnection_With_Singleton instance;

    // Step 2: Constructor private (taaki koi new na kar sake)
    private DatabaseConnection_With_Singleton() {
        System.out.println("Database Connection Created...");
    }

    // Step 3: Public static method jo ek hi object return karega
    public static DatabaseConnection_With_Singleton getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection_With_Singleton();
        }
        return instance;
    }
}
public class Good_Design_With_Singleton {
    public static void main(String[] args) {
        DatabaseConnection_With_Singleton db1 = DatabaseConnection_With_Singleton.getInstance();
        DatabaseConnection_With_Singleton db2 = DatabaseConnection_With_Singleton.getInstance();

        System.out.println(db1);
        System.out.println(db2);
    }
}
//👉 Sirf ek hi instance bana aur dono reference usi ko point kar rahe hain.
/*💡 Where Singleton is Used in Real Life
🗄️ Database connections (JDBC)
📝 Logging frameworks (Log4j, SLF4J)
⚡ Cache management
⚙️ Configuration managers
🌱 Spring Beans (by default singleton scope)*/


/*❓ Doubt Clarifications
🔑 Normal Object Creation
Jab hum aise likhte hain:

DatabaseConnection db1 = new DatabaseConnection();
DatabaseConnection db2 = new DatabaseConnection();
👉 Har new call naya object banata hai. Isliye db1 aur db2 alag-alag addresses pe honge.

🔑 Singleton ka Twist
Singleton me hum direct new nahi karne dete (constructor ko private bana dete hain).

Matlab koi bhi DatabaseConnection db = new DatabaseConnection(); likhega → ❌ compile error.
Sirf class khud hi apne andar object create kar sakti hai.
🔑 Kaise hota hai?
private static DatabaseConnection instance; // initially null
Ye ek static variable hai jo poore program me ek hi jagah memory me hota hai.
public static DatabaseConnection getInstance() {
    if (instance == null) {   // pehli baar null hoga
        instance = new DatabaseConnection();  // tabhi ek object banega
    }
    return instance;          // baaki time wahi return hoga
}
🔁 Execution Flow
DatabaseConnection db1 = DatabaseConnection.getInstance();
👉 Pehli baar call hua:

instance == null tha → naya object ban gaya → db1 usko point karega.
DatabaseConnection db2 = DatabaseConnection.getInstance();
👉 Doosri baar call hua:

Ab instance != null hai → naya object nahi banega.
Wahi pehle se existing object return hoga → db2 bhi usi ko point karega.
✅ Proof
System.out.println(db1);
System.out.println(db2);
🖥️ Output:

DatabaseConnection@6d06d69c
DatabaseConnection@6d06d69c
👉 Dono ka address same hai → matlab ek hi object.*/