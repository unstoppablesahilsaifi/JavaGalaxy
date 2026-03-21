package Design_Patterns.Creational_Patterns.Singleton_Pattern;
/*📌 Definition
👉 Singleton ek Creational Design Pattern hai jo ensure karta hai ki ek class ka sirf ek hi object bane aur us object ko globally access kiya ja sake.
🌍 Real-Life Analogy
👤 Government PM/President → Sirf ek hota hai poore desh ka. Har jagah se wahi instance access hota hai.
🖨️ Printer Spooler → Agar multiple objects ban gaye toh sab apna-apna print queue maintain karenge → mess ho jayega. Isliye ek hi instance chahiye jo sab handle kare.
Database Connection → Ek hi shared connection pool maintain karna efficient hai.*/
class DatabaseConnection_Without_Singleton{
    public DatabaseConnection_Without_Singleton(){
        System.out.println("Connection has been created");
    }
}

public class Bad_Design_Without_Singleton {
    public static void main(String[] args) {
        DatabaseConnection_Without_Singleton db1=new DatabaseConnection_Without_Singleton();
        DatabaseConnection_Without_Singleton db2=new DatabaseConnection_Without_Singleton();
        System.out.println(db1);
        System.out.println(db2);
    }
}
/*❌ Issue:
Har new DatabaseConnection() call ek naya object banata hai.
Database connections heavy hote hain → multiple connections banenge toh memory waste hoga.*/
