package org.example.ComparableandComparatorBoth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// The class itself implements Comparable
class Employee implements Comparable<Employee> {
    int id;
    String name;
    double salary;

    // ... Constructor, Getters, Setters ...

    // Defining the natural order (by id)
    @Override
    public int compareTo(Employee other) {
        return this.id - other.id; // Ascending order by ID
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(2, "Bob", 50000));
        employees.add(new Employee(1, "Alice", 60000));
        employees.add(new Employee(3, "Charlie", 40000));

        // Uses the natural order defined in compareTo
        Collections.sort(employees);

        System.out.println("Sorted by ID (Natural Order):");
        employees.forEach(e -> System.out.println(e.id + ": " + e.name));
        // Output: 1: Alice, 2: Bob, 3: Charlie
    }
}
