package org.example.leetcode.mediam.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Three3Sum15 {

    // Brute Force Approach
    // Time Complexity: O(N^3)
    // Space Complexity: O(N) for the HashSet to store unique triplets
    public List<List<Integer>> threeSumBruteForce(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;

        // Sort the array to handle duplicates easily and ensure triplets are in non-decreasing order
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) { // Iterate through the array to fix the first number. We need at least two more elements after 'i' for 'j' and 'k'.
            for (int j = i + 1; j < n - 1; j++) { // Iterate from the next element to fix the second number. We need at least one more element after 'j' for 'k'.
                for (int k = j + 1; k < n; k++) { // Iterate from the next element to fix the third number.
                    if (nums[i] + nums[j] + nums[k] == 0) { // Check if the sum of the three numbers is zero.
                        result.add(Arrays.asList(nums[i], nums[j], nums[k])); // Add the triplet to the result set.
                    }
                }
            }
        }
        return new ArrayList<>(result); // Convert the set to a list and return.
    }

    // Optimized Approach (Two-Pointer)
    // Time Complexity: O(N^2) - Sorting takes O(N log N), and the two-pointer approach takes O(N^2)
    // Space Complexity: O(N) for the result list (or O(log N) to O(N) for sorting depending on implementation)
    public List<List<Integer>> threeSum(int[] nums) {
        // The problem asks for all unique triplets, and each triplet is a list of three integers.
        // Since there can be multiple such triplets, we need a List to hold these individual List<Integer> triplets.
//        The outer list (List<List<Integer>>) collects all the unique triplets found in the array.
//                The inner list (List<Integer>) represents a single triplet of numbers that sum to zero.
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // 1. Sort the array
        Arrays.sort(nums);

        // Iterate through the array, fixing the first element
        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate elements for the first number
            // This ensures that we don't process the same triplet multiple times
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1; // Pointer for the second number
            int right = n - 1; // Pointer for the third number

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Found a triplet that sums to zero
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate elements for the second number
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicate elements for the third number
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++; // Move to the next unique second number
                    right--; // Move to the next unique third number
                } else if (sum < 0) {
                    left++; // Sum is too small, need a larger second number
                } else { // sum > 0
                    right--; // Sum is too large, need a smaller third number
                }
            }
        }
        return result;
    }


    public List<List<Integer>> threeSumOptimize(int[] nums) {
        if (nums.length < 3 || nums == null)  return new ArrayList<>();

        // sort the elements
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        // Now fix the first element and find the other two elements
        for (int i = 0; i < nums.length - 2; i++) {
            // find the other two elements using two sum approach
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    // Add the set and move to find other triplets
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0){
                    left++;
                } else {
                    right--;
                }
            }
        }
return new ArrayList<>(result);
    }



    public static void main(String[] args) {

        Three3Sum15 solution = new Three3Sum15();

        //******************************//

        solution.threeSumOptimize(new int[]{-1, 0, 1, 2, -1, -4});



        //******************************//


        // Test cases for threeSumBruteForce
        System.out.println("--- Brute Force Approach ---");
        int[] nums1_bf = {-1, 0, 1, 2, -1, -4};
        System.out.println("Input: " + Arrays.toString(nums1_bf));
        System.out.println("Output: " + solution.threeSumBruteForce(nums1_bf)); // Expected: [[-1, 0, 1], [-1, -1, 2]] (order might vary)

        int[] nums2_bf = {0, 1, 1};
        System.out.println("Input: " + Arrays.toString(nums2_bf));
        System.out.println("Output: " + solution.threeSumBruteForce(nums2_bf)); // Expected: []

        int[] nums3_bf = {0, 0, 0};
        System.out.println("Input: " + Arrays.toString(nums3_bf));
        System.out.println("Output: " + solution.threeSumBruteForce(nums3_bf)); // Expected: [[0, 0, 0]]

        int[] nums4_bf = {};
        System.out.println("Input: " + Arrays.toString(nums4_bf));
        System.out.println("Output: " + solution.threeSumBruteForce(nums4_bf)); // Expected: []

        int[] nums5_bf = {1, 2, 3};
        System.out.println("Input: " + Arrays.toString(nums5_bf));
        System.out.println("Output: " + solution.threeSumBruteForce(nums5_bf)); // Expected: []

        int[] nums6_bf = {-2, 0, 1, 1, 2};
        System.out.println("Input: " + Arrays.toString(nums6_bf));
        System.out.println("Output: " + solution.threeSumBruteForce(nums6_bf)); // Expected: [[-2, 0, 2], [-2, 1, 1]]

        System.out.println("\n--- Optimized Approach (Two-Pointer) ---");
        int[] nums1_opt = {-1, 0, 1, 2, -1, -4};
        System.out.println("Input: " + Arrays.toString(nums1_opt));
        System.out.println("Output: " + solution.threeSum(nums1_opt)); // Expected: [[-1, -1, 2], [-1, 0, 1]] (order might vary)

        int[] nums2_opt = {0, 1, 1};
        System.out.println("Input: " + Arrays.toString(nums2_opt));
        System.out.println("Output: " + solution.threeSum(nums2_opt)); // Expected: []

        int[] nums3_opt = {0, 0, 0};
        System.out.println("Input: " + Arrays.toString(nums3_opt));
        System.out.println("Output: " + solution.threeSum(nums3_opt)); // Expected: [[0, 0, 0]]

        int[] nums4_opt = {};
        System.out.println("Input: " + Arrays.toString(nums4_opt));
        System.out.println("Output: " + solution.threeSum(nums4_opt)); // Expected: []

        int[] nums5_opt = {1, 2, 3};
        System.out.println("Input: " + Arrays.toString(nums5_opt));
        System.out.println("Output: " + solution.threeSum(nums5_opt)); // Expected: []

        int[] nums6_opt = {-2, 0, 1, 1, 2};
        System.out.println("Input: " + Arrays.toString(nums6_opt));
        System.out.println("Output: " + solution.threeSum(nums6_opt)); // Expected: [[-2, 0, 2], [-2, 1, 1]]

        int[] nums7_opt = {-1, 0, 1, 0};
        System.out.println("Input: " + Arrays.toString(nums7_opt));
        System.out.println("Output: " + solution.threeSum(nums7_opt)); // Expected: [[-1, 0, 1]]

    }
}
