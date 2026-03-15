package SOLID_Principles.LSP_3;
//Liskov Substitution Principle (LSP)
//Subclasses should be able to replace their parent class without breaking the program.
// Simple Language: Child class ko parent class ki jagah use kar sako
//aur program ka behaviour break na ho

/*Real Life Example
Socho:
Bird → parent class
Bird kar sakta hai:
fly()

Ab agar:
Penguin extends Bird
Penguin fly nahi kar sakta.
Agar Penguin ko force karo fly() implement karne ko → system break ho jayega.
Ye LSP violation hai.*/


public class Bad_Design_LSP {
}
