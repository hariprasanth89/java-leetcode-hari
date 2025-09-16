package org.example.walmart;

import java.util.*;

public class SharedCoursesFinderWalmartInterview2nd {
    public static Map<String, List<String>> findSharedCoursesOptimized(String[][] enrollments) {
        // A map to store courses for each student. Using a Set ensures uniqueness.
        Map<String, Set<String>> studentCourses = new HashMap<>();

        // Step 1: Populate the studentCourses map from the input array.
        // This transforms the data into a more efficient structure for our purpose.
        for (String[] enrollment : enrollments) {
            String studentId = enrollment[0];
            String course = enrollment[1];
            // Get the set of courses for the current student, or create a new set if none exists.
            studentCourses.computeIfAbsent(studentId, k -> new HashSet<>()).add(course);
        }

        // A map to store the final result: shared courses for each student pair.
        Map<String, List<String>> sharedCourses = new HashMap<>();

        // Step 2: Iterate through all unique pairs of students and find shared courses.
        // We get a list of all unique student IDs.
        List<String> studentIds = new ArrayList<>(studentCourses.keySet());
        for (int i = 0; i < studentIds.size(); i++) {
            for (int j = i + 1; j < studentIds.size(); j++) {
                String student1 = studentIds.get(i);
                String student2 = studentIds.get(j);

                // Find the intersection of their course sets.
                Set<String> courses1 = studentCourses.get(student1);
                Set<String> courses2 = studentCourses.get(student2);

                List<String> commonCourses = new ArrayList<>();
                // Iterate over the smaller set for better performance.
                Set<String> smallerSet = courses1.size() < courses2.size() ? courses1 : courses2;
                Set<String> largerSet = courses1.size() < courses2.size() ? courses2 : courses1;

                for (String course : smallerSet) {
                    if (largerSet.contains(course)) {
                        commonCourses.add(course);
                    }
                }

// Java Map computeIfAbsent() Method compute() computeIfPresent() putIfAbsent()
                // Store the result in the output map. The key is a comma-separated string of IDs.
                sharedCourses.put(student1 + "," + student2, commonCourses);
            }
        }
        return sharedCourses;
    }

    // Brute-force approach for finding shared courses.
    // This method iterates through all possible pairs of students and then // This method iterates through all possible pairs of students
    // iterates through all courses of one student to check if the other student // and then iterates through all courses of one student
    // also has that course. // to check if the other student also has that course.
    public static Map<String, List<String>> findSharedCoursesBruteForce(String[][] enrollments) {
        // A map to store courses for each student. Using a Set ensures uniqueness.
        Map<String, Set<String>> studentCourses = new HashMap<>();

        // Step 1: Populate the studentCourses map from the input array.
        for (String[] enrollment : enrollments) {
            String studentId = enrollment[0];
            String course = enrollment[1];
            studentCourses.computeIfAbsent(studentId, k -> new HashSet<>()).add(course);
        }

        // A map to store the final result: shared courses for each student pair.
        Map<String, List<String>> sharedCourses = new HashMap<>();

        // Step 2: Iterate through all unique pairs of students and find shared courses.
        List<String> studentIds = new ArrayList<>(studentCourses.keySet());
        for (int i = 0; i < studentIds.size(); i++) {
            for (int j = i + 1; j < studentIds.size(); j++) {
                String student1 = studentIds.get(i);
                String student2 = studentIds.get(j);

                Set<String> courses1 = studentCourses.get(student1);
                Set<String> courses2 = studentCourses.get(student2);

                List<String> commonCourses = new ArrayList<>();

                // Brute-force intersection: iterate through all courses of student1
                // and check if student2 also has them.
                for (String course : courses1) {
                    if (courses2.contains(course)) {
                        commonCourses.add(course);
                    }
                }

                // Store the result in the output map.
                sharedCourses.put(student1 + "," + student2, commonCourses);
            }
        }
        return sharedCourses;
    }

    // Helper function to print the map in a readable format.
    public static void printMap(String label, Map<String, List<String>> map) {
        System.out.println(label + ":");
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println("  \"" + entry.getKey() + "\": " + entry.getValue());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[][] enrollments1 = {
                {"58", "Linear Algebra"},
                {"94", "Art History"},
                {"94", "Operating Systems"},
                {"17", "Software Design"},
                {"58", "Mechanics"},
                {"58", "Economics"},
                {"17", "Linear Algebra"},
                {"17", "Political Science"},
                {"94", "Economics"},
                {"25", "Economics"},
                {"58", "Software Design"},
        };

        String[][] enrollments2 = {
                {"0", "Advanced Mechanics"},
                {"0", "Art History"},
                {"1", "Course 1"},
                {"1", "Course 2"},
                {"2", "Computer Architecture"},
                {"3", "Course 1"},
                {"3", "Course 2"},
                {"4", "Algorithms"}
        };

        String[][] enrollments3 = {
                {"23", "Software Design"},
                {"3", "Advanced Mechanics"},
                {"2", "Art History"},
                {"33", "Another"},
        };

        // Test cases
        Map<String, List<String>> result1Optimized = findSharedCoursesOptimized(enrollments1);
        printMap("Optimized Result for enrollments1", result1Optimized);
        Map<String, List<String>> result1BruteForce = findSharedCoursesBruteForce(enrollments1);
        printMap("Brute-Force Result for enrollments1", result1BruteForce);

        Map<String, List<String>> result2Optimized = findSharedCoursesOptimized(enrollments2);
        printMap("Optimized Result for enrollments2", result2Optimized);
        Map<String, List<String>> result2BruteForce = findSharedCoursesBruteForce(enrollments2);
        printMap("Brute-Force Result for enrollments2", result2BruteForce);

        Map<String, List<String>> result3Optimized = findSharedCoursesOptimized(enrollments3);
        printMap("Optimized Result for enrollments3", result3Optimized);
        Map<String, List<String>> result3BruteForce = findSharedCoursesBruteForce(enrollments3);
        printMap("Brute-Force Result for enrollments3", result3BruteForce);
    }
}
