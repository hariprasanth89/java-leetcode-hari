package org.example.leetcode.mediam.dynamicprogramming;

public class MaximumProductSubarray152 {


    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = (nums[i] - 1) * (nums[j] - 1);
                if (product > max) {
                    max = product;
                }
            }
        }
        return max;
    }

    public int maxProductBruteForce(int[] nums) {
//         Brute Force Solution
//         Time Complexity: O(n^2)
//         Space Complexity: O(1)
        int maxProduct = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int currentProduct = 1;
            for (int j = i; j < nums.length; j++) {
                currentProduct *= nums[j];
                maxProduct = Math.max(maxProduct, currentProduct);
            }
        }
        return maxProduct;
    }

    public int maxProductOptimized(int[] nums) {
        // Optimized Solution (Dynamic Programming)
        // Time Complexity: O(n)
        // Space Complexity: O(1)
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            // Calculate potential new max and min products
            // We need to store maxSoFar before it's updated to use it for minSoFar calculation
            int tempMax = Math.max(curr, Math.max(maxSoFar * curr, minSoFar * curr));
            minSoFar = Math.min(curr, Math.min(maxSoFar * curr, minSoFar * curr));

            maxSoFar = tempMax;

            // Update the overall result
            result = Math.max(result, maxSoFar);
        }

        return result;
    }

    //
    public static int maxProductSimplified(int[] nums) {
        int leftProduct = 1;
        int rightProduct = 1;
        int maxProduct = nums[0];
        for (int i = 0; i<nums.length; i++) {
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;
            leftProduct *= nums[i];
            rightProduct *= nums[nums.length - 1 - i];
            maxProduct = Math.max(maxProduct, Math.max(leftProduct, rightProduct));
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        MaximumProductSubarray152 solution = new MaximumProductSubarray152();

        // Test cases for Brute Force
        System.out.println("Brute Force Tests:");
       // System.out.println("Test 1: [2,3,-2,4] -> " + solution.maxProductBruteForce(new int[]{2, 3, -2, 4})); // Expected: 6
        maxProductSimplified(new int[]{2, 3, -2, 4});
        System.out.println("Test 2: [-2,0,-1] -> " + solution.maxProductBruteForce(new int[]{-2, 0, -1})); // Expected: 0
        System.out.println("Test 3: [-2,3,-4] -> " + solution.maxProductBruteForce(new int[]{-2, 3, -4})); // Expected: 24
        System.out.println("Test 4: [0,2] -> " + solution.maxProductBruteForce(new int[]{0, 2})); // Expected: 2
        System.out.println("Test 5: [-1,-2,-9,-6] -> " + solution.maxProductBruteForce(new int[]{-1, -2, -9, -6})); // Expected: 108
        System.out.println("Test 6: [7,-2,-4] -> " + solution.maxProductBruteForce(new int[]{7, -2, -4})); // Expected: 56
        System.out.println("Test 7: [-1] -> " + solution.maxProductBruteForce(new int[]{-1})); // Expected: -1
        System.out.println("Test 8: [5] -> " + solution.maxProductBruteForce(new int[]{5})); // Expected: 5
        System.out.println("Test 9: [1,2,3,4,5] -> " + solution.maxProductBruteForce(new int[]{1, 2, 3, 4, 5})); // Expected: 120
        System.out.println("Test 10: [-1,-1,-1,-1] -> " + solution.maxProductBruteForce(new int[]{-
                1, -1, -1, -1})); // Expected: 1
        System.out.println("Test 11: [-1,0,-1] -> " + solution.maxProductBruteForce(new int[]{-1, 0, -1})); // Expected: 0
        System.out.println("Test 12: [0] -> " + solution.maxProductBruteForce(new int[]{0})); // Expected: 0

        // Test cases for Optimized Solution
        System.out.println("\nOptimized Solution Tests:");
        System.out.println("Test 1: [2,3,-2,4] -> " + solution.maxProductOptimized(new int[]{2, 3, -2, 4})); // Expected: 6
        System.out.println("Test 2: [-2,0,-1] -> " + solution.maxProductOptimized(new int[]{-2, 0, -1})); // Expected: 0
        System.out.println("Test 3: [-2,3,-4] -> " + solution.maxProductOptimized(new int[]{-2, 3, -4})); // Expected: 24
        System.out.println("Test 4: [0,2] -> " + solution.maxProductOptimized(new int[]{0, 2})); // Expected: 2
        System.out.println("Test 5: [-1,-2,-9,-6] -> " + solution.maxProductOptimized(new int[]{-1, -2, -9, -6})); // Expected: 108
        System.out.println("Test 6: [7,-2,-4] -> " + solution.maxProductOptimized(new int[]{7, -2, -4})); // Expected: 56
        System.out.println("Test 7: [-1] -> " + solution.maxProductOptimized(new int[]{-1})); // Expected: -1
        System.out.println("Test 8: [5] -> " + solution.maxProductOptimized(new int[]{5})); // Expected: 5
        System.out.println("Test 9: [1,2,3,4,5] -> " + solution.maxProductOptimized(new int[]{1, 2, 3, 4, 5})); // Expected: 120
        System.out.println("Test 10: [-1,-1,-1,-1] -> " + solution.maxProductOptimized(new int[]{-1, -1, -1, -1})); // Expected: 1
        System.out.println("Test 11: [-1,0,-1] -> " + solution.maxProductOptimized(new int[]{-1, 0, -1})); // Expected: 0
        System.out.println("Test 12: [0] -> " + solution.maxProductOptimized(new int[]{0})); // Expected: 0
    }
}
