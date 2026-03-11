package SOLID_Principles.SRP_1;
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