package Java17;
class Vehical{
}
class Car extends Vehical{

}

public class InstanceOfExplanation {
    public static void main(String[] args) {
        //instanceof ek keyword/operator hai jo check karta hai ki koi object kis class ka instance hai ya nahi.
//        objectReference instanceof ClassName
//        true → agar object us class ka instance hai
//        false → agar nahi hai
        Vehical v = new Vehical();
        Car car = new Car();
        System.out.println( v instanceof Car);
        System.out.println(v instanceof Vehical);




    }
}
