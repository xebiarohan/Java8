package streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsInCollections {
    public static void main(String[] args) {
      //   Stream in List

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

   // ***************************************************************************************

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

     // ********************************************************************************************

     //Stream in Map

     Map<Integer,String> map = new HashMap();
     map.put(1,"Apple");
     map.put(2,"Mango");
     map.put(3,"Guava");

     //Stream on map keys
        map.keySet()
                .stream()
                .filter(key -> key%2 == 0)
                .forEachOrdered(key -> System.out.println(map.get(key)));

     // Stream on map values
        long fruits = map.values()
                .stream()
                .count();

        // Stream on Map entries

        map.entrySet()
            .stream()
                .filter(fruit -> fruit.getValue().startsWith("M"))
                .forEach(System.out::println);





    }
}
