package SOLID_Principles.SRP_1;
//One class = One responsibility

class UserRepository {

    public void saveUser(String name) {
        System.out.println("User saved in database: " + name);
    }
}
class EmailService {

    public void sendEmail(String name) {
        System.out.println("Email sent to user: " + name);
    }
}
class ReportService {

    public void generateReport(String name) {
        System.out.println("Report generated for user: " + name);
    }
}
public class Good_Design_SRP {
    public static void main(String[] args) {

        UserRepository repo = new UserRepository();
        EmailService emailService = new EmailService();
        ReportService reportService = new ReportService();

        repo.saveUser("Sahil");
        emailService.sendEmail("Sahil");
        reportService.generateReport("Sahil");
    }
}
