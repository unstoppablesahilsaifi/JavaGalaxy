package StreamsCodingQuestions;

import java.util.Arrays;
import java.util.Comparator;

public class FindLargestWord {
    public static void main(String[] args) {
        String str = "I love Programming";
//        String[] tempArr = str.split(" ");
//
//        String largest = tempArr[0]; // pehle word se start
//
//        for (int i = 1; i < tempArr.length; i++) {
//            if (tempArr[i].length() > largest.length()) {
//                largest = tempArr[i];
//            }
//        }
//
//        System.out.println("Largest word = " + largest);
        String largest= Arrays.stream(str.split(" ")).max(Comparator.comparingInt(String::length)).orElse("");
        System.out.println("largest = " + largest);


    }
}
