package functionalInterace;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<String,Integer> length = String::length;

        Function<Integer,Integer> square = x -> x*x;


        length.andThen(square).apply("alpha");


        BiFunction<String,String,Integer> totalLength = (x1,x2) -> x1.length() + x2.length();

        totalLength.apply("alpha","beta");
    }
}
