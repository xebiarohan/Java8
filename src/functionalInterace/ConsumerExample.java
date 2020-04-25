package functionalInterace;

import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {
        Consumer<String> print = System.out::println;

        print.accept("java");
    }
}
