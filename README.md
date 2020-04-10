# Java8
Java 8 concepts


1. Optional

    We can create empty optional object using Optional.empty().

    We can use using static method (of) to create Optional objects like :
        Optional.of(1);
        Optional.of("alpha");
        Optional.of(employee);

    We cannot pass null value in of method otherwise it will give nullPointerException

    We can use ofNullable() method if null value can come for an object
        Optional.ofNullable(null);

    Its good to use orElse() or orElseGet() instead of get() because if the value is null
    then get() method will throw NullPointerException even if we used ofNullable.

    isPresent() is used to check the value is present or not

    ifPresent() takes a supplier, if optional value is present then perform that supplier

    orElseThrow() it will throw an exception if optional value is not present
            Optional.of(value).orElseThrow(NullPointerException::new);

    intermittent method like map, filter etc are also applicable in optional

    stream() of optional value comes from Java9
        Stream<Integer> stream = Optional.of(4).stream();

    In Java 9 or() and ifPresentOrElse() method are also introduced


2 String Joiner
    String joiner is used to join multiple strings.

    In this we can pass delimiter, prefix and suffix
        StringJoiner joiner = new StringJoiner(",", "[", "]");

    We can merge 2 or more string joiners
       StringJoiner joiner3 =  joiner1.merge(joiner2);

    prefix and suffix will be ignored if they are not same in all the merged
    joiners in case we join multiple string Joiners.
