package optional;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalExamples {

    public static void main(String[] args) throws Exception {
        // Empty Optional Object
        Optional<String> empty = Optional.empty();
        empty.isPresent();          // false


        // Ways of creating Optional object
        String str = "alpha";
        Optional<String> alpha = Optional.of(str);
        int i = 1;
        Optional<Integer> integer = Optional.of(1);  //  Convert to wrapper class Integer

    //**************************************************************************
        // Null value

        Double d = null;
     //   Optional.of(d);   // NullPointer Exception will come

        Optional<Double> d1 = Optional.ofNullable(d);
    //*****************************************************************************
        // How to get value and set default Value

    //    System.out.println(d1.get());   // this will also give NullPointerException

        d1.orElse(2d);        // it will always compute even if the value is present
        d1.orElseGet(() -> 4d);     // It will only compute the else condition if value is
                                    // not present in d1

    //**********************************************************************************

        //Checking Value presence

        Optional<List<Integer>> integers = Optional.of(Arrays.asList(1, 2, 3, 4));
        integer.isPresent();        // return true if value is not null

        // In Java 11 reverse of isPresent Comes
        //integer.isEmpty()

    //****************************************************************************************

        // Conditional Operator

        integer.ifPresent(x -> System.out.println(x));

        // In Java 9 extended Conditional Operator added in Optional

        integers.ifPresentOrElse(x -> System.out.println(x), OptionalExamples::sampleMethod);


    //*****************************************************************************************
        // Exceptional Handling

        String str3 = "beta";
        Optional.of(str3).orElseThrow(NoSuchElementException::new);

    //********************************************************************************************
        // Filtering of data
       Integer integer1 = 10;
       Optional.of(integer1).filter(x -> x > 7).isPresent();

    //********************************************************************************************
        // Map operator on Optional
        String string = "gamma";

        Optional.of(string).map(x -> x.length()).orElse(2);

    //********************************************************************************************
        //FlatMap operator
        Optional<String> stringOptional = Optional.of("alpha");
        Optional<Optional<String>> stringOptional1 = Optional.of(stringOptional); //nested Optional

        Optional<String> stringOptional2 = stringOptional1.flatMap(x -> x);  // same as stringOptional

    //********************************************************************************************
        // Stream of Optional
        Stream<Integer> stream = Optional.of(4).stream();
    }


    public static void sampleMethod() {
    }
}
