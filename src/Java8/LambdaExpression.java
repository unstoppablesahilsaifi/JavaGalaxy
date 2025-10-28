package Java8;
//A lambda expression is an anonymous function — a function without a name and not belonging to any class.
interface Addable{
    int add(int a, int b);
}
public class LambdaExpression {
    public static void main(String[] args) {
        Addable ad=(a,b)-> a+b;
        System.out.println("Addition  :  " + ad.add(3,5));
    }

}
