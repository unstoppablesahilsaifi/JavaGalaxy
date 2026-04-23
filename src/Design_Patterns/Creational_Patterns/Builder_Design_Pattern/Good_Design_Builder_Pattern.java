package Design_Patterns.Creational_Patterns.Builder_Design_Pattern;

class Burger {
    // ---- Fields — same as before ----
    private final String size;
    private final String patty;
    private final boolean cheese;
    private final boolean lettuce;
    private final boolean tomato;
    private final boolean onion;
    private final String sauce;
    private final int extraPatties;

    // FIX 1: Sirf ek private constructor — Builder ke through hi banta hai

    private Burger(Builder builder) {
        this.size       = builder.size;
        this.patty     = builder.patty;
        this.cheese    = builder.cheese;
        this.lettuce   = builder.lettuce;
        this.tomato    = builder.tomato;
        this.onion     = builder.onion;
        this.sauce     = builder.sauce;
        this.extraPatties = builder.extraPatties;
    }

    @Override
    public String toString() {
        return "Burger[" + size + ", " + patty +
                ", cheese=" + cheese + ", lettuce=" + lettuce +
                ", tomato=" + tomato + ", onion=" + onion +
                ", sauce=" + sauce + ", extra=" + extraPatties + "]";
    }

    // ================================================
    // THE BUILDER — static inner class
    // ================================================
    static class Builder {

        // FIX 1: Sirf required fields constructor mein — optional baad mein

        private final String size;
        private final String patty;

        // Optional fields — sensible defaults
        private boolean cheese     = false;
        private boolean lettuce    = false;
        private boolean tomato     = false;
        private boolean onion      = false;
        private String sauce       = "none";
        private int extraPatties   = 0;

        public Builder(String size, String patty) {
            this.size  = size;
            this.patty = patty;
        }

        // FIX 2: Har method apna naam clearly batata hai — fluent API

        public Builder withCheese()           { this.cheese     = true;  return this; }
        public Builder withLettuce()         { this.lettuce    = true;  return this; }
        public Builder withTomato()          { this.tomato     = true;  return this; }
        public Builder withOnion()           { this.onion      = true;  return this; }
        public Builder withSauce(String s)   { this.sauce      = s;    return this; }
        public Builder extraPatties(int n)  { this.extraPatties = n;    return this; }

        // .build() — final validated object return karta hai

        public Burger build() {
            if (size == null || size.isEmpty())
                throw new IllegalStateException("Size required!");
            return new Burger(this);
        }
    }
}

public class Good_Design_Builder_Pattern {
    public static void main(String[] args) {

        // FIX 2: Crystal clear — padhke samajh aata hai kya ban raha hai

        Burger b1 = new Burger.Builder("large", "beef")
                .withCheese()
                .withTomato()
                .withSauce("bbq")
                .extraPatties(1)
                .build();
        System.out.println(b1);

        // FIX 3: Sirf cheese chahiye? Baaki fields touch hi mat karo

        Burger b2 = new Burger.Builder("small", "chicken")
                .withCheese()
                .build();
        System.out.println(b2);

        // Full loaded burger — sabkuch ek saath
        Burger b3 = new Burger.Builder("medium", "veggie")
                .withCheese().withLettuce().withTomato()
                .withOnion().withSauce("mayo").extraPatties(2)
                .build();
        System.out.println(b3);
    }
}

/*Output
Burger[large, beef, cheese=true, lettuce=false, tomato=true, onion=false, sauce=bbq, extra=1]
Burger[small, chicken, cheese=true, lettuce=false, tomato=false, onion=false, sauce=none, extra=0]
Burger[medium, veggie, cheese=true, lettuce=true, tomato=true, onion=true, sauce=mayo, extra=2]


Fix 1 — Sirf ek clean constructor
Telescoping constructors gone. Builder ke through hi Burger ban sakta hai — koi shortcut nahi.
Fix 2 — Self-documenting code
.withCheese().withTomato().withSauce("bbq") — padhke hi samajh aata hai, comments ki zaroorat nahi.
Fix 3 — Sirf jo chahiye woh specify karo
Optional fields ke default values hain. Cheese only burger? Sirf .withCheese() — baaki sab zero.*/