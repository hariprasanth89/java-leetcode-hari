package org.example.leetcode.easy.slidingwindow;

import java.util.HashMap;
import java.util.Map;

import java.util.Arrays;

public class LongestHarmoniousSubsequence594 {

    // Optimized approach using sliding window
    // easy way to understand the problem
    public int findLHSDifferentApproach(int[] nums) {
        Arrays.sort(nums); // Sort the input array to enable the sliding window approach.
        int left = 0; // Initialize the left pointer of the sliding window.
        int max = 0; // Initialize the maximum length of a harmonious subsequence found so far.
        for (int i = 0; i < nums.length; i++) { // Iterate through the array with the right pointer 'i'.
            while (nums[i] - nums[left] > 1) { // While the difference between the current element and the left element is greater than 1,
                left++; // shrink the window from the left.
            }
            if (nums[i] - nums[left] == 1) { // If the difference is exactly 1, we have a harmonious subsequence.
                max = Math.max(max, i - left + 1); // Update the maximum length with the current window size.
            }
        }
        return max; // Return the maximum length found.
    }    // Optimized approach using sliding window

    // This approach is more robust for finding the longest harmonious subsequence
    // when the definition implies that the subsequence elements must be contiguous
    // in the sorted array, which is not strictly true for a "subsequence".
    // However, if we interpret "subsequence" as a collection of numbers from the array
    // that form a harmonious set, then the HashMap approach is generally more direct.
    // The sliding window here effectively finds the longest subarray where max - min <= 1.
    // If the problem implies a true subsequence (not necessarily contiguous in original array),
    // then the HashMap approach is more accurate.
    // Let's re-evaluate the problem statement: "a subsequence is harmonious if the difference
    // between its maximum value and its minimum value is exactly 1."
    // This means elements don't have to be contiguous. So the HashMap approach is generally preferred.
    // The sliding window approach here finds the longest *subarray* (after sorting)
    // where max - min <= 1, and then checks if max - min == 1.
    // This is a valid way to find the LHS if we consider the sorted array.
    public int findLHSSlidingWindow(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < nums.length; right++) {
            // Shrink the window from the left if the difference is greater than 1
            while (nums[right] - nums[left] > 1) {
                left++;
            }
            // If the current window forms a harmonious subsequence (difference is exactly 1)
            if (nums[right] - nums[left] == 1) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength;
    }

    public static int findTheLHS(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        int max = 0;
        while (right < nums.length) {
            int diff = nums[right] - nums[left];
            if (diff == 1) {
                max = Math.max(max, right - left + 1);
            }
            // 2 , 2 , 3
            if (diff <= 1) {
                right++;
            } else {
                left++;
            }

        }
        return max;
    }


    // Optimized approach using HashMap
    public int findLHS(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) { // Check if a number with a difference of exactly 1 exists
                res = Math.max(res, map.get(key) + map.get(key + 1));
            }
        }
        System.out.println("MAP" + map);
        return res;
    }

    // Brute force approach (for understanding, not efficient)
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    public int findLHSBruteForce(int[] nums) {
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int minVal = Integer.MAX_VALUE;
            int maxVal = Integer.MIN_VALUE;
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                minVal = Math.min(minVal, nums[j]);
                maxVal = Math.max(maxVal, nums[j]);
                if (maxVal - minVal <= 1) {
                    count++;
                    if (maxVal - minVal == 1) { // Only update if it's a harmonious subsequence
                        maxLen = Math.max(maxLen, count);
                    }
                } else {
                    // If the difference becomes > 1, this subsequence is no longer harmonious
                    // and any further elements added to it will also make it non-harmonious.
                    // This inner loop structure is not ideal for finding all harmonious subsequences.
                    // A better brute force would iterate through all pairs of numbers (num1, num2)
                    // and then count occurrences of num1 and num2.
                }
            }
        }
        // A more correct brute force approach would be to iterate through all possible pairs (x, x+1)
        // that could form a harmonious subsequence, and then count their occurrences.
        // Or, iterate through each number as a potential 'min' or 'max' of a harmonious subsequence.
        // Let's refine the brute force idea:
        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            int count1 = 0;
            int count2 = 0;
            for (int num : nums) {
                if (num == num1) count1++;
                else if (num == num1 + 1) count2++;
            }
            if (count1 > 0 && count2 > 0) { // Ensure both numbers exist
                maxLen = Math.max(maxLen, count1 + count2);
            }
        }
        return maxLen;
    }

    public static int findLHSMap(int[] nums) {
        // Step 1: Create frequency map
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Step 2: Count frequency of each number
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 3: Find maximum harmonious sequence length
        int maxLength = 0;

        for (int num : freqMap.keySet()) {
            // Check if num+1 exists in the map
            if (freqMap.containsKey(num + 1)) {
                int currentLength = freqMap.get(num) + freqMap.get(num + 1);
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }


    public static void main(String[] args) {
        LongestHarmoniousSubsequence594 solution = new LongestHarmoniousSubsequence594();
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println( "findTheLHS : " + findTheLHS(nums));
        System.out.println("Longest harmonious subsequence length: " + solution.findLHSSlidingWindow(nums));
        // Test case 1
        //   int[] nums1 = {1, 3, 2, 2, 5, 2, 3, 7};
        int[] nums1 = {1, 2, 3, 4};
        ;
        int expected1 = 5; // [3,2,2,2,3] or [1,2,2,2,3]
        int result1 = solution.findLHS(nums);
        // int result1 = solution.findLHSDifferentApproach(nums1);
        System.out.println("Optimized Test Case 1: nums = " + Arrays.toString(nums1) + ", Expected = " + expected1 + ", Got = " + result1);
        assert result1 == expected1 : "Optimized Test Case 1 Failed";

        int result1BruteForce = solution.findLHSBruteForce(nums1);
        System.out.println("Brute Force Test Case 1: nums = " + Arrays.toString(nums1) + ", Expected = " + expected1 + ", Got = " + result1BruteForce);
        assert result1BruteForce == expected1 : "Brute Force Test Case 1 Failed";

        // Test case 2
        int[] nums2 = {1, 2, 3, 4};
        int expected2 = 2; // [1,2] or [2,3] or [3,4]
        //int result2 = solution.findLHS(nums2);
        int result2 = solution.findLHS(nums2);
        System.out.println("Optimized Test Case 2: nums = " + Arrays.toString(nums2) + ", Expected = " + expected2 + ", Got = " + result2);
        assert result2 == expected2 : "Optimized Test Case 2 Failed";

        int result2BruteForce = solution.findLHSBruteForce(nums2);
        System.out.println("Brute Force Test Case 2: nums = " + Arrays.toString(nums2) + ", Expected = " + expected2 + ", Got = " + result2BruteForce);
        assert result2BruteForce == expected2 : "Brute Force Test Case 2 Failed";

        // Test case 3
        int[] nums3 = {1, 1, 1, 1};
        int expected3 = 0; // No harmonious subsequence
        int result3 = solution.findLHS(nums3);
        System.out.println("Optimized Test Case 3: nums = " + Arrays.toString(nums3) + ", Expected = " + expected3 + ", Got = " + result3);
        assert result3 == expected3 : "Optimized Test Case 3 Failed";

        int result3BruteForce = solution.findLHSBruteForce(nums3);
        System.out.println("Brute Force Test Case 3: nums = " + Arrays.toString(nums3) + ", Expected = " + expected3 + ", Got = " + result3BruteForce);
        assert result3BruteForce == expected3 : "Brute Force Test Case 3 Failed";

        // Test case 4
        int[] nums4 = {};
        int expected4 = 0; // Empty array
        int result4 = solution.findLHS(nums4);
        System.out.println("Optimized Test Case 4: nums = " + Arrays.toString(nums4) + ", Expected = " + expected4 + ", Got = " + result4);
        assert result4 == expected4 : "Optimized Test Case 4 Failed";

        int result4BruteForce = solution.findLHSBruteForce(nums4);
        System.out.println("Brute Force Test Case 4: nums = " + Arrays.toString(nums4) + ", Expected = " + expected4 + ", Got = " + result4BruteForce);
        assert result4BruteForce == expected4 : "Brute Force Test Case 4 Failed";

        // Additional Test Case 5: Single element array
        int[] nums5 = {5};
        int expected5 = 0;
        int result5 = solution.findLHS(nums5);
        System.out.println("Optimized Test Case 5: nums = " + Arrays.toString(nums5) + ", Expected = " + expected5 + ", Got = " + result5);
        assert result5 == expected5 : "Optimized Test Case 5 Failed";

        int result5BruteForce = solution.findLHSBruteForce(nums5);
        System.out.println("Brute Force Test Case 5: nums = " + Arrays.toString(nums5) + ", Expected = " + expected5 + ", Got = " + result5BruteForce);
        assert result5BruteForce == expected5 : "Brute Force Test Case 5 Failed";

        System.out.println("\nAll test cases passed for both optimized and brute force solutions!");

    }
}
