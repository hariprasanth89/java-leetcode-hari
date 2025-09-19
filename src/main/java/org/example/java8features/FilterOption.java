package org.example.java8features;

import org.example.comparator.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class FilterOption {
    public static void main(String[] args) {
        // filter all the event number from array list
        List<Integer> immutableListInteger = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result = new ArrayList<>(); // without stream api
        for(Integer num : listOfNumbers){
            if(num % 2 == 0){
               // System.out.println(num);
                result.add(num);
            }
        }
        result.forEach(System.out::println);


        // with Stream Api
        immutableListInteger.stream().filter(num -> num % 2 == 0).forEach(System.out::println);

        //  filter 2
        // Retrieve all the names which is start from A and it should contains duplicate
        List<String> listOfNames = List.of("hari", "ha", "ha","a", "bb", "aa", "cc");

        //listOfNames.stream().filter(name -> name.startsWith("h")).distinct().forEach(System.out::println);
        listOfNames.stream().filter(name -> name.startsWith("h")).forEach(System.out::println);


        // filter 3

        Employee employee = new Employee(111,"Hari", 10000D);
        Employee employee1 = new Employee(222,"aa", 20000D);
        Employee employee2 = new Employee(333,"bb", 30000D);
        Employee employee3 = new Employee(444,"cc", 40000D);
        Employee employee4 = new Employee(555,"dd", 50000D);
        Employee employee5 = new Employee(666,"ee", 60000D);

        //Stream.of(employee, employee1, employee2, employee3, employee4, employee5).filter(emp -> emp.getSalary() > 40000D).forEach(System.out::println);
        Arrays.asList(employee, employee1, employee2, employee3, employee4, employee5).stream().filter(emp -> emp.getSalary() < 20000D).forEach(System.out::println);
        List<Employee> listOfEmps = Arrays.asList(employee, employee1, employee2, employee3, employee4, employee5);
        listOfEmps.stream().filter(emp -> emp.getSalary() < 20000D).forEach(e -> System.out.println(e.getName()));
    }


}
