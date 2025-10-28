package Java8;
interface MyInterfaceForStaticMethod{
    static void display(){
        System.out.println("Displaying static method");
    }
}
public class StaticMethod {
    public static void main(String[] args) {
        MyInterfaceForStaticMethod.display();
    }
}
