package Java17;

public class VarExplanation {
    public static void main(String[] args) {
        // Variable ka type compiler khud decide krta h, or hn variable ko initialize krna jroori h or hn var should be locally
        var name = "Sahil";      // inferred as String
        var age = 25;            // inferred as int
        var salary = 75000.50;   // inferred as double

        System.out.println(name);
        System.out.println(age);
        System.out.println(salary);
    }
}
