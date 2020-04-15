package maps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

public class SortingExamples {
    public static void main(String[] args) {
        sorting();
    }


    public static void sorting() {
        final Map<String,Integer> cityCount = new HashMap<>();

        cityCount.put("Haryana",20);
        cityCount.put("Maharastra",40);
        cityCount.put("Gujrat",25);
        cityCount.put("Jammu&Kashmir",18);

        LinkedHashMap<String, Integer> sortedCities = cityCount.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        cityCount.entrySet()
                .stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2) -> e1,LinkedHashMap::new));

    }
}
