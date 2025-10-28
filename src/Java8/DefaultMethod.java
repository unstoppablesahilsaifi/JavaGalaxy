package Java8;
interface MyInterfaceForDefaultMethod{
    default void disp(){
        System.out.println("Displaying default method");
    }
}
class MyClass implements MyInterfaceForDefaultMethod{

}
public class DefaultMethod {
    public static void main(String[] args) {
        MyClass mc=new MyClass();
        mc.disp();
    }
}
