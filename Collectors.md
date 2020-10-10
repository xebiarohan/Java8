# Collectors in Java

 Collectors is a final class that extends Object class. It provides reduction operations, such as accumulating elements into collections,
 summarizing elements according to various criteria, etc. Java Collectors class provides various methods to deal with elements.
 
 ## Different methods of Collectors
 
 Lets take few sample data to use
 
 ```java
         List<String> strings = Arrays.asList("alpha","beta","gamma");
         List<Double>  doubleValues = Arrays.asList(1.1,2.0,3.0,4.0,5.0,5.0);
         List<Integer> integers = Arrays.asList(1,2,3,4,5,6,6);
         List<Long> longValues = Arrays.asList(100l,200l,300l);
 ```
 
 ### toList
 It is used to accumulate elements into a list. It will create a new list (It will not change the current list).
 
 ```java
 integers.stream().map(x -> x*x).collect(Collectors.toList());
 ```
 
 ### toSet
 It is used to accumulate elements into a set, It will remove all the duplicate entries.
 
 ```java
integers.stream().map(x -> x*x).collect(Collectors.toSet()); 
 ```
 
 ### Specific collection
 We can accumulate data in any specific list or set as well.
 
 ```java
 integers.stream().filter(x -> x >2).collect(Collectors.toCollection(LinkedList::new));
 ```
 
 Here we are accumulating elements in linked list.
 
 
 ### Counting elements
 It will return the number of elements present in the computed collection.
 
 ```java
 Long collect = integers.stream().filter(x -> x <4).collect(Collectors.counting());
 ```
 
 ### Finding minimum value
 It will return the minimum value present in the list.
 
 ```java
 integers.stream().collect(Collectors.minBy(Comparator.naturalOrder())).get(); 
 
 strings.stream().collect(Collectors.minBy(Comparator.naturalOrder())).get();
 ```
 
 It will return 1 and alpha, as per the naturan order of integers and string. 
 
 We can reverse the order using reverseOrder() method
 
 ```java
 integers.stream().collect(Collectors.minBy(Comparator.reverseOrder())).get();
 
 strings.stream().collect(Collectors.minBy(Comparator.reverseOrder())).get();
 ```
 
We can have custom comparator for the user defined objects.


### Finding maximum value
It is similar to minimum value method, here we use maxBy() method to get the maximum value.

```java
 strings.stream().map(x -> x.length()).collect(Collectors.maxBy(Comparator.naturalOrder()));
```

All the comparator logic which were there in minBy also applies to maxBy.

### Partisioning a list
It is used to partisioning a list into 2 and adding 2 entries in the map, 1 that satisties a given condition and other which does not satisfies like sepearting odd
numbers from the list. So it will make 2 entries in the map, 1 with true as key and odd numbers as value and 2nd with false as key and even numbers as value.

```java
Map<Boolean, List<String>> collect1 = strings.stream().collect(Collectors.partitioningBy(x -> x.length() > 2));
```

Here we are seperating the strings with length gereater than 2 from the remaining strings.

### Creating unmodifiable list.
It is used to create a read-only list. Any try to make a change in this unmodifiable list will result in UnsupportedOperationException.

```java
List<String> collect2 = strings.stream().collect(Collectors.toUnmodifiableList());
```

### Creating unmodifiable set
It is used to create a read-only set. Any try to make a change in this unmodifiable set will result in UnsupportedOperationException.

```java
Set<String> readOnlySet = strings.stream().sorted().collect(Collectors.toUnmodifiableSet());
```

### Joining elements

Collectors can be used to create a string by joining all the elements of a collection, with or without any delimiter, suffix and prefix.

```java
String collect3 = strings.stream().distinct().collect(Collectors.joining(","));

integers.stream().map(s -> s.toString()).collect(Collectors.joining(",","[","]"));
```

In the first example we are joining string by passing a delimiter value (",") and in second we are passing the value of prefix and siffix.
Result will look like ->  alpha,beta,gamma and  [alpha,beta,gamma].


### Averaging long
Finds the average value from a collection of long values. 
NOTE : It will return a Double value not a long value.

```java
Double d1 = longValues.stream().collect(Collectors.averagingLong(x -> x * 2));
```

### Averaging int
Finds the average value from a collection of integer values

NOTE : It will also return a Double value not a int value.

```java
Double d2 = integers.stream().collect(Collectors.averagingInt(x -> x*2));
```

### Averaging Double
Finds the average value from a collection of double values.

```java
Double d3 = doubles.stream().collect(Collectors.averagingDouble(x -> x));
```

### Creating Map
We can create a map from the values of a collection

```java
Map<String,Integer>map = strings.stream().collect(Collectors.toMap(Function.identity(),String::length));
```

Here we created a map with list values as keys and the number of occurance of the value in the list as value.

### Handling duplicates entries of list while creating map

A list can contain duplicate values, So If we want to create a map out of list and want to use list values as keys of maps then we need to resolve the
duplicate keys. As a map only contains unique keys, we can use comparators to do that

```java
strings.stream().collect(Collectors.toMap(Function.identity(),String::length,(i1,i2) -> i1));
```

Here Function.identity() is pointing to the list value and i1, i2 are the values of the duplicate keys. We can keep a single value so, here we are selecting i1 but
we can compute anything using these two values like adding them, comparing and selection the greater one etc.

### Summing Integers
Finding the sum of all the integer values present in the list.Its not always the sum of the initial collection which we are using like in the below example we are
using the list of strings and first we are converting each string into an integer that is equal to its length and then adding all the lengths.

```java
Integer collect4 = strings.stream().collect(Collectors.summingInt(String::length));
```

or direct list value sum

```java
integers.stream().collect(Collectors.summingInt(x -> x));
```

### Summing Doubles
Similar to summing integers, just it is used for double values

```java
doubleValues.stream().collect(Collectors.summingDouble(x ->x));
```

### Summing Long
Same as the first two, used for adding long or int values. We can use summinglong() for int values as well but we cannot use summingInt() for long values.
It is based on the concept of typecasting, which data type can be cast in which one.

```java
longValues.stream().collect(Collectors.summingDouble(x ->x));
```

### Summarizing Integer
It gives all the major arthmatic operation values of the values present in the collection like average of all values, minimum value, maximum values,
count and sum of all values.

```java
IntegerSummaryStatistics collect5 = integers.stream().collect(Collectors.summarizingDouble(x -> x ));
```

now we can extracts different values using getter methods like:

```java
collect5.getAverage();
collect5.getMax();
collect5.getMin();
collect5.getCount();
collect5.getSum();
```

### GroupingBy method

GroupingBy is a advance method to create a map out of any other collection. It itself is a very vast topic which we will cover in next blog. SO here just for the
completion lets see few examples

```java
Map<Integer, List<String>> collect = strings.stream().collect(Collectors.groupingBy(String::length));
```

It will make the string lenght as key and list of strings of that length as value.

```java
        Map<Integer, LinkedList<String>> collect1 = strings.stream().collect(Collectors.groupingBy(String::length, Collectors.toCollection(LinkedList::new)));
```

Here we specified the type of list we want in the map (linkedlist).

For more information about the Collectors class please refer to the official documentation : https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html
