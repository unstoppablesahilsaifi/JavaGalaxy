package StreamsCodingQuestionsSet2;

import java.util.Arrays;
import java.util.List;

public class Basic1_SumOfEvenNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sumAll=list.stream().reduce(0,(a, b)-> a+b);
        System.out.println("sum of All Elements = " + sumAll);
        int evenSum=list.stream().filter(n->n%2==0).reduce(0,(a,b)->a+b);
        System.out.println("evenSum = " + evenSum);
    }
}
