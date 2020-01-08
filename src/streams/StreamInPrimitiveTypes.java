package streams;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StreamInPrimitiveTypes {
    public static void main(String[] args) {
        // IntStream, LongStream and DoubleStream

        IntStream.of(1,2,3)
                .count();

        IntStream.range(1,4)
                .forEach(System.out::print);

        IntStream.range(1,5)
                .max();


        LongStream.of(1,2,3)
                .anyMatch(x -> x>2);

        DoubleStream.builder().add(2).add(3).add(5)
                .build()
                .skip(1)
                .limit(2)
                .boxed()
                .forEach(System.out::println);


    }
}
