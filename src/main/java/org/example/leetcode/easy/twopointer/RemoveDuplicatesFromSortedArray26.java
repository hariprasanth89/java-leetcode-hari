package org.example.leetcode.easy.twopointer;

import java.util.*;

public class RemoveDuplicatesFromSortedArray26 {
    public int removeDuplicates(int[] nums) {
        // Brute force approach (less efficient for large arrays)
        // This approach uses an auxiliary data structure (a boolean array)
        // to keep track of seen elements.
        // Time complexity: O(n) for iterating, O(n) for copying, so O(n) overall.
        // Space complexity: O(n) for the 'seen' array.

        if (nums.length == 0) {
            return 0;
        }

        // Create a boolean array to mark seen elements.
        // Assuming numbers are non-negative and within a reasonable range.
        // For a general solution, a HashSet would be more appropriate.
        // Here, we'll assume the problem constraints allow for this.
        // Let's assume numbers are between 0 and 100 (common for LeetCode examples).
        // If numbers can be negative or very large, a HashSet<Integer> is better.
        boolean[] seen = new boolean[201]; // Adjust size based on problem constraints (e.g., -100 to 100)
        int k = 0; // Pointer for the modified array

        for (int num : nums) {
            // Adjust index for negative numbers if applicable (e.g., num + 100)
            int index = num + 100; // Example for range -100 to 100
            if (!seen[index]) {
                seen[index] = true;
                nums[k++] = num;
            }
        }
        return k;
    }
    // Optimized Solution - Two Pointers
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static int removeDuplicatesOptimized(int[] nums) {
        if (nums.length == 0) return 0;

        int uniquePointer = 0; // Points to the last unique element

        for (int current = 1; current < nums.length; current++) {
            // If current element is different from the last unique element
            if (nums[current] != nums[uniquePointer]) {
                uniquePointer++; // Move unique pointer forward
                nums[uniquePointer] = nums[current]; // Place the new unique element
            }
        }

        return uniquePointer + 1; // Length is pointer + 1
    }

    public int removeDuplicatesOptimized111(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[count] != nums[i]) {
                nums[++count] = nums[i];
            }
        }
        // Arrays.stream(nums).forEach(System.out::print); // For debugging, remove in final solution
        return ++count; // k is the length of the unique elements
    }

    // Brute Force Solution - Using extra space
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int removeDuplicatesBruteForce(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> uniqueSet = new HashSet<>();
        List<Integer> uniqueList = new ArrayList<>();

        // Add unique elements to set and list
        for (int num : nums) {
            if (!uniqueSet.contains(num)) {
                uniqueSet.add(num);
                uniqueList.add(num);
            }
        }

        // Copy unique elements back to original array
        for (int i = 0; i < uniqueList.size(); i++) {
            nums[i] = uniqueList.get(i);
        }

        return uniqueList.size();
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums3 = {1, 2, 3};
        int[] nums4 = {};
        int[] nums5 = {1, 1, 1, 1};

        // Test Brute Force
        System.out.println("=== Brute Force Solution ===");
        testSolution(nums1.clone(), "removeDuplicatesBruteForce");
        testSolution(nums2.clone(), "removeDuplicatesBruteForce");
        testSolution(nums3.clone(), "removeDuplicatesBruteForce");
        testSolution(nums4.clone(), "removeDuplicatesBruteForce");
        testSolution(nums5.clone(), "removeDuplicatesBruteForce");

        System.out.println("\n=== Optimized Solution ===");
        // Test Optimized
        testSolution(nums1.clone(), "removeDuplicatesOptimized");
        testSolution(nums2.clone(), "removeDuplicatesOptimized");
        testSolution(nums3.clone(), "removeDuplicatesOptimized");
        testSolution(nums4.clone(), "removeDuplicatesOptimized");
        testSolution(nums5.clone(), "removeDuplicatesOptimized");
    }

    public static void testSolution(int[] nums, String methodName) {
        RemoveDuplicatesFromSortedArray26 solution = new RemoveDuplicatesFromSortedArray26();
        int result;

        if (methodName.equals("removeDuplicatesBruteForce")) {
            result = solution.removeDuplicatesBruteForce(nums);
        } else {
            result = solution.removeDuplicatesOptimized(nums);
        }

        System.out.println("Original array: " + Arrays.toString(nums));
        System.out.println("New length: " + result);
        System.out.println(STR."First \{result} elements: \{Arrays.toString(Arrays.copyOfRange(nums, 0, result))}");
        System.out.println("---");
    }
}
