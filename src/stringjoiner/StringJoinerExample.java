package stringjoiner;

import java.util.StringJoiner;

public class StringJoinerExample {
    public static void main(String[] args) {

        // With Delimiter
        StringJoiner joiner1 = new StringJoiner(",");
        String string1 = joiner1.add("Red")
                .add("Green")
                .add("Blue")
                .toString();             // Red,Green,Blue

        // with delimiter, prefix and suffix
        StringJoiner joiner2 = new StringJoiner(",","[","]");
        String string2 = joiner2.add("Red")
                .add("Green")
                .add("Blue")
                .toString();             // [Red,Green,Blue]

        // Joining 2 StringJoiners
        String string3 = joiner1
                .merge(joiner2)
                .toString();          //Red,Green,Blue,Red,Green,Blue
                                      // If prefix and suffix are not same in both joiners then
                                      // they will be ignored in merged joiner
        System.out.println(string3);
    }
}
