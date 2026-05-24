package Design_Patterns.Structural_Patterns.Composite_Pattern;
/*✅ WITH Composite Pattern

Ab hum common interface banayenge:

interface CompanyMember {
    void showDetails();
}

Ab:

Employee bhi CompanyMember
Manager bhi CompanyMember

Iska fayda:

Manager ke andar hum list bana sakte hain:

List<CompanyMember> members

Ab is list me:

Employee add kar sakte ho
Manager add kar sakte ho
Team Lead add kar sakte ho

Same method:

showDetails();

sab pe chalega.*/

import java.util.ArrayList;
import java.util.List;

// Step 1: Common interface
interface CompanyMember {
    void showDetails();
}

// Step 2: Leaf class
// Leaf means single object jiske andar aur object nahi hai
class Employee implements CompanyMember {

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("Employee: " + name);
    }
}

// Step 3: Composite class
// Composite means group object jiske andar multiple CompanyMember ho sakte hain
class Manager_Good implements CompanyMember {

    private String name;
    private List<CompanyMember> members = new ArrayList<>();

    public Manager_Good(String name) {
        this.name = name;
    }

    public void addMember(CompanyMember member) {
        members.add(member);
    }

    @Override
    public void showDetails() {
        System.out.println("Manager: " + name);

        for (CompanyMember member : members) {
            member.showDetails();
        }
    }
}

// Step 4: Client class

public class Good_Design_Composite_Pattern {
    public static void main(String[] args) {

        Employee emp1 = new Employee("Rahul");
        Employee emp2 = new Employee("Amit");
        Employee emp3 = new Employee("Neha");

        Manager_Good teamLead = new Manager_Good("Vikas");
        teamLead.addMember(emp1);
        teamLead.addMember(emp2);

        Manager_Good projectManager = new Manager_Good("Suresh");
        projectManager.addMember(teamLead);
        projectManager.addMember(emp3);

        projectManager.showDetails();
    }
}


/*Ab is code me Composite ka use kya aaya?

Main magic yaha hai:

private List<CompanyMember> members = new ArrayList<>();

Agar hum likhte:

private List<Employee> employees;

toh sirf employee add hota.

Lekin humne likha:

List<CompanyMember>

Ab Manager ke andar:

Employee bhi add ho sakta hai
Manager bhi add ho sakta hai

Kyuki dono implement kar rahe hain:

CompanyMember
Internal Flow Samajh

Ye line call hui:

projectManager.showDetails();

Ab kya hua?

projectManager = Suresh

Suresh ke members:

teamLead = Vikas
emp3 = Neha

Pehle print:

Manager: Suresh

Then loop chala:

for (CompanyMember member : members)

Pehla member hai teamLead.

Toh call hua:

teamLead.showDetails();

Vikas ke andar:

Rahul
Amit

Print:

Manager: Vikas
Employee: Rahul
Employee: Amit

Fir second member emp3.

Call hua:

emp3.showDetails();

Print:

Employee: Neha
Composite Pattern ke 3 important parts
Part	Meaning	Our Example
Component	Common interface	CompanyMember
Leaf	Single object	Employee
Composite	Group object	Manager
Interview me kaise bolna hai?

Composite Pattern is used when we need to represent a tree-like structure where individual objects and group of objects should be treated in the same way.

Simple version:

Jab single object aur group object dono ko same method se handle karna ho, tab Composite Pattern use karte hain.

Shortcut
Employee = single
Manager = group

Dono ka common method = showDetails()

Yahi Composite hai.
Adapter, Decorator, Proxy, Facade, Composite Difference
Pattern	Simple Meaning
Adapter	Interface match karna
Decorator	Extra feature add karna
Proxy	Access control karna
Facade	Complex system simple banana
Composite	Single aur group ko same tarike se treat karna
*/