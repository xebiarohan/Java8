package collectors;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GroupingByExamples {
    public static void main(String[] args) {
        List<String> strings = List.of("1", "12", "123", "1234");


        // Grouping strings by length
        Map<Integer, List<String>> collect = strings
                .stream()
                .collect(Collectors.groupingBy(String::length));

        // Grouping by length and add values in custom collection
        Map<Integer, LinkedList<String>> collect1 = strings
                .stream()
                .collect(Collectors.groupingBy(String::length, Collectors.toCollection(LinkedList::new)));

        // Grouping by length and add in Custom map
        TreeMap<Integer, Set<String>> collect2 = strings
                .stream()
                .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));


        // Counting method in Grouping By
        TreeMap<Integer, Long> collect3 = strings
                .stream()
                .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));

        // Joining method in grouping By
        Map<Integer, String> collect4 = strings
                .stream()
                .collect(Collectors.groupingBy(String::length, Collectors.joining(",")));

        // Grouping and Filtering
        strings
                .stream()
                .collect(Collectors.groupingBy(String::length, Collectors.filtering(s -> !s.contains("2"), Collectors.toList())));

        // averagingInt, averagingDouble and averagingLong

        strings
                .stream()
                .collect(Collectors.groupingBy(String::length,
                        Collectors.averagingInt(x -> Integer.parseInt(x)*12)));

        // SummingInt, SummingDouble and SummingLong
        Map<Integer, Integer> collect5 = strings
                .stream()
                .collect(Collectors.groupingBy(String::length,
                        Collectors.summingInt(x -> Integer.parseInt(x) * 2)));

        // MinBy and MaxBy
        strings
                .stream()
                .collect(Collectors.groupingBy(String::length,
                        Collectors.maxBy(Comparator.comparing(String::toUpperCase))));

        // GroupingByConncurrent
        ConcurrentMap<Integer, List<String>> collect6 = strings
                .parallelStream()
                .collect(Collectors.groupingByConcurrent(String::length, Collectors.toList()));

    }
}
