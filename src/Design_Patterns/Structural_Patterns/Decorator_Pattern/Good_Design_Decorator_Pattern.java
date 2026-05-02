package Design_Patterns.Structural_Patterns.Decorator_Pattern;
//Step 1: Component Interface
interface Coffee {
    String getDescription();
    int cost();
}
//Step 2: Basic Concrete Class
class BasicCoffee implements Coffee {

    public String getDescription() {
        return "Basic Coffee";
    }

    public int cost() {
        return 50;
    }
}
//Step 3: Decorator Abstract Class
abstract class CoffeeDecorator implements Coffee {

    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}
//Step 4: Milk Decorator
class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + " + Milk";
    }

    public int cost() {
        return coffee.cost() + 20;
    }
}
//Step 5: Sugar Decorator
class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + " + Sugar";
    }

    public int cost() {
        return coffee.cost() + 10;
    }
}
//Step 6: Main Class
public class Good_Design_Decorator_Pattern {
    public static void main(String[] args) {

        Coffee coffee = new BasicCoffee();

        // Milk add
        coffee = new MilkDecorator(coffee);

        // Sugar add
        coffee = new SugarDecorator(coffee);

        System.out.println(coffee.getDescription());
        System.out.println("Total Cost: " + coffee.cost());
    }
}
