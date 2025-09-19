package org.example.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmpTesting {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
//        employees.add(new Employee(2, "Bob", 50000));
//        employees.add(new Employee(1, "Alice", 60000));
//        employees.add(new Employee(3, "Charlie", 40000));

        // Uses the natural order defined in compareTo
        Collections.sort(employees);

        System.out.println("Sorted by ID (Natural Order):");
        employees.forEach(e -> System.out.println(e.id + ": " + e.name));
        // Output: 1: Alice, 2: Bob, 3: Charlie
    }
}
