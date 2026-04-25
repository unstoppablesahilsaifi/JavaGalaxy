package Design_Patterns.Creational_Patterns.Prototype_Pattern;
//Prototype pattern me hum ek object banate hain aur usko clone karte hain.
// Isse initialization ek hi baar hota hai, baaki objects uske copy hote hain.

/*Cloneable Java mein pehle se built-in hai
Cloneable Java ka apna interface hai — tumhe kuch banana nahi. Yeh java.lang package mein already exist karta hai. Bas tumhari class mein implements Cloneable likhna hota hai aur clone() method override karna hota hai.
Bilkul waise jaise Comparable ya Serializable hote hain — Java ke readymade interfaces.*/


/*
 * Prototype Design Pattern — Employee class
 *
 * PATTERN : Prototype (Creational Design Pattern)
 * PURPOSE : Naye Employee objects ko scratch se banane ke bajaye
 * existing object ko clone karke banao.
 * Isse heavy initialization baar baar nahi karni padti.
 *
 * PROBLEM (without Prototype):
 * - Har employee ke liye new Employee(...) likhna padta tha
 * - Same department/role ke liye saari values dobara pass karni padti thi
 * - Ek field bhool gaye? Silent bug.
 *
 * SOLUTION (with Prototype):
 * - Ek baar fully setup karo → clone() se copies nikalo
 * - Sirf jo alag hai woh badlo (name, id etc.)
 */


class Employee implements Cloneable {

    private String name;
    private String dept;

    /**
     * Constructor — heavy operation hai (DB se data fetch karta hai).
     * Prototype Pattern mein yeh sirf EK BAAR chalta hai.
     * Baaki copies clone() se banti hain — yahan aana nahi padta.
     */
    public Employee(String name, String dept) {
        System.out.println("Fetching data from DB..."); // costly step
        this.name = name;
        this.dept = dept;
    }

    /**
     * clone() — Prototype Pattern ka core.
     *
     * super.clone() andar Java khud:
     * → naya object memory mein banata hai
     * → saari fields copy karta hai
     * → constructor NAHI chalata ← yahi asli fayda hai!
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {

        return super.clone(); // DB call nahi hogi — seedha copy!

    }


    // Clone ke baad sirf naam badalna ho toh yeh use karo
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() { return name + " - " + dept; }
}


public class Good_Design_Prototype_Pattern {
    public static void main(String[] args) throws CloneNotSupportedException {

        // Step 1: Sirf ek baar new karo → DB call hogi
        Employee e1 = new Employee("Sahil", "IT");

        // Step 2: Clone karo → DB call NAHI hogi, constructor NAHI chala

        Employee e2 = (Employee) e1.clone();

        e2.setName("Amit"); // sirf naam alag kiya, dept same rahi

        System.out.println(e1); // Sahil - IT
        System.out.println(e2); // Amit - IT

        // Proof: dono alag objects hain, ek nahi
        System.out.println("Same object? " + (e1 == e2)); // false
    }
}
