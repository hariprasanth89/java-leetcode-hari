package org.example.leetcode.mediam.twopointer;

import java.util.Arrays;

public class Three3SumClosest {



    public int threeSumClosestLeetcode(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize closest sum with the sum of the first three elements
        //int closestNum = Integer.MAX_VALUE / 2;
        for(int i = 0; i < nums.length -2; i++){
            int left = i +1;
            int right = nums.length -1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target - sum) < Math.abs(target - closestSum)){
                    closestSum = sum;
                }
                if(sum < target){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestSum;
    }

    // Brute force approach for 3Sum Closest
    // Time Complexity: O(n^3) - three nested loops
    // Space Complexity: O(1) - no extra space used
    public int threeSumClosestBruteForce(int[] nums, int target) {
        // Handle edge cases: if array is null or has less than 3 elements, return -1 (or throw an exception)
        if (nums == null || nums.length < 3) {
            return -1; // Or throw IllegalArgumentException
        }

        // Initialize closestSum with the sum of the first three elements
        int closestSum = nums[0] + nums[1] + nums[2];
        // Initialize minDiff with the absolute difference between closestSum and target
        int minDiff = Math.abs(closestSum - target);
        // Get the length of the array
        int n = nums.length;

        // Iterate through all possible combinations of three numbers
        // First number
        for (int i = 0; i < n - 2; i++) {
            // Second number
            for (int j = i + 1; j < n - 1; j++) {
                // Third number
                for (int k = j + 1; k < n; k++) {
                    // Calculate the current sum
                    int currentSum = nums[i] + nums[j] + nums[k];
                    // Calculate the absolute difference between currentSum and target
                    int currentDiff = Math.abs(currentSum - target);

                    // If the current difference is smaller than minDiff
                    if (currentDiff < minDiff) {
                        // Update minDiff
                        minDiff = currentDiff;
                        // Update closestSum
                        closestSum = currentSum;
                    }
                }
            }
        }
        // Return the closest sum found
        return closestSum;
    }

    public int threeSumClosest(int[] nums, int target) {
        // Handle edge cases: if array is null or has less than 3 elements, return -1 (or throw an exception)
        if (nums == null || nums.length < 3) return -1; // Or throw IllegalArgumentException

        // Sort the array to use the two-pointer technique. This is crucial for optimization.
        // Time Complexity for sorting: O(n log n)
        Arrays.sort(nums);

        // Initialize closestSum with the sum of the first three elements
        int closestSum = nums[0] + nums[1] + nums[2];
        // Initialize minDiff with the absolute difference between closestSum and target
        int minDiff = Math.abs(closestSum - target);
        // Get the length of the array
        int n = nums.length;

        // Iterate through the array with the first pointer 'i'
        // We go up to n-2 because we need at least two more elements (left and right)
        for (int i = 0; i < n - 2; i++) {
            // Initialize two pointers: 'left' starting after 'i', and 'right' at the end of the array
            int left = i + 1;
            int right = n - 1;

            // While the left pointer is less than the right pointer
            while (left < right) {
                // Calculate the current sum of the three numbers
                int sum = nums[i] + nums[left] + nums[right];
                // Calculate the absolute difference between the current sum and the target
                int currentDiff = Math.abs(sum - target);

                // If the current difference is smaller than minDiff
                if (currentDiff < minDiff) {
                    // Update minDiff
                    minDiff = currentDiff;
                    // Update closestSum
                    closestSum = sum;
                }

                // If the current sum is exactly equal to the target, we found the closest sum
                // and it's the target itself, so we can return immediately.
                if (sum == target) {
                    return closestSum;
                }
                // If the current sum is less than the target, we need a larger sum.
                // Move the left pointer to the right to increase the sum.
                if (sum < target) {
                    left++;
                }
                // If the current sum is greater than the target, we need a smaller sum.
                // Move the right pointer to the left to decrease the sum.
                else { // sum > target
                    right--;
                }
            }
        }
        // Return the closest sum found after checking all combinations
        return closestSum;
    }

    // Optimized solution using Two Pointers
    // Time Complexity: O(n^2) - O(n log n) for sorting + O(n^2) for two-pointer iteration
    // Space Complexity: O(1) - if sorting is in-place, otherwise O(log n) or O(n) depending on sort implementation
    public int threeSumClosestOptimized(int[] nums, int target) {
        // Handle edge cases: if array is null or has less than 3 elements, return -1 (or throw an exception)
        if (nums == null || nums.length < 3) return -1; // Or throw IllegalArgumentException

        // Sort the array to enable the two-pointer approach
        Arrays.sort(nums);

        // Initialize closestSum with the sum of the first three elements
        int closestSum = nums[0] + nums[1] + nums[2];
        // Initialize minDiff with the absolute difference between closestSum and target
        int minDiff = Math.abs(closestSum - target);
        // Get the length of the array
        int n = nums.length;

        // Iterate through the array with the first pointer 'i'
        for (int i = 0; i < n - 2; i++) {
            // Initialize two pointers: 'left' starting after 'i', and 'right' at the end of the array
            int left = i + 1;
            int right = n - 1;

            // While the left pointer is less than the right pointer
            while (left < right) {
                // Calculate the current sum of the three numbers
                int sum = nums[i] + nums[left] + nums[right];
                // Calculate the absolute difference between the current sum and the target
                int currentDiff = Math.abs(sum - target);

                // If the current difference is smaller than minDiff
                if (currentDiff < minDiff) {
                    // Update minDiff
                    minDiff = currentDiff;
                    // Update closestSum
                    closestSum = sum;
                }

                // If the current sum is exactly equal to the target, we found the closest sum
                // and it's the target itself, so we can return immediately.
                if (sum == target) {
                    return closestSum;
                }
                // If the current sum is less than the target, we need a larger sum.
                // Move the left pointer to the right to increase the sum.
                else if (sum < target) {
                    left++;
                }
                // If the current sum is greater than the target, we need a smaller sum.
                // Move the right pointer to the left to decrease the sum.
                else { // sum > target
                    right--;
                }
            }
        }
        // Return the closest sum found after checking all combinations
        return closestSum;
    }

    public static void main(String[] args) {
        Three3SumClosest solver = new Three3SumClosest();

        // Test cases for threeSumClosestBruteForce
        int[] nums1 = {-1, 2, 1, -4};
        int target1 = 1;
        System.out.println("Brute Force: Input: [-1, 2, 1, -4], Target: 1 -> Closest Sum: " + solver.threeSumClosestBruteForce(nums1, target1)); // Expected: 2

        int[] nums2 = {0, 0, 0};
        int target2 = 1;
        System.out.println("Brute Force: Input: [0, 0, 0], Target: 1 -> Closest Sum: " + solver.threeSumClosestBruteForce(nums2, target2)); // Expected: 0

        int[] nums3 = {1, 1, -1, -1, 3};
        int target3 = -1;
        System.out.println("Brute Force: Input: [1, 1, -1, -1, 3], Target: -1 -> Closest Sum: " + solver.threeSumClosestBruteForce(nums3, target3)); // Expected: -1

        // Test cases for threeSumClosest (Two Pointers)
        int[] nums4 = {-1, 2, 1, -4};
        int target4 = 1;
        System.out.println("Two Pointers: Input: [-1, 2, 1, -4], Target: 1 -> Closest Sum: " + solver.threeSumClosest(nums4, target4)); // Expected: 2

        int[] nums5 = {0, 0, 0};
        int target5 = 1;
        System.out.println("Two Pointers: Input: [0, 0, 0], Target: 1 -> Closest Sum: " + solver.threeSumClosest(nums5, target5)); // Expected: 0

        int[] nums6 = {1, 1, -1, -1, 3};
        int target6 = -1;
        System.out.println("Two Pointers: Input: [1, 1, -1, -1, 3], Target: -1 -> closest sum : " + solver.threeSumClosest(nums6, target6)); // Expected: -1);
    }
}

