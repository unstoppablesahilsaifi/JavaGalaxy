package Java17;
//A Record in Java is a special kind of class
//used to store immutable data without writing boilerplate code like constructors, getters, equals(), hashCode(), toString() etc.

/*

Normal Class vs Record Comparison
Traditional Java Class:

class Employee {
    private final int id;
    private final String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Employee[id=" + id + ", name=" + name + "]";
    }
}


Bahut saara boilerplate code likhna padta hai

 Using Record:
record Employee(int id, String name) { }


Bas itna likh do —
Java automatically provide karega:
===>>> No setters Because record is immutable and (Immutable Fields are final by default)
Constructor
Getters (id(), name())
toString()
equals()
hashCode()*/

record Student(int id, String name){}

public class RecordExampleCode {
    public static void main(String[] args) {
        Student s1=new Student(1,"Sahil");
        Student s2=new Student(2,"Rishabh");
        System.out.println(s1.id());
        System.out.println(s2.name());
    }
}
