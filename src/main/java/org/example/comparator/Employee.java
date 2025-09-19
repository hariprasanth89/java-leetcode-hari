package org.example.comparator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {// No longer needs to implement Comparable
    int id;
    String name;
    double salary;
    // ... Constructor, Getters, Setters ...
}
