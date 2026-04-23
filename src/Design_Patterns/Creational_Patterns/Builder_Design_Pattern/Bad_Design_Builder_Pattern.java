package Design_Patterns.Creational_Patterns.Builder_Design_Pattern;
/*🎯 What
Builder Pattern ek creational design pattern hai jo complex objects ko step-by-step banata hai.
Jab ek class mein bahut saare parameters (mandatory + optional) hote hain to constructor overload ho jaata hai aur code messy lagta hai.

Builder ise solve karta hai by:
Readable object creation
Optional parameters handle easily
Immutability support

🛠️ Where Used
Jab ek object ke bahut saare attributes ho (aur har attribute optional/mandatory mix ho).
Jab constructor overload kaafi confusing ho jaye (a.k.a Telescoping Constructor Problem).

Real-world examples:
StringBuilder
Stream.builder()
Lombok @Builder
Effective Java → “use Builder when class has >4 params”

*/


/*Builder Pattern kya hai?
Sochlo tum ek burger order kar rahe ho. Tumhare paas options hain — bun, patty, cheese, lettuce, sauce, extra toppings. Har cheez optional hai, aur combinations hazaron hain.
Agar tum ek hi constructor mein sab kuch pass karo toh kya hoga? new Burger(true, false, true, true, false, "bbq", 2) — yeh padhke kisi ko bhi samajh nahi aayega ki kaunsa true kya hai.
Builder Pattern kehta hai — ek step-by-step "builder" object banao jo tumhe fluently cheezein add karne de, aur end mein .build() call karke final object lo.

Kab use karo?
Jab object mein bahut saare optional fields hon, ya object banana multi-step process ho — jaise Pizza, House, HTTP Request, Database Query. Java mein StringBuilder aur AlertDialog.Builder isi pattern ke famous examples hain.*/
// ---- Burger class — sab kuch constructor mein ----
class Burger_Bad {
    private String size;       // required
    private String patty;     // required
    private boolean cheese;   // optional
    private boolean lettuce;  // optional
    private boolean tomato;   // optional
    private boolean onion;    // optional
    private String sauce;     // optional
    private int extraPatties; // optional

    // PROBLEM 1: Telescoping constructors — ek ke baad ek overloads

    public Burger_Bad(String size, String patty) {
        this(size, patty, false, false, false, false, "none", 0);
    }
    public Burger_Bad(String size, String patty, boolean cheese) {
        this(size, patty, cheese, false, false, false, "none", 0);
    }
    public Burger_Bad(String size, String patty, boolean cheese, boolean lettuce) {
        this(size, patty, cheese, lettuce, false, false, "none", 0);
    }
    // ... aur yeh chain chalti rehti hai — 8 fields = 8+ constructors

    public Burger_Bad(String size, String patty, boolean cheese,
                  boolean lettuce, boolean tomato, boolean onion,
                  String sauce, int extraPatties) {
        this.size = size;
        this.patty = patty;
        this.cheese = cheese;
        this.lettuce = lettuce;
        this.tomato = tomato;
        this.onion = onion;
        this.sauce = sauce;
        this.extraPatties = extraPatties;
    }

    @Override
    public String toString() {
        return "Burger[" + size + ", " + patty +
                ", cheese=" + cheese + ", lettuce=" + lettuce +
                ", tomato=" + tomato + ", onion=" + onion +
                ", sauce=" + sauce + ", extraPatties=" + extraPatties + "]";
    }
}

public class Bad_Design_Builder_Pattern {
    public static void main(String[] args) {

        // PROBLEM 2: Yeh line padhke koi nahi samjhega — kaunsa true kya hai?

        Burger_Bad b1 = new Burger_Bad("large", "beef", true, false, true, false, "bbq", 1);

        System.out.println(b1);

        // PROBLEM 3: Sirf cheese chahiye? Phir bhi 8 arguments dene padenge

        Burger_Bad b2 = new Burger_Bad("small", "chicken", true, false, false, false, "none", 0);

        System.out.println(b2);
    }
}


/*Output
Burger[large, beef, cheese=true, lettuce=false, tomato=true, onion=false, sauce=bbq, extraPatties=1]
Burger[small, chicken, cheese=true, lettuce=false, tomato=false, onion=false, sauce=none, extraPatties=0]



Problem 1 — Telescoping constructors
Har combination ke liye naya constructor. 8 optional fields = potentially 256 combinations.
Problem 2 — Unreadable call site
new Burger("large","beef",true,false,true,false,"bbq",1) — 6 mahine baad tum khud nahi samjhoge.
Problem 3 — Forced null/default values
Sirf cheese chahiye toh bhi baaki 6 fields ke liye false/"none"/0 dena padega.*/