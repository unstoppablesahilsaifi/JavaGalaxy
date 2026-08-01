package DSA.Stack;

import java.util.Stack;

public class Part4_ReverseAStringUsingStack {
    public static void main(String[] args) {
        String str="Sahil";
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<str.length();i++){
            stack.push(str.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        // Pop all characters


        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }
}

