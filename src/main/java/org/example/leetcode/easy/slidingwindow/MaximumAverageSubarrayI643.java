package org.example.leetcode.easy.slidingwindow;

import java.util.Arrays;

public class MaximumAverageSubarrayI643 {
    public double findMaxAverage(int[] nums, int k) {
        // Calculate the sum of the first 'k' elements to initialize the window sum.
        double windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        // Initialize maxAverage with the average of the first window.
        double maxAverage = windowSum / k;

        // Slide the window across the rest of the array.
        // 'i' represents the right end of the current window.
        for (int i = k; i < nums.length; i++) {
            // Add the new element entering the window (nums[i])
            // and subtract the element leaving the window (nums[i - k]).
            windowSum = windowSum + nums[i] - nums[i - k];
            // Update maxAverage if the current window's average is greater.
            maxAverage = Math.max(maxAverage, windowSum / k);
        }

        return maxAverage;
    }

    // Brute-force approach (for comparison, not efficient)
    public double findMaxAverageBruteForce(int[] nums, int k) {
        double maxAverage = -Double.MAX_VALUE; // Initialize with a very small number

        // Iterate through all possible starting positions of a subarray of length k.
        // The loop runs from index 0 up to nums.length - k.
        for (int i = 0; i <= nums.length - k; i++) {
            double currentSum = 0;
            // Calculate the sum of the current subarray of length k.
            for (int j = 0; j < k; j++) {
                currentSum += nums[i + j];
            }
            // Calculate the average of the current subarray.
            double currentAverage = currentSum / k;
            // Update maxAverage if the current average is greater.
            maxAverage = Math.max(maxAverage, currentAverage);
        }

        return maxAverage;
    }

    public double findMaxAverageDifferentApproach(int[] nums, int k) {
        double windowSum = 0;
        // Check for edge case
        if (nums.length < k) {
            System.out.println("Invalid: Window size is larger than array.");
            return -1;
        }
        for(int i = 0; i < k; i++){
            windowSum += nums[i];
        }

        double maxSum = windowSum;

        for(int i = k; i < nums.length; i++){
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum/k;
    }

    public double findMaxAverageDiff(int[] nums, int k) {
        // Step 1: Calculate the sum of the first window
        double windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        // Step 2: Initialize maxSum with the first window sum
        double maxSum = windowSum;

        // Step 3: Slide the window through the array
        for (int i = k; i < nums.length; i++) {
            // Remove the leftmost element and add the new right element
            windowSum = windowSum - nums[i - k] + nums[i];

            // Update maxSum if current window sum is larger
            maxSum = Math.max(maxSum, windowSum);
        }

        // Step 4: Return the maximum average
        return maxSum / k;
    }

    public static void main(String[] args) {
        MaximumAverageSubarrayI643 solution = new MaximumAverageSubarrayI643();

        // Test Case 1: Basic functionality
        int[] nums1 = {1, 12, -5, -6, 50, 3};
        int k1 = 4;
        double expected1 = 12.75;
        //double result1 = solution.findMaxAverage(nums1, k1);
        double result1 = solution.findMaxAverageDifferentApproach(nums1, k1);
        System.out.println("Test Case 1: nums = " + Arrays.toString(nums1) + ", k = " + k1 + ", Expected = " + expected1 + ", Result = " + result1);

        int[] nums2 = {5};
        int k2 = 1;
        double expected2 = 5.00000;
        //double result1 = solution.findMaxAverage(nums1, k1);
        double result2 = solution.findMaxAverageDifferentApproach(nums2, k2);
        System.out.println("Test Case 1: nums = " + Arrays.toString(nums2) + ", k = " + k2 + ", Expected = " + expected2 + ", Result = " + result2);

    }
}
