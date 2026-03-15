package SOLID_Principles.OCP_2;
//Ab hum interface use karenge.
//Old code modify nahi hoga.
//New payment method → new class.

// Interface bnaya mtlb rule set ho gya
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

// Is class ka kaam h 👉 kisi bhi payment ko process karna
/*Ye nahi dekhta
Credit Card hai
UPI hai
PayPal hai
Bitcoin hai

Usko bas Payment object milna chahiye*/
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



// Doubt sun lo ab. => Interface ka object bana ke directly call kar sakte hain, to PaymentProcessor_OCP ki need kya hai?

/*Payment creditCard = new CreditCardPayment();
creditCard.processPayment();
Payment upi = new UpiPayment();
upi.processPayment();

Ye perfectly valid code hai.
Yaha bhi OCP violate nahi ho raha.

To fir PaymentProcessor kyu banaya?

1️⃣ Responsibility separation (SRP + OCP)

Agar real system ho to payment processing me bahut cheeze hoti hain
Example:
validation
logging
fraud check
transaction save
payment execute
notification
Agar tu direct call karega

creditCard.processPayment();

To har jagah ye sab logic repeat hoga.
Isliye ek central processor bana dete hain.

Example:
class PaymentProcessor {
    public void processPayment(Payment payment) {
        System.out.println("Starting transaction");
        payment.processPayment();
        System.out.println("Transaction completed");
    }
}
Ab common logic ek jagah aa gaya.*/