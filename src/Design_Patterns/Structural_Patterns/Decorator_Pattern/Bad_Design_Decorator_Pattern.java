package Design_Patterns.Structural_Patterns.Decorator_Pattern;
/*
 Decorator pattern ka use hota hai:

Existing object me new feature dynamically add karne ke liye
WITHOUT uski original class modify kiye.

Matlab:

Class ko change nahi karna
But extra functionality add karni hai*/

/*🧠 Real-life Example

☕ Coffee

Basic coffee = ₹50
Ab customer bolta hai:
Milk add karo
Sugar add karo
Cream add karo

Har combination ke liye alag class banaoge kya? ❌
CoffeeWithMilk
CoffeeWithSugar
CoffeeWithMilkAndSugar
CoffeeWithCream
...

Classes explode ho jayengi 😵

👉 Is problem ko Decorator solve karta hai.*/
class Coffee_Bad{
    public String getDescription(){
        return "Basic coffee";
    }
    public int cost(){
        return 50;
    }
}
class MilkCoffee_Bad extends Coffee_Bad {
    public String getDescription() {
        return "Coffee with Milk";
    }

    public int cost() {
        return 70;
    }
}

class SugarCoffee_Bad extends Coffee_Bad {
    public String getDescription() {
        return "Coffee with Sugar";
    }

    public int cost() {
        return 60;
    }
}
public class Bad_Design_Decorator_Pattern {
    public static void main(String[] args) {
        Coffee_Bad coffee_bad=new MilkCoffee_Bad();
        System.out.println(coffee_bad.getDescription());
        System.out.println(coffee_bad.cost());
    }
}

/*❗ Problem WITHOUT Decorator

Agar combinations badh gaye to?

Need:

Milk + Sugar
Milk + Cream
Sugar + Cream
Milk + Sugar + Cream

👉 Har combination ke liye new class 😵

System unmaintainable ho jayega.*/