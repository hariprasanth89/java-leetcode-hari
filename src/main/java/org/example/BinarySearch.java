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

//        int[] nums = new int[]{-1,0,3,5,9,12};
//        int target = 9;
//        int searched = search(nums, target);
//        System.out.println(searched);
        printEvenAndOddNumbers(10);
    }
}
