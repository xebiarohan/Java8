package streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsInCollections {
    public static void main(String[] args) {
        // Stream in List

        Arrays.asList(1,2,3,4,5,6)
                .stream()
                .map(x -> x*2)
                .sorted()
                .forEach(System.out::println);
    // Output :
    //        2
    //        4
    //        6
    //        8
    //        10
    //        12

        // Stream in set

        Set<String> set = new HashSet();
        set.add("x1");
        set.add("x3");
        set.add("x2");

        Set<String> updatedValues = set.stream()
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toSet());

        System.out.println(updatedValues);
        // output : [X1, X2, X3]
    }
}
