package Design_Patterns.Creational_Patterns.Abstract_Factory_Pattern;
/*
* 🤯 Simple samajh
👉 Factory kya karta tha?
→ Ek object deta tha

👉 Abstract Factory kya karta hai?
→ Ek poori family (group) of objects deta hai

*
* 🎯 Real-life Example
👉 UI Theme:

Light Theme:
           Light Button
           Light Checkbox
Dark Theme:
           Dark Button
           Dark Checkbox

👉 Tumhe ek theme select karna hai → uske saare components automatically milne chahiye
*/

/*📌 Problem (Without Abstract Factory)
Maan le tum ek UI Application bana rahe ho jo Windows aur MacOS dono pe chalni chahiye.
Har OS ke liye tumhe Button aur Checkbox banane hain.
*/
interface Button { void paint(); }
class WindowsButton implements Button {
    public void paint() { System.out.println("Windows Button"); }
}
class MacButton implements Button {
    public void paint() { System.out.println("Mac Button"); }
}

interface Checkbox { void paint(); }
class WindowsCheckbox implements Checkbox {
    public void paint() { System.out.println("Windows Checkbox"); }
}
class MacCheckbox implements Checkbox {
    public void paint() { System.out.println("Mac Checkbox"); }
}
public class Bad_Design_Abstract_Factory {
    public static void main(String[] args) {
        String os = "MAC";  // ya to WINDOWS ya MAC

        // 👇 Client khud object decide kar raha hai
        if (os.equals("WINDOWS")) {
            Button b = new WindowsButton();
            Checkbox c = new WindowsCheckbox();
            b.paint();
            c.paint();
        } else {
            Button b = new MacButton();
            Checkbox c = new MacCheckbox();
            b.paint();
            c.paint();
        }
    }
}
/*✅ Output (if os = "MAC")
Mac Button
Mac Checkbox

❌ Issues
Client ke andar if-else bada hota jaayega agar aur products aaye (Slider, Textbox, Menu, etc).
Har jagah client ko class names pata hone chahiye (WindowsButton, MacButton).
Tightly coupled ho gaya.*/