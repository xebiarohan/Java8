package collectors;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsExample {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("alpha","beta","gamma");
        List<Double>  doubles = Arrays.asList(1.1,2.0,3.0,4.0,5.0,5.0);
        List<Integer> integers = Arrays.asList(1,2,3,4,5,6,6);

        //1. toList
        integers.stream().map(x -> x*x).takeWhile(x -> x <4).collect(Collectors.toList());


        //2. toSet
        integers.stream().map(x -> x*x).dropWhile(x -> x<2).collect(Collectors.toSet());

        //3. Specific collection
        integers.stream().filter(x -> x >2).collect(Collectors.toCollection(LinkedList::new));

        //4. Counting number of elements
        Long collect = integers.stream().filter(x -> x <4).collect(Collectors.counting());

        //5. minBy and  naturalOrder
        integers.stream().collect(Collectors.minBy(Comparator.naturalOrder()));

        //6. maxby and reverseOrder
        strings.stream().map(x -> x.length()).collect(Collectors.maxBy(Comparator.reverseOrder()));

        //7. partitioningBy
        Map<Boolean, List<String>> collect1 = strings.stream().collect(Collectors.partitioningBy(x -> x.length() > 2));

        //8. Unmodifiable map
        List<String> collect2 = strings.stream().collect(Collectors.toUnmodifiableList());


        //9. Unmodifiable set
        strings.stream().sorted().collect(Collectors.toUnmodifiableSet());

        //10. Joining with delimiter
        String collect3 = strings.stream().distinct().collect(Collectors.joining(","));

        //11. Joining with delimiter and prefix and suffix
        integers.stream().map(s -> s.toString()).collect(Collectors.joining(",","[","]"));

        //12. Averaging long
        integers.stream().collect(Collectors.averagingLong(x -> x * 2));

        //13. AveragingInt
        integers.stream().collect(Collectors.averagingInt(x -> x*2));

        //14. Averaging Double
        doubles.stream().collect(Collectors.averagingDouble(x -> x));


        //15. toMap
        strings.stream().collect(Collectors.toMap(Function.identity(),String::length));

        //16. removing duplicateValues from map
        strings.stream().collect(Collectors.toMap(Function.identity(),String::length,(i1,i2) -> i1));

        //17. summingInt
        Integer collect4 = strings.stream().collect(Collectors.summingInt(String::length));

        //18. Summing Long
        strings.stream().collect(Collectors.summingLong(String::length));

        //19. Summing Double
        doubles.stream().collect(Collectors.summingDouble(x ->x));

        //20. SummarizingDouble
        DoubleSummaryStatistics collect5 = doubles.stream().collect(Collectors.summarizingDouble(x -> x / 2));
        collect5.getAverage();
        collect5.getMax();
        collect5.getMin();
        collect5.getCount();
        collect5.getSum();


    }

}
