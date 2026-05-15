package Design_Patterns.Structural_Patterns.Facade_Pattern;
class TV {
    void on() {
        System.out.println("TV ON");
    }
}

class SoundSystem {
    void on() {
        System.out.println("Sound System ON");
    }
}

class OTT {
    void openApp() {
        System.out.println("Netflix Opened");
    }
}

class Internet {
    void connect() {
        System.out.println("Internet Connected");
    }
}

//Facade Class
class HomeTheaterFacade {

    private TV tv;
    private SoundSystem sound;
    private OTT ott;
    private Internet internet;

    public HomeTheaterFacade() {
        tv = new TV();
        sound = new SoundSystem();
        ott = new OTT();
        internet = new Internet();
    }

    public void watchMovie() {

        tv.on();
        sound.on();
        internet.connect();
        ott.openApp();

        System.out.println("Movie Started");
    }
}
public class Good_Design_Facade_Pattern {
    public static void main(String[] args) {

        HomeTheaterFacade facade = new HomeTheaterFacade();

        // Simple call
        facade.watchMovie();
    }

}
