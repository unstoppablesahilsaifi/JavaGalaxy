package Design_Patterns.Creational_Patterns.Prototype_Pattern;
/*🚀 Prototype Design Pattern
Prototype ek creational design pattern hai.
Isme hum new object ko create karne ke bajaye ek existing object ka clone banaate hain.

Useful jab:
Object creation expensive/complex ho
Object ko baar-baar same config ke sath banana ho
👉 Ek line: Prototype = “Copy-Paste Object”

Prototype Pattern kya hai?
Sochlo tumhare paas ek bahut complex object hai — jaise ek fully configured Employee jisme department, permissions, address, skills sab filled hai. Ab tumhe 10 aur employees chahiye jo almost same hain, sirf name aur ID alag hai.
Har baar new Employee() karke sab kuch dobara set karna — expensive, repetitive, aur error-prone hai.
Prototype Pattern kehta hai — existing object ko hi clone karo aur sirf jo alag hai woh badlo. Original object ek "prototype" ban jaata hai jisse copies nikalte hain.
Java mein yeh Cloneable interface aur clone() method se implement hota hai.

Kab use karo?
Jab object banana costly ho (DB se data load karna, heavy computation), jab bahut saare similar objects chahiye hon, ya jab object ki internal state copy karni ho bina uski class jaane.

*/

class Employee_Bad{
    private String name;
    private String department;
    public Employee_Bad(String name,String department){
        this.name=name;
        this.department=department;
    }
    public void show(){
        System.out.println(name + " works in "+ department);
    }
}
public class Bad_Design_Prototype_Pattern {
    public static void main(String[] args) {
        Employee_Bad e1=new Employee_Bad("Sahil", "IT");
        Employee_Bad e2=new Employee_Bad("Rahul", "Java"); // Again heavy initialization
        e1.show();
        e2.show();
    }
}
//👉 Problem: Har object banate waqt heavy initialization repeat hoga.