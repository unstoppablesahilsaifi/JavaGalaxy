package PracticeSet3;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveConsecutiveDuplicates {
    public static void main(String[] args) {
        //aaabbcca → abca
        String str="aaabbcca";
        StringBuilder output=new StringBuilder();
        output.append(str.charAt(0));
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)!=str.charAt(i-1)){
                output.append(str.charAt(i));
            }
        }

        System.out.println("output = " + output);

    }
}
