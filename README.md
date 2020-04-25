# Java8
Java 8 concepts


### 1 Optional
  #### Empty Optional value
  We can create empty optional object using empty().

        Optional.empty();

  #### of()
  We can use using static method (of) to create Optional objects like

        Optional.of(1);
        Optional.of("alpha");
        Optional.of(employee);

  We cannot pass null value in of() method otherwise it will give NullPointerException

        Optional.of(null);    // NullPointerException

  #### ofNullable()
  We can use ofNullable() method if null value can come for an object

        Optional.ofNullable(null);

  #### orElse() and orElseGet()
  Its good to use orElse() or orElseGet() instead of get() because if the value is null
  then get() method will throw NullPointerException even if we used ofNullable.

        Optional<Double> d1 = Optional.ofNullable(d1);
        d1.orElse(2d);              // it will always compute even if the value is present
        d1.orElseGet(() -> 4d);     // It will only compute the else condition if value is
                                    // not present in d1
  #### isPresent()
  isPresent() is used to check the value is present or not

        Optional<List<Integer>> integers = Optional.of(Arrays.asList(1, 2, 3, 4));
        integer.isPresent();        // return true if value is not null

  #### ifPresent()
  ifPresent() takes a supplier, if optional value is present then perform that supplier

        integer.ifPresent(x -> System.out.println(x));

  #### orElseThrow()
  orElseThrow() it will throw an exception if optional value is not present

            Optional.of(value).orElseThrow(NullPointerException::new);

  #### Intermittent methods
  intermittent method like map, filter etc are also applicable in optional

        Optional.of(10).filter(x -> x > 7).isPresent();

  #### Stream of Optional
  stream() of optional value comes from Java9

        Stream<Integer> stream = Optional.of(4).stream();

  #### New changes coming in Java 9
  In Java 9 or() and ifPresentOrElse() method are also introduced


### 2 String Joiner
  String joiner is used to join multiple strings.

  In this we can pass delimiter, prefix and suffix

        StringJoiner joiner = new StringJoiner(",", "[", "]");

  We can merge 2 or more string joiners

       StringJoiner joiner3 =  joiner1.merge(joiner2);

  prefix and suffix will be ignored if they are not same in all the merged
  joiners in case we join multiple string Joiners.


### 3 Operators on Maps

  #### forEach:
  It will iterate over the map entry set.
  takes BiConsumer (key, value)

         cityCount.forEach((key,value) -> System.out.println(key + " : " + value));

  #### replaceAll:
  It will iterate over the entryset and apply bifunction on that
  takes BiFunction<? super K, ? super V, ? extends V>

         cityCount.replaceAll((key, value) -> {
                     if (key.length() > 6) {
                         return value * 3;
                     }
                     return value;
                 });

  #### computeIfAbsent:
  If the key passed to is not present then it will add that key with value that will be
  computed from function passed to it.
  takes key and Function<? super K, ? extends V>

        cityCount.computeIfAbsent("Punjab", x -> 20);

  #### compute
  It will take the key passed to it and pass the entryset of that key to the BuFunction which we
  pass as second paramenter and evaluated value will replace the current value in entryset.

  If the key passed to it is not present it will give NullPointerException
  takes key and BiFunction<? super K, ? super V, ? extends V>

        cityCount.compute("Haryana", (key,value) -> {
                    if(value >20) {
                        return value;
                    } else {
                        return 22;
                    }
                });

  #### computeIfPresent
  It is same as compute just it will first check the key is present in map or not. If present
  then only it will compute the BiFunction and change the entrySet in map. So it protects from
  Null pointer exception./
  takes key and BiFunction<? super K, ? super V, ? extends V>

        cityCount.computeIfPresent("Punjab",(key,val) -> {
                    if(val> 20) {
                        return val;
                    } else {
                        return 22;
                    }
                });

  #### getOrDefault
  takes Object key, V defaultValue

        cityCount.getOrDefault("Bihar", 50);

  #### merge
  takes key, value and BiFunction<? super V, ? super V, ? extends V>

        map1.forEach(
                        (key, val) -> map2.merge(key, val, (v1, v2) -> v2)
                );


### Functional Interface
Java 8 introduced @FunctionalInterface, an interface that has exactly one abstract method.

#### Unary Operator
UnaryOperator is a functional interface and it extends Function.The UnaryOperator takes one argument,
and returns a result of the same type of its arguments.


        UnaryOperator<String> uppercase = x -> x.toUpperCase();
        UnaryOperator<String> reverse = x -> new StringBuilder(x).reverse().toString();

We can work on single operator like

        String alpha = uppercase.apply("alpha");    // ALPHA

we can also merge 2 or more operator and can apply on a single value.

        String beta = uppercase.andThen(reverse).apply("beta");    // ATEB

#### Binary Operator
In Java 8, BinaryOperator is a functional interface and it extends BiFunction.The BinaryOperator takes two
arguments of the same type and returns a result of the same type of its arguments.

        BinaryOperator<Integer> sum = (x1,x2) -> x1+x2;
        sum.apply(2,5);

#### Function
In Java 8, Function is a functional interface; it takes an argument (object of type T) and returns an object
(object of type R). The argument and output can be a different type.

        Function<String,Integer> length = String::length;
        Function<Integer,Integer> square = x -> x*x;

In this also we can using chaining.

        length.andThen(square).apply("alpha");

#### BiFunction
In Java 8, BiFunction is a functional interface that takes 2 argument and return a value.

        BiFunction<String,String,Integer> totalLength = (x1,x2) -> x1.length() + x2.length();

        totalLength.apply("alpha","beta");


#### Predicate
In Java 8, Predicate is a functional interface, which accepts an argument and returns a boolean.
Usually, it used to apply in a filter for a collection of objects.

        Predicate<String> isLengthValid = str -> str.length() > 4;
        Predicate<String> isValidPrefix = str -> str.startsWith("A");

        isLengthValid.test("Alpha");   // true

        isLengthValid.test("beta");    // false

negate() will reverse the predicate response

        isLengthValid.negate().test("beta");   // true

We can chain predicate in 3 ways : Predicate.and(), Predicate.or()

For "Predicate.and()" both the predicate neads to return true for true value.

        isLengthValid.and(isValidPrefix).test("Alpha");

For "Predicate.or()" if any one of the predicate returns true then the expression will return true

        isLengthValid.or(isValidPrefix).test("beta");

#### BiPredicate
In Java 8, BiPredicate is a functional interface, which accepts two arguments and returns a boolean, basically
this BiPredicate is same with the Predicate, instead, it takes 2 arguments for the test

        BiPredicate<String, String> validValues = (str1,str2) -> str1.length() >= 4 && str2.length() >=4;

        validValues.test("Alpha","beta");   // true

#### Consumer
In Java 8, Consumer is a functional interface; it takes an argument and returns nothing.

        Consumer<String> print = System.out::println;

        print.accept("java");

We can  chain consumer as well


#### BiConsumer
In Java 8, BiConsumer is a functional interface; it takes two arguments and returns nothing.

        BiConsumer<Integer, Integer> addTwo = (x, y) -> System.out.println(x + y);
        addTwo.accept(1, 2);    // 3

#### Supplier
In Java 8, Supplier is a functional interface; it takes no arguments and returns a result.

        Supplier<LocalDateTime> s = () -> LocalDateTime.now();
        LocalDateTime time = s.get();

