package functionalInterace;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
    public static void main(String[] args) {
        BinaryOperator<Integer> sum = (x1,x2) -> x1+x2;

        sum.apply(2,5);
    }
}
