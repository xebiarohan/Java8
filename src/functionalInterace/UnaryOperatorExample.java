package functionalInterace;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    public static void main(String[] args) {
        UnaryOperator<String> uppercase = x -> x.toUpperCase();

        UnaryOperator<String> reverse = x -> new StringBuilder(x).reverse().toString();


        String alpha = uppercase.apply("alpha");    // ALPHA

        String beta = uppercase.andThen(reverse).apply("beta");
        System.out.println(beta);    // ATEB
    }

}
