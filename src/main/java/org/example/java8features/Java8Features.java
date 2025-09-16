package org.example.java8features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Features {

    public static int getCallFun(){
        FunctionalInterfaceLearning functionalInterfaceLearning  = (a, b) -> {
            return a+b;
        };
        return functionalInterfaceLearning.add(5, 10);
    }


    public static void main(String[] args) {
        FunctionalInterfaceLearning functionalInterfaceLearning = (a, b) ->{
            return a+b;
        };
        System.out.println(getCallFun());
        System.out.println(functionalInterfaceLearning.add(5, 10));
        functionalProgrammingSample();
    }

    public static void functionalProgrammingSample() {
        // Example of using streams for functional programming
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filter even numbers, double them, and sum them up
        int sumOfDoubledEvenNumbers = numbers.stream()
                                            .filter(n -> n % 2 == 0) // Intermediate operation: filter
                                            .map(n -> n * 2)       // Intermediate operation: map
                                            .reduce(0, Integer::sum); // Terminal operation: reduce

        System.out.println("Sum of doubled even numbers: " + sumOfDoubledEvenNumbers);

        // Another example: collecting to a list
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        List<String> names2 = Arrays.asList("Alice", "Bob", "Charlie", "David");
        List<String> upperCaseNames = names.stream()
                                                    .map(String::toUpperCase)
                                                    .collect(Collectors.toList());
        System.out.println("Uppercase names: " + upperCaseNames);
        names.stream().filter(name -> name.length() < 3).forEach(System.out::println);
         List<String> res = new ArrayList<>();
         res.addAll(Stream.concat(names.stream(), names2.stream()).collect(Collectors.toList()));
         res.forEach(System.out::println);
    }

}
