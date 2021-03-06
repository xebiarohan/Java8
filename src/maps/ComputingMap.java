package maps;

import java.util.HashMap;
import java.util.Map;

public class ComputingMap {

    public static void main(String[] args) {
         Map<String,Integer> cityCount = new HashMap<>();

        cityCount.put("Haryana",20);
        cityCount.put("Maharastra",40);
        cityCount.put("Gujrat",25);
        cityCount.put("Jammu&Kashmir",18);


        // forEach method
        cityCount.forEach((key,value) -> System.out.println(key + " : " + value));


        // replaceAll
        cityCount.replaceAll((key, value) -> {
            if (key.length() > 6) {
                return value * 3;
            }
            return value;
        });
        cityCount.forEach((key,value) -> System.out.println("Replace All Result "+key + " : " + value));


        // computeIfAbsent
        cityCount.computeIfAbsent("Punjab", x -> 20);
        cityCount.forEach((key,value) -> System.out.println("Compute If Absent "+ key + " : " + value));


        // compute
        cityCount.compute("Punjab", (key,value) -> {
            if(value >20) {
                return value;
            } else {
                return 22;
            }
        });
        cityCount.forEach((key,value) -> System.out.println("Compute "+ key + " : " + value));


        // ComputeIfPresent
        cityCount.computeIfPresent("Punjab",(key,val) -> {
            if(val> 20) {
                return val;
            } else {
                return 22;
            }
        });
        cityCount.forEach((key,value) -> System.out.println("ComputeIfPresent "+ key + " : " + value));


        // getOrDefault
        Integer biharCities = cityCount.getOrDefault("Bihar", 50);
        System.out.println(biharCities);


        // mergemap
        Map<Integer,Integer> map1 = new HashMap<>();
        map1.put(1,1);
        map1.put(2,2);
        map1.put(3,3);

        Map<Integer,Integer> map2 = new HashMap<>();
        map2.put(4,4);
        map2.put(5,5);
        map2.put(1,6);

        map1.forEach(
                (key, val) -> map2.merge(key, val, (v1, v2) -> v2)
        );

        map2.forEach((key,value) -> System.out.println("Merge Map "+ key + " : " + value));
    }


}
