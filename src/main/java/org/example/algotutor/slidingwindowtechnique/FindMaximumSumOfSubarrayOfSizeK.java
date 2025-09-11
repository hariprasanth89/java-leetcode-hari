package org.example.algotutor.slidingwindowtechnique;

public class FindMaximumSumOfSubarrayOfSizeK {

    // Method to find the maximum sum of a subarray of size k in an array of integers  optimizes solution Sliding Window Technique:
    public static int findMaximumSumOfSubarrayOfSizeK(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        int windowSum = 0;
        // Calculate the sum of the first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // Slide the window from the beginning to the end of the array
        for (int i = k; i < arr.length; i++) {
            // Add the new element to the window
            windowSum += arr[i];
            // Subtract the element that is leaving the window
            windowSum -= arr[i - k];
            // Update maxSum if the current windowSum is greater
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    // Brute Force Approach:
    public static int findMaximumSumOfSubarrayOfSizeK_BruteForce(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        int maxSum = Integer.MIN_VALUE; // Initialize maxSum to the smallest possible integer value

        // Iterate through all possible starting points of a subarray
        // The loop runs until there are enough elements left to form a subarray of size k
        for (int i = 0; i <= arr.length - k; i++) {
            int currentSum = 0;
            // Calculate the sum of the current subarray of size k
            // The inner loop iterates k times to sum elements from index i to i + k - 1
            for (int j = i; j < i + k; j++) {
                currentSum += arr[j];
            }
            // Update maxSum if the current subarray's sum is greater
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
//Sliding Window Technique:
    // Method to find the maximum sum of a subarray of size k in an array of integers
    public static int findMaximumSumOfSubarrayOfSizeK_Solution(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length){
            throw new IllegalArgumentException("Invalid input");
        }
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        // Calculate the sum of the first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;
        // Slide the window from the beginning to the end of the array
        for (int i = k; i < arr.length; i++) {
            // Add the new element to the window
            windowSum += arr[i] - arr[i - k];
            // Update maxSum if the current windowSum is greater
           maxSum = Math.max(maxSum, windowSum);
            //maxSum= (maxSum >= windowSum) ? maxSum : windowSum;
        }
    return maxSum;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 5, 1, 3, 2};
        int k1 = 3;
//        System.out.println("Maximum sum of subarray of size " + k1 + ": " + findMaximumSumOfSubarrayOfSizeK(arr1, k1)); // Expected: 9 (from {5, 1, 3})
//
        int[] arr2 = {2, 3, 4, 1, 5};
        int k2 = 2;
//        System.out.println("Maximum sum of subarray of size " + k2 + ": " + findMaximumSumOfSubarrayOfSizeK(arr2, k2)); // Expected: 7 (from {2, 3} or {3, 4})
//
//        int[] arr3 = {1, 2, 3, 4, 5};
//        int k3 = 1;
//        System.out.println("Maximum sum of subarray of size " + k3 + ": " + findMaximumSumOfSubarrayOfSizeK(arr3, k3)); // Expected: 5 (from {5})

//        findMaximumSumOfSubarrayOfSizeK_BruteForce(arr2, k2);
//        System.out.println("Maximum sum of subarray of size " + k2 + ": " + findMaximumSumOfSubarrayOfSizeK_BruteForce(arr2, k2));
        //findMaximumSumOfSubarrayOfSizeK_Solution(arr1, k1);
        System.out.println("Maximum sum of subarray of size " + k2 + ": " + findMaximumSumOfSubarrayOfSizeK_Solution(arr1, k1));
    }

}
