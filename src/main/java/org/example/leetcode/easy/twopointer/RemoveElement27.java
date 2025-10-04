package org.example.leetcode.easy.twopointer;

public class RemoveElement27 {

    public int removeElement(int[] nums, int val) {
        // Optimized solution using two pointers
        if (nums == null || nums.length == 0) {
            return 0; // If the array is null or empty, there are no elements to remove, so return 0.
        }

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k; // k represents the number of elements not equal to val.
    }

    // Brute force approach (less efficient for in-place modification)
    // This approach would typically involve creating a new array or shifting elements,
    // which is not what the problem asks for (in-place modification with O(1) extra space).
    // However, if we were to simulate a brute-force removal without the in-place constraint,
    // it might look something like this (though not directly applicable to the problem's constraints).
    public int removeElementBruteForce(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                // In a true brute-force scenario for removal, you'd shift elements
                // or copy to a new array. For this problem, shifting is complex
                // and copying to a new array violates space constraints.
                // This method is primarily for demonstration of a "non-optimized" thought process.
                // For the given problem, the optimized two-pointer is the standard.
            } else {
                count++; // Count elements that are NOT equal to val
            }
        }
        return count; // This would return the count of elements remaining if they were removed.
    }

    public static void main(String[] args) {
        RemoveElement27 solution = new RemoveElement27();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int k = solution.removeElement(nums, val);
        System.out.println("Optimized Solution:");
        System.out.println("Number of elements not equal to " + val + ": " + k);
        System.out.print("Modified array: [");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i]);
            if (i < k - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        System.out.println("\nBrute Force (conceptual) Solution:");
        int[] numsBruteForce = {3, 2, 2, 3}; // Re-initialize for brute force
        int kBruteForce = solution.removeElementBruteForce(numsBruteForce, val);
        System.out.println("Count of elements not equal to " + val + ": " + kBruteForce);
        // Note: The brute force method as implemented here only counts, it doesn't modify the array in place
        // in a way that reflects the problem's output requirements.

    }
}
