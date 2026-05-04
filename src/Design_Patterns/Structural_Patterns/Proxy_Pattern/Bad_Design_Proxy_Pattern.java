package Design_Patterns.Structural_Patterns.Proxy_Pattern;
/*Proxy Pattern kya hota hai?

👉 Proxy pattern me:
Original object ke access ke beech me ek “middle layer” hoti hai.

Ye middle object:
access control karta hai
lazy loading karta hai
security/checks lagata hai
logging/caching kar sakta hai
🧠 Real-life Example

🎬 Netflix Premium
Tum directly movie server access nahi karte.

Pehle:
login check
subscription check
permissions check

👉 Ye sab Proxy karta hai.
Fir original service call hoti hai.
🎯 One-line Definition
Proxy Pattern provides a placeholder/surrogate object to control access to the real object.

❌ WITHOUT Proxy (Problem)
Maan lo:
Ek VideoService hai
Direct access mil raha hai sabko*/

interface VideoService_Bad{
    void playVideo();
}
class RealVideo implements VideoService_Bad{
    public void playVideo(){
        System.out.println("Playing premium video");
    }
}
public class Bad_Design_Proxy_Pattern {
    public static void main(String[] args) {
        VideoService_Bad videoService_bad=new RealVideo();
        videoService_bad.playVideo();
    }
}


/*❗ Problem WITHOUT Proxy

Ab issue:

Koi bhi access kar raha
No security
No authentication
No logging

Direct original object expose ho gaya ❌*/