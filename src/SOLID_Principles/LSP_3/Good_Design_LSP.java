package SOLID_Principles.LSP_3;
//Ab hum behaviour separate karenge.

// Base class
class Bird_LSP {

    public void eat() {
        System.out.println("Bird is eating");
    }
}

// Separate flying behavior
class FlyingBird_LSP extends Bird_LSP {

    public void fly() {
        System.out.println("Flying bird is flying");
    }
}

// Sparrow can fly
class Sparrow_LSP extends FlyingBird_LSP {

    @Override
    public void fly() {
        System.out.println("Sparrow flying in the sky");
    }
}

// Penguin cannot fly but still a bird
class Penguin_LSP extends Bird_LSP {

    public void swim() {
        System.out.println("Penguin is swimming");
    }
}

public class Good_Design_LSP {

    public static void main(String[] args) {

        FlyingBird_LSP sparrow = new Sparrow_LSP();
        sparrow.fly();
        // ✅ Sparrow flying in the sky

        Bird_LSP penguin = new Penguin_LSP();
        penguin.eat();
        // ✅ Bird is eating

        Penguin_LSP p = new Penguin_LSP();
        p.swim();
        // ✅ Penguin is swimming
    }
}
/*Good design me:
Penguin ko fly() inherit hi nahi hua.*/

//LSP ka golden rule
//Parent class me sirf woh behavior rakho jo sab children ke liye valid ho.

/*To fix the LSP violation, we separated flying behavior into a specialized subclass FlyingBird.
 Now only birds that can fly extend it,
 while birds like Penguin extend the base Bird class without inheriting irrelevant behavior.*/