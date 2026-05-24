package Design_Patterns.Structural_Patterns.Composite_Pattern;
//Jab single object aur group object ko same tarike se handle karna ho, tab Composite Pattern use hota hai.
/*Simple Real Life Example
Company me:
Employee = single person
Manager = group ka head

Manager ke under:
Employee ho sakta hai
Dusra Manager bhi ho sakta hai

Example:
CEO
 ├── Manager 1
 │    ├── Developer
 │    └── Tester
 └── Manager 2
      └── Designer

Ab problem ye hai:

👉 Employee ka salary print karna hai
👉 Manager ke under jitne log hain sabki salary print karni hai

Toh hume aisa design chahiye jisme:

showDetails();

same method se:

Employee bhi print ho
Manager ke under wali team bhi print ho

Isi ko Composite bolte hain.

One Line Me Yaad Rakh

Composite Pattern group aur individual object ko same interface se handle karne deta hai.

Kyu use hota hai?

Jab structure tree type ho:

One object ke andar multiple objects
Aur un multiple objects ke andar bhi multiple objects

Tab Composite useful hota hai.

Real World Use
Company hierarchy
Menu and submenu
File and folder
Organization chart
UI components
Category and subcategory*/

import java.util.ArrayList;
import java.util.List;

class Employee_Bad {

    private String name;

    public Employee_Bad(String name) {
        this.name = name;
    }

    public void showEmployeeDetails() {
        System.out.println("Employee: " + name);
    }
}

class Manager {

    private String name;
    private List<Employee_Bad> employees = new ArrayList<>();

    public Manager(String name) {
        this.name = name;
    }

    public void addEmployee(Employee_Bad employee) {
        employees.add(employee);
    }

    public void showManagerDetails() {
        System.out.println("Manager: " + name);

        for (Employee_Bad employee : employees) {
            employee.showEmployeeDetails();
        }
    }
}


public class Bad_Design_Composite_Pattern {
    public static void main(String[] args) {

        Employee_Bad emp1 = new Employee_Bad("Rahul");
        Employee_Bad emp2 = new Employee_Bad("Amit");

        Manager manager = new Manager("Suresh");

        manager.addEmployee(emp1);
        manager.addEmployee(emp2);

        manager.showManagerDetails();
    }
}




/*Isme problem kya hai?

Abhi Manager ke under sirf Employee add ho sakta hai:

private List<Employee> employees = new ArrayList<>();

Lekin real company me Manager ke under dusra Manager bhi ho sakta hai.

Example:

CEO
 └── Manager
      ├── Employee
      └── Team Lead
           └── Employee

Ab without Composite:

Manager ke liye alag list
Employee ke liye alag list
TeamLead ke liye alag class
Har level ke liye alag logic

Code messy ho jayega.
*/