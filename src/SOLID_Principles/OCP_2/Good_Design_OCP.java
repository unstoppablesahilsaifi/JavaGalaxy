package SOLID_Principles.OCP_2;
//Ab hum interface use karenge.
//Old code modify nahi hoga.
//New payment method → new class.
interface Payment {

    void processPayment();
}
class CreditCardPayment implements Payment {

    public void processPayment() {
        System.out.println("Processing Credit Card payment");
    }
}
class UpiPayment implements Payment {

    public void processPayment() {
        System.out.println("Processing UPI payment");
    }
}
class PaypalPayment implements Payment {

    public void processPayment() {
        System.out.println("Processing PayPal payment");
    }
}
class PaymentProcessor_OCP {

    public void processPayment(Payment payment) {
        payment.processPayment();
    }
}
public class Good_Design_OCP {
    public static void main(String[] args) {

        PaymentProcessor_OCP processor = new PaymentProcessor_OCP();

        Payment creditCard = new CreditCardPayment();
        Payment upi = new UpiPayment();

        processor.processPayment(creditCard);
        processor.processPayment(upi);
    }
}

/*Agar new payment add karna ho:
BitcoinPayment
Sirf new class create karo.
class BitcoinPayment implements Payment
Existing code change nahi karna.*/
