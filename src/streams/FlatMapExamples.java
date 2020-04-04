package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExamples {
    public static void main(String[] args) {
        //FlatMap is used to change stream of Collection of data to stream of data

        // List and Set example
        List<String> list1 = Arrays.asList("alpha","beta","gamma");
        List<String> list2  = Arrays.asList("i", "ii", "iii");


        List<String> collect = Stream
                .of(list1, list2)
                .flatMap(List::stream)
                .collect(Collectors.toList());



        // *******************************************************

        // Array flating Example
        String[] strings1 = {"alpha","beta","gamma"};
        String[] strings2 = {"i", "ii", "iii"};

        List<String> collect1 = Stream
                .of(strings1, strings2)
                .flatMap(x -> Arrays.stream(x))
                .collect(Collectors.toList());



        // *************************************************************
        //Primitive type Example

        int[] integers= {1,2,3,4,5,6,7};
        Stream.of(integers)
                .flatMapToInt(x -> Arrays.stream(x))
                .forEach(System.out::println);
    }
}
