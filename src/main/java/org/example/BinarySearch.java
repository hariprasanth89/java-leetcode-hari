package org.example;

public class BinarySearch {

    // This method performs a binary search iteratively
    public static int search(int[] nums, int target) {
        int left = 0; // Start index
        int right = nums.length - 1; // End index
        while (left <= right) { // Continue until the search space is valid
            //int mid = left + (right - left) / 2; // To avoid overflow
            int mid = (left + right) / 2; // Simple average, works for small arrays
            if (nums[mid] == target) { // Target found
                return mid; // Return the index of the target
            }
            if (nums[mid] < target) { // If target is greater, ignore the left half
                left = mid + 1; // Move to the right half
            } else { // If target is smaller, ignore the right half
                right = mid - 1; // Move to the left half
            }
        }
        return -1; // Target not found, return -1
    }
    // This method performs a binary search recursively
    public static int searchRecursive(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1; // Base case: target not found
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid; // Target found
        }
        if (nums[mid] < target) {
            return searchRecursive(nums, target, mid + 1, right); // Search in the right half
        } else {
            return searchRecursive(nums, target, left, mid - 1); // Search in the left half
        }
    }

    // This method performs a linear search (brute-force approach)
    public static int linearSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i; // Target found, return its index
            }
        }
        return -1; // Target not found
    }

    // This method is an optimized version of the iterative binary search
    // It's essentially the same as the 'search' method, as binary search is already optimized for sorted arrays.
    public static int optimizedSearch(int[] nums, int target) {
        return search(nums, target); // Binary search is already an optimized approach for sorted arrays
    }

    // This method prints even and odd numbers from 0 to n
    public static void printEvenAndOddNumbers(int n) {
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " is even");
            } else {
                System.out.println(i + " is odd");
            }
        }
    }

    // Main method to test the binary search and print functions

    public static void main(String[] args) {

        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 9;

        // Test iterative binary search
        System.out.println("Iterative Binary Search:");
        System.out.println("Target " + target + " found at index: " + search(nums, target)); // Expected: 4

        // Test recursive binary search
//        System.out.println("\nRecursive Binary Search:");
//        System.out.println("Target " + target + " found at index: " + searchRecursive(nums, target, 0, nums.length - 1)); // Expected: 4

        // Test linear search (brute-force)
        System.out.println("\nLinear Search (Brute-Force):");
        System.out.println("Target " + target + " found at index: " + linearSearch(nums, target)); // Expected: 4

        // printEvenAndOddNumbers(10);
    }
}
