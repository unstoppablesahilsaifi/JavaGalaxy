package SOLID_Principles.OCP_2;
//Open Closed Principle (OCP)
// Software entities (classes, modules, functions) should be open for extension but closed for modification.

//Agar system me new feature add karna ho to:
//❌ old code modify nahi karna chahiye
//✅ new class add karke extend karna chahiye

/*Real Life Example
Socho Payment System.
Pehle system support karta hai:
Credit Card

Baad me add karna hai:
UPI
PayPal

Agar har baar existing code modify karna pade → OCP violation.
Correct design:
New payment method = new class
Old code untouched.*/
class PaymentProcessor {

    public void processPayment(String paymentType) {

        if (paymentType.equals("CREDIT_CARD")) {
            System.out.println("Processing Credit Card payment");
        }

        else if (paymentType.equals("UPI")) {
            System.out.println("Processing UPI payment");
        }

        else if (paymentType.equals("PAYPAL")) {
            System.out.println("Processing PayPal payment");
        }

        else {
            System.out.println("Invalid payment method");
        }
    }
}

public class Bad_Design_OCP {
    public static void main(String[] args) {

        PaymentProcessor processor = new PaymentProcessor();

        processor.processPayment("CREDIT_CARD");
        processor.processPayment("UPI");
    }
}

/*Agar new payment method aa jaye

Example
➡️ Bitcoin payment

To kya karna padega?

else if(type.equals("bitcoin")) {
    System.out.println("Processing Bitcoin payment");
}

Matlab

❌ existing class modify karni padegi

Ye OCP violation hai.

Matlab:

❌ existing class change
❌ testing break ho sakti hai
❌ maintain karna mushkil*/
