package org.example.leetcode.easy.twopointer;

public class MergeSortedArray88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointers for nums1 (from the end of its valid elements), nums2 (from the end), and the merged array (from the end)
        int p1 = m - 1; // Pointer for the last element of nums1
        int p2 = n - 1; // Pointer for the last element of nums2
        int pMerged = m + n - 1; // Pointer for the last position in the merged nums1 array

        // While there are elements to compare in both arrays
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[pMerged] = nums1[p1];
                p1--;
            } else {
                nums1[pMerged] = nums2[p2];
                p2--;
            }
            pMerged--;
        }

        // If there are remaining elements in nums2, copy them
        // (elements in nums1 are already in place if p1 >= 0)
        while (p2 >= 0) {
            nums1[pMerged] = nums2[p2];
            p2--;
            pMerged--;
        }
    }

    public void mergeBruteForce(int[] nums1, int m, int[] nums2, int n) {
        // Brute force approach: copy nums2 into the end of nums1, then sort.
        // Time Complexity: O((m+n) log(m+n)) due to sorting.
        // Space Complexity: O(1) if sorting is in-place, or O(m+n) if a new array is used for sorting.

        // Copy elements of nums2 into the empty space of nums1
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        // Sort the entire nums1 array
        java.util.Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        MergeSortedArray88 solution = new MergeSortedArray88();

        // Test cases for merge (two-pointer approach)
        System.out.println("--- Testing merge (Two-Pointer) ---");

        // Test Case 1: Standard case
        int[] nums1_1 = {1, 2, 3, 0, 0, 0};
        int m1 = 3;
        int[] nums2_1 = {2, 5, 6};
        int n1 = 3;
        solution.merge(nums1_1, m1, nums2_1, n1);
        System.out.println("Merged Array 1: " + java.util.Arrays.toString(nums1_1)); // Expected: [1, 2, 2, 3, 5, 6]

        // Test Case 2: nums1 is empty
        int[] nums1_2 = {0};
        int m2 = 0;
        int[] nums2_2 = {1};
        int n2 = 1;
        solution.merge(nums1_2, m2, nums2_2, n2);
        System.out.println("Merged Array 2: " + java.util.Arrays.toString(nums1_2)); // Expected: [1]

        // Test Case 3: nums2 is empty
        int[] nums1_3 = {1};
        int m3 = 1;
        int[] nums2_3 = {};
        int n3 = 0;
        solution.merge(nums1_3, m3, nums2_3, n3);
        System.out.println("Merged Array 3: " + java.util.Arrays.toString(nums1_3)); // Expected: [1]

        // Test Case 4: All elements in nums2 are smaller
        int[] nums1_4 = {4, 5, 6, 0, 0, 0};
        int m4 = 3;
        int[] nums2_4 = {1, 2, 3};
        int n4 = 3;
        solution.merge(nums1_4, m4, nums2_4, n4);
        System.out.println("Merged Array 4: " + java.util.Arrays.toString(nums1_4)); // Expected: [1, 2, 3, 4, 5, 6]

    }
}
