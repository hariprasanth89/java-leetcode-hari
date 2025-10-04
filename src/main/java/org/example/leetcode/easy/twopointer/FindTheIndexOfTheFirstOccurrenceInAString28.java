package org.example.leetcode.easy.twopointer;

public class FindTheIndexOfTheFirstOccurrenceInAString28 {

    public int strStr(String haystack, String needle) {
        // Brute Force Solution
        // Time Complexity: O((haystack.length() - needle.length() + 1) * needle.length())
        // Space Complexity: O(1)
        if (needle.length() == 0) {
            return 0; // Empty needle is always found at index 0
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i; // Found the needle
            }
        }
        return -1; // Needle not found
    }

    public int strStrOptimized(String haystack, String needle) {
        // Optimized Solution (using built-in indexOf for simplicity,
        // or KMP algorithm for a more complex manual optimization)
        // For this problem, the most straightforward optimized approach in Java
        // is to use the String.indexOf() method.
        // Time Complexity: O(haystack.length() * needle.length()) in worst case (naive implementation),
        // but often much better due to optimized internal algorithms (e.g., Boyer-Moore, KMP variants).
        // Space Complexity: O(1)

        if (needle.length() == 0) {
            return 0;
        }

        return haystack.indexOf(needle);
    }
    public int strStrd(String haystack, String needle) {
        if(haystack.contains(needle)){
            return haystack.indexOf(needle);
        }
        return -1;
    }
    public int strStrdifferent(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i <= n - m; i++) {
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindTheIndexOfTheFirstOccurrenceInAString28 solution = new FindTheIndexOfTheFirstOccurrenceInAString28();
        String haystack = "sadbutsad";
        String needle = "sad";
        int result = solution.strStrdifferent(haystack, needle);
        System.out.println("Result: " + result);
        int resultOptimized = solution.strStrOptimized(haystack, needle);
        System.out.println("Optimized Result: " + resultOptimized);

    }
}
