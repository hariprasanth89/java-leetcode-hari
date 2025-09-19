package org.example.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmpTesting {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(2, "Bob", 50000));
        employees.add(new Employee(1, "Alice", 60000));
        employees.add(new Employee(3, "Charlie", 40000));

        // Create a Comparator for custom ordering (by Salary)
        Comparator<Employee> salaryComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Double.compare(e1.salary, e2.salary); // Robust way to compare doubles
            }
        };

        // Use the custom comparator
        Collections.sort(employees, salaryComparator);

        System.out.println("Sorted by Salary:");
        employees.forEach(e -> System.out.println(e.salary + ": " + e.name));
        // Output: 40000: Charlie, 50000: Bob, 60000: Alice

        ///    ---------------////
        // Sort by Name using a Lambda
        Collections.sort(employees, (e1, e2) -> e1.name.compareTo(e2.name));

// Even simpler using Comparator.comparing
        Collections.sort(employees, Comparator.comparing(Employee::getName));
        Collections.sort(employees, Comparator.comparingDouble(Employee::getSalary)); // for doubles

// Reverse order
        Collections.sort(employees, Comparator.comparing(Employee::getSalary).reversed());

// Chaining (e.g., sort by Salary, and if equal, sort by Name)
        Collections.sort(employees, Comparator
                .comparingDouble(Employee::getSalary)
                .thenComparing(Employee::getName));
    }
}
