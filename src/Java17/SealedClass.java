package Java17;
//A sealed class or interface restricts which other classes or interfaces can extend or implement it.
// Syntax : sealed class Parent permits Child1, Child2 { }

/*public sealed class Vehicle permits Car, Truck {}
public final class Car extends Vehicle {}
public non-sealed class Truck extends Vehicle {}

sealed: Restricts inheritance.
permits: Allowed subclasses ka list.
Subclasses must be final, sealed, or non-sealed.
*/
sealed class Parent permits child1, child2{
    void message(){
        System.out.println("I am from Parent class");
    }
}
final class child1 extends Parent{
    @Override
    void message() {
        System.out.println("I am from Child1");
    }
}
non-sealed class child2 extends  Parent{
    @Override
    void message() {
        System.out.println("I am from Child2");
    }
}
// Another class trying to extend Parent (not allowed)
// class Hacker extends Parent {}   Compile-time error
public class SealedClass {
    public static void main(String[] args) {
        Parent obj1=new child1();
        obj1.message();

        Parent obj2 = new child2();
        obj2.message();

    }

}

/*
sealed	    restricts which classes can extend	    ✅ (only permitted ones)
non-sealed	removes restriction again	            ✅ (anyone can extend)
final	    no one can extend further	            ❌
* */