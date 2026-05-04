package Design_Patterns.Structural_Patterns.Proxy_Pattern;
/*Ab hum ek Proxy banayenge jo:

access control karega
premium user check karega*/


//Step 1: Common Interface
interface VideoService {
    void playVideo();
}

//Step 2: Real Service
class RealVideoService implements VideoService {

    public void playVideo() {
        System.out.println("Playing premium video...");
    }
}

//Step 3: Proxy Class
class VideoProxy implements VideoService {

    private RealVideoService realService;
    private boolean isPremiumUser;

    public VideoProxy(boolean isPremiumUser) {
        this.isPremiumUser = isPremiumUser;
    }

    public void playVideo() {

        if (isPremiumUser) {

            // Lazy loading
            if (realService == null) {
                realService = new RealVideoService();
            }

            realService.playVideo();

        } else {
            System.out.println("Access Denied! Buy Premium.");
        }
    }
}
public class Good_Design_Proxy_Pattern {
    public static void main(String[] args) {

        // Non-premium user
        VideoService user1 = new VideoProxy(false);
        user1.playVideo();

        System.out.println();

        // Premium user
        VideoService user2 = new VideoProxy(true);
        user2.playVideo();
    }
}
/*✅ Output
Access Denied! Buy Premium.

Playing premium video...
🔥 Internal Flow
Client
   ↓
Proxy
   ↓
Real Object

Client kabhi directly real object ko access nahi karta.*/