package Design_Patterns.Structural_Patterns.Flyweight_Pattern;
/*🔹 Flyweight Pattern kya hota hai?
Flyweight pattern ka kaam hota hai:
Memory bachana by sharing common objects.

Matlab:
Agar same type ke bahut saare objects ban rahe hain
To har baar new object nahi banayenge
Existing object reuse karenge

🧠 Real-life Example
PUBG / Free Fire game 🎮
1000 soldiers hain.

Har soldier ka:
gun same
uniform same
face same

Sirf:
position different
health different

Agar har soldier ke liye:
new gun
new uniform
new texture

banega to memory udd jayegi 💀

Toh game kya karta hai?

👉 Common cheeze share karta hai.
Bas unique cheeze alag rakhta hai.

Yahi Flyweight hai.

🎯 One-line Definition
Flyweight Pattern reduces memory usage by sharing common objects instead of creating new ones repeatedly.

🔥 Kyu use hota hai?
Jab:
bahut large number of similar objects ho
aur memory optimize karni ho
Real-world Uses
Game development
String pool in Java
Cache systems
Text editors
Icons/UI rendering

❌ WITHOUT Flyweight Pattern
Maan lo game me soldiers bana rahe hain.
Har baar new object banega.
*/
class Soldier_Bad {

    private String type;

    public Soldier_Bad(String type) {
        this.type = type;

        System.out.println(type + " Soldier Created");
    }

    public void showPosition(int x, int y) {
        System.out.println(type + " at position (" + x + "," + y + ")");
    }
}
public class Bad_Design_Flyweight_Pattern {
    public static void main(String[] args) {

        Soldier_Bad s1 = new Soldier_Bad("Terrorist");
        s1.showPosition(10, 20);

        Soldier_Bad s2 = new Soldier_Bad("Terrorist");
        s2.showPosition(30, 40);

        Soldier_Bad s3 = new Soldier_Bad("Terrorist");
        s3.showPosition(50, 60);
    }
}


/*❗ Problem WITHOUT Flyweight

3 same soldiers ke liye:

3 objects bane
memory waste hui

Large game me:

100000 soldiers

😵 Memory crash ho sakti hai.*/