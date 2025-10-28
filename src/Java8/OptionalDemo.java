package Java8;

import java.util.Optional;

class User{
    String name;
    public User(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
public class OptionalDemo {
    public static void main(String[] args) {
//        String str=null;
//        System.out.println("str.length() = " + str.length()); Null Pointer Exception aayga

//
//        Optional<T> ek generic class hai jo ek value ko wrap karti hai.
//        Agar value present hai → Optional me store hoti hai.
//        Agar value nahi hai → Optional.empty() return karta hai.
        User user=null;
        // Without Optional →  NullPointerException
        // System.out.println(user.getName());

        // With Optional →  Safe
        String name = Optional.ofNullable(user)
                .map(User::getName)
                .orElse("Guest User");

        System.out.println(name);



    }
}
