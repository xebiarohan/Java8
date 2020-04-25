package functionalInterace;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {
        Predicate<String> isLengthValid = str -> str.length() > 4;
        Predicate<String> isValidPrefix = str -> str.startsWith("A");

        isLengthValid.test("Alpha");   // true

        isLengthValid.test("beta");    // false


        // and chaining
        isLengthValid.and(isValidPrefix).test("Alpha");


        // or chaining
        isLengthValid.or(isValidPrefix).test("beta");


        // negate()
        isLengthValid.negate().test("beta");   // true


        BiPredicate<String, String> validValues = (str1,str2) -> str1.length() >= 4 && str2.length() >=4;

        validValues.test("Alpha","beta");   // true
    }
}
