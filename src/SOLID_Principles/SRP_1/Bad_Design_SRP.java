package SOLID_Principles.SRP_1;

/*1️⃣ Why is it Needed?
Software is never a one-day project. Over time, it goes through updates, changes, bug fixes, and new features.
If a class/module starts doing more than one type of job:
❌ Every small change can cause side effects
❌ Code becomes hard to understand
❌ Maintenance time and cost increase
❌ Testing takes longer because a change in one part can break another part
SRP solves this problem by saying — a class should have only one responsibility.*/

/*2️⃣ What is SRP?
📖 Definition (Robert C. Martin):
“A class should have only one reason to change.”
💡 Meaning:
A class should have only one responsibility (or purpose)
If a class has more than one reason to change, it is violating SRP
🗣 In simple words: If a person is an accountant, HR, and driver at the same time, mistakes will happen.
Same logic applies to code — one class should not try to do everything.*/
class UserManager_SRP{
    public void saveUser(String name){
        System.out.println("User " + name + " has been saved");
    }
    public void sendEmail(String name) {
        // email logic
        System.out.println("Email sent to user: " + name);
    }

    public void generateReport(String name) {
        // report logic
        System.out.println("Report generated for user: " + name);
    }
}
public class Bad_Design_SRP {
    public static void main(String[] args) {
        UserManager_SRP obj=new UserManager_SRP();
        obj.saveUser("Sahil");
        obj.sendEmail("Sahil");
        obj.generateReport("Sahil");
    }
}


/*
Problem kya hai?
Is class ke multiple reasons to change hain.

Agar change aaye:
Change	                Impact
Database change     	UserManager change
Email service change	UserManager change
Report format change	UserManager change

Matlab har change me same class modify hogi.

Ye tight coupling + maintenance nightmare hai.
* */