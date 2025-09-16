package org.example.leetcode.easy.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate_II_219 {
    // Optimized solution using a HashMap (Sliding Window concept)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Handle edge cases: if the array is null or empty, no duplicates can exist.
        if (nums == null || nums.length == 0) return false;

        // Create a HashMap to store the most recent index of each number encountered.
        // Key: number, Value: its index in the array.
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate through the array with index 'i'.
        for (int i = 0; i < nums.length; i++) {
            // Check if the current number (nums[i]) is already in the map.
            if (map.containsKey(nums[i])) {
                // If it is, calculate the absolute difference between the current index 'i'
                // and the previously stored index of this number (map.get(nums[i])).
                // If this difference is less than or equal to 'k', it means we found
                // two identical numbers within the allowed distance 'k'.
                if (i - map.get(nums[i]) <= k) return true;
            }
            // Update the map with the current number and its current index.
            // This ensures that we always store the most recent index of each number,
            // which is crucial for checking the 'k' distance constraint correctly.
            map.put(nums[i], i);
        }
        // If the loop completes without finding any duplicates within distance 'k', return false.
        return false;
    }


    // Brute-force solution (Time Limit Exceeded for larger inputs)
    public boolean containsNearbyDuplicateBruteForce(int[] nums, int k) {
        // Iterate through each element of the array.
        for (int i = 0; i < nums.length; i++) {
            // For each element, iterate through the subsequent elements up to distance 'k'.
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                // If two elements are equal, return true.
                if (nums[i] == nums[j]) return true;
            }
        }
        // If no such pair is found after checking all possibilities, return false.
        return false;
    }
    public boolean containsNearbyDuplicateUsingSet(int[] nums, int k) {
        Set<Integer> arrSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (arrSet.contains(nums[i])) {
                return true;
            }
            arrSet.add(nums[i]);
            if (arrSet.size() > k) {
                arrSet.remove(nums[i - k]);
            }
        }
        return false;
    }
    public static boolean containsNearByDuplicatesUsingSet(int[] nums, int k){
        if(nums == null || nums.length == 0) return false;
        Set<Integer> arrSet = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(arrSet.contains(nums[i])){
                return true;
            }
            arrSet.add(nums[i]);
            if(arrSet.size() > k){
                arrSet.remove(nums[i - k]);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        ContainsDuplicate_II_219 solution = new ContainsDuplicate_II_219();

        // Test Case 1: Basic case with duplicate within k
        int[] nums1 = {1, 2, 3,1};
        int k1 = 3;
        System.out.println("Test Case 1: nums = [1,2,3,1], k = 3 -> Expected: true, Actual: " + solution.containsNearbyDuplicate(nums1, k1)); // Expected: true

        // Test Case 2: Duplicate exactly at distance k
        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        System.out.println("Test Case 2: nums = [1,0,1,1], k = 1 -> Expected: true, Actual: " + solution.containsNearbyDuplicate(nums2, k2)); // Expected: true

        // Test Case 3: Duplicate outside distance k
        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        System.out.println("Test Case 3: nums = [1,2,3,1,2,3], k = 2 -> Expected: false, Actual: " + solution.containsNearbyDuplicate(nums3, k3)); // Expected: false

        // Test Case 4: No duplicates
        int[] nums4 = {1, 2, 3, 4, 5};
        int k4 = 3;
        System.out.println("Test Case 4: nums = [1,2,3,4,5], k = 3 -> Expected: false, Actual: " + solution.containsNearbyDuplicate(nums4, k4)); // Expected: false

        // Test Case 5: Empty array
        int[] nums5 = {};
        int k5 = 1;
        System.out.println("Test Case 5: nums = [], k = 1 -> Expected: false, Actual: " + solution.containsNearbyDuplicate(nums5, k5)); // Expected: false


    }
}