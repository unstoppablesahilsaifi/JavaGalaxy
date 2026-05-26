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
