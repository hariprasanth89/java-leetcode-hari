package org.example.walmart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArraysTesting2DMatrix {

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

        int[][] grid18 = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {2, 3, 4, 5, 6, 7, 8, 9, 10, 1},
                {3, 4, 5, 6, 7, 8, 9, 10, 1, 2},
                {4, 5, 6, 7, 8, 9, 10, 1, 2, 3},
                {5, 6, 7, 8, 9, 10, 1, 2, 3, 4},
                {6, 7, 8, 9, 10, 1, 2, 3, 4, 5},
                {7, 8, 9, 10, 1, 2, 3, 4, 5, 6},
                {8, 9, 10, 1, 2, 3, 4, 5, 6, 7},
                {9, 10, 1, 2, 3, 4, 5, 6, 7, 8},
                {10, 1, 2, 3, 4, 5, 6, 7, 8, 9},
        };
        differantWayPrint(grid18);
        //makeTwoDArrayFormat(enrollments1);
    }
    public static void differantWayPrint(int[][] sample){
        for(int row = 0; row < sample.length; row++){
            for(int col = 0; col < sample[row].length; col++){
                System.out.print(sample[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void makeTwoDArrayFormat(String[][] enrollments1) {
        Map<String, List<String>> stringListMap  = new HashMap<>();
        for (int i = 0; i < enrollments1.length; i++) {
            String studentId = enrollments1[i][0];
            String course = enrollments1[i][1];
            if (!stringListMap.containsKey(studentId)) {
                stringListMap.put(studentId, new ArrayList<>());
            }
            stringListMap.get(studentId).add(course);
        }
        System.out.println(stringListMap);
        displayTableFormat(stringListMap);
    }

    public static void displayTableFormat(Map<String, List<String>> studentEnrollments) {
        // Find the maximum length of student IDs and course names for formatting
        int maxIdLength = "Student ID".length();
        int maxCourseLength = "Courses".length();

        for (Map.Entry<String, List<String>> entry : studentEnrollments.entrySet()) {
            maxIdLength = Math.max(maxIdLength, entry.getKey().length());
            for (String course : entry.getValue()) {
                maxCourseLength = Math.max(maxCourseLength, course.length());
            }
        }

        // Print header
        String headerFormat = "| %-" + maxIdLength + "s | %-" + maxCourseLength + "s |%n";
        String separator = "+";
        for (int i = 0; i < maxIdLength + 2; i++) separator += "-";
        separator += "+";
        for (int i = 0; i < maxCourseLength + 2; i++) separator += "-";
        separator += "+%n";

        System.out.format(separator);
        System.out.format(headerFormat, "Student ID", "Courses");
        System.out.format(separator);

        // Print data
        for (Map.Entry<String, List<String>> entry : studentEnrollments.entrySet()) {
            String studentId = entry.getKey();
            List<String> courses = entry.getValue();

            // Print the first course on the same line as the student ID
            if (!courses.isEmpty()) {
                System.out.format(headerFormat, studentId, courses.get(0));
                // Print subsequent courses on new lines, aligned with the courses column
                for (int i = 1; i < courses.size(); i++) {
                    System.out.format(headerFormat, "", courses.get(i));
                }
            } else {
                System.out.format(headerFormat, studentId, "");
            }
            System.out.format(separator);
        }
    }

}
