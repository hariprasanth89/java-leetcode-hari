package org.example.leetcode.easy.twopointer;

import java.util.HashSet;
import java.util.Set;

public class NumberOfArithmeticTriplets2367 {


    //  1. Brute-Force Solution (O(n3 ) Time Complexity)
    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        int n = nums.length;

        // Iterate through all possible first elements (i)
        for (int i = 0; i < n; i++) {
            // Iterate through all possible second elements (j) where j > i
            for (int j = i + 1; j < n; j++) {
                // Check the first difference condition
                if (nums[j] - nums[i] == diff) {
                    // If the first difference is correct, iterate through all possible third elements (k) where k > j
                    for (int k = j + 1; k < n; k++) {
                        // Check the second difference condition
                        if (nums[k] - nums[j] == diff) {
                            // Found a valid arithmetic triplet!
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }


    //2. Optimized Solution using a Set (O(n) Time Complexity)
    public int arithmeticTripletsOptimized(int[] nums, int diff) {
        int count = 0;

        // 1. Store all elements in a HashSet for O(1) lookups.
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        // 2. Iterate through each element as a potential first element (nums[i]) of a triplet.
        for (int num_i : nums) {
            // The required second element is num_j = num_i + diff
            int num_j = num_i + diff;
            // The required third element is num_k = num_i + 2 * diff
            int num_k = num_i + 2 * diff;

            // 3. Check if the required second and third elements exist in the set.
            // Since the original array is strictly increasing, if all three elements
            // (num_i, num_j, num_k) exist in the set, the index condition (i < j < k)
            // is automatically satisfied because num_i < num_j < num_k, which implies
            // their indices must follow i < j < k.
            if (numSet.contains(num_j) && numSet.contains(num_k)) {
                count++;
            }
        }

        return count;
    }
// Alternate Optimized Approach (Using Boolean Array)

    public int arithmeticTripletsAlternateOptimizedApproach (int[] nums, int diff) {
        int count = 0;

        // 1. Create a boolean array to act as a presence map.
        // Size is 201 to cover elements 0 through 200 (based on constraints).
        boolean[] seen = new boolean[201];

        // Pre-populate the presence map (O(n) time)
        for (int num : nums) {
            seen[num] = true;
        }

        // 2. Iterate through each element as a potential first element.
        for (int num_i : nums) {
            int num_j = num_i + diff;
            int num_k = num_i + 2 * diff;

            // 3. Check if the required elements exist in the map.
            // We must also ensure the indices are within the bounds of the array (0 to 200).
            // Since max num_i is 200, we only need to check if num_k <= 200.
            if (num_k <= 200 && seen[num_j] && seen[num_k]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        NumberOfArithmeticTriplets2367 solution = new NumberOfArithmeticTriplets2367();
//        Input Array: nums = [0, 1, 4, 6, 7, 10]
//
//        Difference: diff = 3
        // Test case 1
        int[] nums1 = {0, 1, 4, 6,7, 10};
        int diff1 = 3;
        System.out.println("Test Case 1: nums = [0, 1, 4, 6, 7, 10], diff = 3 -> Result: " + solution.arithmeticTripletsOptimized(nums1, diff1)); // Expected: 2
    }

}
