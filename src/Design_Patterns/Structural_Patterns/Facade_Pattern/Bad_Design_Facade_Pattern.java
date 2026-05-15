package Design_Patterns.Structural_Patterns.Facade_Pattern;
/*
👉 Facade pattern ka kaam hota hai:
Complex system ko simplify karna by providing one simple interface.

Matlab:
Andar bahut saari classes/system ho sakte hain
User ko sirf ek simple entry point dikhega
🧠 Real-life Example

🎬 Movie dekhni hai TV pe
Normally:

TV ON karo
Sound system ON
OTT app kholo
Internet connect
Brightness set
Movie play

😵 Bahut steps
👉 Facade kya karega?

Bas:
watchMovie();

Aur andar sab automatically ho jayega.

🎯 One-line Definition
Facade Pattern provides a simplified interface to a complex subsystem.*/

class TV_Bad_Design {
    void on() {
        System.out.println("TV ON");
    }
}

class SoundSystem_Bad_Design {
    void on() {
        System.out.println("Sound System ON");
    }
}

class OTT_Bad_Design {
    void openApp() {
        System.out.println("Netflix Opened");
    }
}

class Internet_Bad_Design {
    void connect() {
        System.out.println("Internet Connected");
    }
}
public class Bad_Design_Facade_Pattern {
    public static void main(String[] args) {

        TV_Bad_Design tv = new TV_Bad_Design();
        SoundSystem_Bad_Design sound = new SoundSystem_Bad_Design();
        OTT_Bad_Design ott = new OTT_Bad_Design();
        Internet_Bad_Design internet = new Internet_Bad_Design();

        tv.on();
        sound.on();
        internet.connect();
        ott.openApp();

        System.out.println("Movie Started");
    }
}

/*❗ Problem WITHOUT Facade

Client ko:

saari classes pata honi chahiye
sequence pata hona chahiye
complexity handle karni padti hai

Tightly coupled system ❌*/