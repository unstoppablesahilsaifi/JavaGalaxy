package Design_Patterns.Creational_Patterns.Abstract_Factory_Pattern;
/*Abstract Factory kya hota hai?
Sochlo tum ek furniture shop chalate ho.
Tumhare paas do styles hain — Modern aur Victorian. Har style mein Chair, Table, aur Sofa hota hai.
Problem yeh hai ki agar tum Modern Chair ke saath Victorian Table mix kar do,
toh design kharab ho jaayega. Tumhe guarantee chahiye ki ek hi style ka saara furniture milkar aaye.
Abstract Factory ek pattern hai jo tumhe ek "factory of factories" deta hai —
ek interface jo related objects ka poora family banata hai, bina yeh specify kiye ki unki concrete classes kya hain.*/

// ---- Concrete classes directly — koi interface nahi ----
class ModernChair_Bad {
    public String sitOn() { return "Sitting on a sleek Modern Chair"; }
}
class VictorianChair_Bad {
    public String sitOn() { return "Sitting on an ornate Victorian Chair"; }
}
class ModernTable_Bad {
    public String placeOn() { return "Placing on a minimal Modern Table"; }
}
class VictorianTable_Bad {
    public String placeOn() { return "Placing on a carved Victorian Table"; }
}

public class Bad_Design_Abstract_Factory {
    static void furnishRoom(String style) {
        // PROBLEM 1: Har method mein yahi if-else repeat hoga

        if (style.equals("modern")) {
            ModernChair_Bad chair = new ModernChair_Bad();
            ModernTable_Bad table = new ModernTable_Bad();
            System.out.println(chair.sitOn());
            System.out.println(table.placeOn());
            // PROBLEM 2: Koi nahi rokta — wrong mix bhi compile ho jaata hai

            VictorianChair_Bad wrongChair = new VictorianChair_Bad(); // No compile error!

            System.out.println(wrongChair.sitOn()); // Style mismatch — silent bug

        } else if (style.equals("victorian")) {
            VictorianChair_Bad chair = new VictorianChair_Bad();
            VictorianTable_Bad table = new VictorianTable_Bad();
            System.out.println(chair.sitOn());
            System.out.println(table.placeOn());
        } // PROBLEM 3: Naya "ArtDeco" style? Yahan bhi else-if add karo, aur SAARI jagah bhi

    }

    public static void main(String[] args) {
        furnishRoom("modern");
        System.out.println("---");
        furnishRoom("victorian");
    }
}


/*Output
Sitting on a sleek Modern Chair
Placing on a minimal Modern Table
Sitting on an ornate Victorian Chair  <-- Style mismatch! Koi error nahi
---
Sitting on an ornate Victorian Chair
Placing on a carved Victorian Table
Sitting on an ornate Victorian Chair  <-- Phir wahi bug



Problem 1 — if-else har jagah
10 methods hon toh 10 jagah same if-else likhna padega. Ek jagah bhool gaye? Bug.
Problem 2 — Java compiler bhi nahi pakdega
new VictorianChair() Modern room mein — perfectly valid Java. Runtime par silent bug.
Problem 3 — Closed for extension
Naya style add karna = existing code modify karna. Open/Closed Principle toot raha hai.
*/