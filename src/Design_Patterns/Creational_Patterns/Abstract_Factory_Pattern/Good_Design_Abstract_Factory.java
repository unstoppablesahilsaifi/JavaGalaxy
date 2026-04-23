package Design_Patterns.Creational_Patterns.Abstract_Factory_Pattern;

// ========================================
// STEP 1: Abstract Product interfaces
// ========================================
interface Chair {
    String sitOn();
}

interface Table {
    String placeOn();
}

// ========================================
// STEP 2: Concrete Products
// ========================================
class ModernChair implements Chair {
    @Override
    public String sitOn() { return "Sitting on a sleek Modern Chair"; }
}
class VictorianChair implements Chair {
    @Override
    public String sitOn() { return "Sitting on an ornate Victorian Chair"; }
}
class ArtDecoChair implements Chair {
    @Override
    public String sitOn() { return "Sitting on a geometric Art Deco Chair"; }
}
class ModernTable implements Table {
    @Override
    public String placeOn() { return "Placing on a minimal Modern Table"; }
}
class VictorianTable implements Table {
    @Override
    public String placeOn() { return "Placing on a carved Victorian Table"; }
}
class ArtDecoTable implements Table {
    @Override
    public String placeOn() { return "Placing on a bold Art Deco Table"; }
}

// ========================================
// STEP 3: Abstract Factory interface — THE KEY
// ========================================
interface FurnitureFactory {
    Chair createChair();
    Table createTable();
}

// ========================================
// STEP 4: Concrete Factories — ek family, ek jagah
// ========================================
class ModernFactory implements FurnitureFactory {
    @Override
    public Chair createChair() { return new ModernChair(); }
    @Override
    public Table createTable() { return new ModernTable(); }
}
class VictorianFactory implements FurnitureFactory {
    @Override
    public Chair createChair() { return new VictorianChair(); }
    @Override
    public Table createTable() { return new VictorianTable(); }
}
// STEP 4b: Naya style? Sirf ek nayi class — baaki code ZERO touch

class ArtDecoFactory implements FurnitureFactory {
    @Override
    public Chair createChair() { return new ArtDecoChair(); }
    @Override
    public Table createTable() { return new ArtDecoTable(); }
}

// ========================================
// STEP 5: Client — factory jaanta hai, concrete classes nahi
// ========================================
public class Good_Design_Abstract_Factory {


// FurnitureFactory type leta hai — koi specific class nahi

    static void furnishRoom(FurnitureFactory factory) {


// FIX 1: No if-else — factory decide karti hai kya banana hai

        Chair chair = factory.createChair();
        Table table = factory.createTable();


// FIX 2: VictorianChair yahan banana possible hi nahi


// factory.createChair() HAMESHA correct family return karega


        System.out.println(chair.sitOn());
        System.out.println(table.placeOn());
    }

    public static void main(String[] args) {
        System.out.println("=== Modern Room ===");
        furnishRoom(new ModernFactory());

        System.out.println("=== Victorian Room ===");
        furnishRoom(new VictorianFactory());


// FIX 3: furnishRoom method BILKUL nahi badla — sirf factory pass ki

        System.out.println("=== Art Deco Room ===");
        furnishRoom(new ArtDecoFactory());
    }
}


/*Output
=== Modern Room ===
Sitting on a sleek Modern Chair
Placing on a minimal Modern Table
=== Victorian Room ===
Sitting on an ornate Victorian Chair
Placing on a carved Victorian Table
=== Art Deco Room ===
Sitting on a geometric Art Deco Chair
Placing on a bold Art Deco Table


Fix 1 — Zero if-else in client
furnishRoom() ko style ka pata hi nahi. FurnitureFactory interface se baat karta hai bas.
Fix 2 — Java type system guarantee karta hai
Chair aur Table interfaces use hote hain — concrete class ka naam client mein kahin nahi hai.
Fix 3 — Open/Closed Principle follow hua
ArtDecoFactory add ki — existing furnishRoom(), ModernFactory, VictorianFactory — sab untouched.
*/