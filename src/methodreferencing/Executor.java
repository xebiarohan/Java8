package methodreferencing;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Executor {
    public static void main(String[] args) throws Exception {
        Person person = new Person();



        // Method reference using class instance
        Consumer<String> setFirstName = person::setFirstName;
        Consumer<Integer> setAge = person::setAge;
        Callable<String> getFirstName = person::getFirstName;


        // Method referencing using Class name
        BiFunction<String, String, String> getFullName = Person::getFullName;

        // Method referencing using Constructor
        PersonDetails details = Person::new;

        // Other examples
        List<String> strings = Arrays.asList("alpha", "beta", "gamma");
        strings.stream().map(String::toUpperCase).forEach(System.out::println);



        setAge.accept(12);
        setFirstName.accept("Rohan");
        System.out.println(getFirstName.call());

        String apply = getFullName.apply("Rohan", "Aggarwal");

        details.getDetails();
    }
}


interface PersonDetails{
    Person getDetails();
}
