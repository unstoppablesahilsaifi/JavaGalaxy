package Design_Patterns.Structural_Patterns.Flyweight_Pattern;
import java.util.HashMap;
import java.util.Map;

// Step 1: Flyweight class
class Soldier {

    private String type;

    public Soldier(String type) {
        this.type = type;

        System.out.println(type + " Soldier Created");
    }

    public void showPosition(int x, int y) {
        System.out.println(type + " at position (" + x + "," + y + ")");
    }
}

// Step 2: Flyweight Factory
class SoldierFactory {

    private static Map<String, Soldier> soldierMap = new HashMap<>();

    public static Soldier getSoldier(String type) {

        if (!soldierMap.containsKey(type)) {

            Soldier soldier = new Soldier(type);

            soldierMap.put(type, soldier);
        }

        return soldierMap.get(type);
    }
}

// Step 3: Client
public class Good_Design_Flyweight_Pattern {
    public static void main(String[] args) {

        Soldier s1 = SoldierFactory.getSoldier("Terrorist");
        s1.showPosition(10, 20);

        Soldier s2 = SoldierFactory.getSoldier("Terrorist");
        s2.showPosition(30, 40);

        Soldier s3 = SoldierFactory.getSoldier("Terrorist");
        s3.showPosition(50, 60);
    }
}

/*🔥 Observe Carefully

WITHOUT Flyweight:

Created
Created
Created

WITH Flyweight:

Created

Sirf ek object bana 🔥

Baaki reuse hua.

🔥 Main Magic

Ye line:

private static Map<String, Soldier> soldierMap

Ye cache hai.

Flow Samajh

First call:

getSoldier("Terrorist")

Map empty hai.

👉 New object create hua.

Store ho gaya:

"Terrorist" → object

Second call:

getSoldier("Terrorist")

Ab map me already hai.

👉 New object nahi banega.

Old object return hoga.

🔥 Flyweight me 2 cheeze hoti hain
Type	Meaning
Intrinsic State	Shared/common data
Extrinsic State	Unique data
Hamare example me
State	Example
Intrinsic	Soldier type
Extrinsic	x,y position
Interview Definition

Flyweight Pattern minimizes memory usage by sharing common objects instead of creating duplicate objects.

Shortcut Yaad Rakh
Same object baar baar?
→ reuse karo
→ Flyweight
Difference
Pattern	Purpose
Adapter	Interface convert
Decorator	Feature add
Proxy	Access control
Facade	Complexity hide
Composite	Tree structure
Flyweight	Memory optimize
🔥 Java Real Example
String s1 = "Hello";
String s2 = "Hello";

Java new object nahi banata baar baar.

👉 String pool use karta hai.

Ye Flyweight concept hai 🔥*/