package org.example;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /*
    Problem Statement
Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.

Example:

Input: nums = [1, 2, 3, 1]

Output: true (because 1 appears twice)

Input: nums = [1, 2, 3, 4]

Output: false

Input: nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]

Output: true
     */
    /**
     * Brute-force solution to check for duplicates in an array.
     * Time Complexity: O(n^2) - due to nested loops.
     * Space Complexity: O(1) - no extra space used beyond input.
     *
     * @param nums The input integer array.
     * @return true if duplicates exist, false otherwise.
     */
    public static boolean containsDuplicateBruteForce(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false; // No duplicates possible with 0 or 1 element
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) { // Start j from i+1 to avoid checking same element or (a,b) and (b,a)
                if (nums[i] == nums[j]) {
                    return true; // Found a duplicate
                }
            }
        }
        return false; // No duplicates found after checking all pairs
    }

    /**
     * Optimized solution using a HashSet to check for duplicates in an array.
     * Time Complexity: O(n) - On average, each element is added/checked once.
     * Space Complexity: O(n) - In the worst case (all unique elements), the set stores all n elements.
     *
     * @param nums The input integer array.
     * @return true if duplicates exist, false otherwise.
     */
    public static boolean containsDuplicateOptimized(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false; // No duplicates possible with 0 or 1 element
        }

        Set<Integer> seenNumbers = new HashSet<>(); // Use a HashSet to store seen numbers

        for (int num : nums) {
            if (seenNumbers.contains(num)) {
                return true; // Found a duplicate
            }
            seenNumbers.add(num); // Add the number to the set if it's not a duplicate
        }
        return false; // No duplicates found
    }





    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Brute-force [1, 2, 3, 1] contains duplicate: " + containsDuplicateBruteForce(nums1)); // true

        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Brute-force [1, 2, 3, 4] contains duplicate: " + containsDuplicateBruteForce(nums2)); // false

        int[] nums3 = {};
        System.out.println("Brute-force [] contains duplicate: " + containsDuplicateBruteForce(nums3)); // false

        int[] nums4 = {7};
        System.out.println("Brute-force [7] contains duplicate: " + containsDuplicateBruteForce(nums4)); // false

        int[] nums5 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("Brute-force [1, 1, 1, 3, 3, 4, 3, 2, 4, 2] contains duplicate: " + containsDuplicateBruteForce(nums5)); // true



//        int[] nums1 = {1, 2, 3, 1};
//        System.out.println("Optimized [1, 2, 3, 1] contains duplicate: " + containsDuplicateOptimized(nums1)); // true
//
//        int[] nums2 = {1, 2, 3, 4};
//        System.out.println("Optimized [1, 2, 3, 4] contains duplicate: " + containsDuplicateOptimized(nums2)); // false
//
//        int[] nums3 = {};
//        System.out.println("Optimized [] contains duplicate: " + containsDuplicateOptimized(nums3)); // false
//
//        int[] nums4 = {7};
//        System.out.println("Optimized [7] contains duplicate: " + containsDuplicateOptimized(nums4)); // false
//
//        int[] nums5 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
//        System.out.println("Optimized [1, 1, 1, 3, 3, 4, 3, 2, 4, 2] contains duplicate: " + containsDuplicateOptimized(nums5)); // true
//


    }




}
