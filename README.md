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


