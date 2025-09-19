package org.example.comparable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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