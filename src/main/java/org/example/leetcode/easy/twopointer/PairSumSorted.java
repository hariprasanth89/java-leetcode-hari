package org.example.leetcode.easy.twopointer;

import java.util.ArrayList;

public class PairSumSorted {

    /*
    167. Two Sum II - Input Array Is Sorted -- leetcode easy
     */

    public ArrayList<Integer> pair_sum_sorted(ArrayList<Integer> nums, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0;
        int right = nums.size() - 1;

        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum == target) {
                result.add(left + 1); // +1 for 1-based index
                result.add(right + 1); // +1 for 1-based index
//                result.add(++left); // +1 for 1-based index
//                result.add(++right); // +1 for 1-based index
                return result;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return result; // return empty list if no pair found
    }

    public static void main(String[] args) {
        PairSumSorted solution = new PairSumSorted();

        // Test case 1
        ArrayList<Integer> nums1 = new ArrayList<>();
        nums1.add(2);
        nums1.add(7);
        nums1.add(11);
        nums1.add(15);
        int target1 = 9;
        ArrayList<Integer> result1 = solution.pair_sum_sorted(nums1, target1);
        System.out.println("Test Case 1: nums = [2,7,11,15], target = 9 -> Result: " + result1); // Expected: [1, 2]

        // Test case 2
        ArrayList<Integer> nums2 = new ArrayList<>();
        nums2.add(2);
        nums2.add(3);
        nums2.add(4);
        int target2 = 6;
        ArrayList<Integer> result2 = solution.pair_sum_sorted(nums2, target2);
        System.out.println("Test Case 2: nums = [2,3,4], target = 6 -> Result: " + result2); // Expected: [2, 3]

        // Test case 3
        ArrayList<Integer> nums3 = new ArrayList<>();
        nums3.add(-1);
        nums3.add(0);
        int target3 = -1;
        ArrayList<Integer> result3 = solution.pair_sum_sorted(nums3, target3);
        System.out.println("Test Case 3: nums = [-1,0], target = -1 -> Result: " + result3); // Expected: [1, 2]

        // Test case 4: No pair found
        ArrayList<Integer> nums4 = new ArrayList<>();
        nums4.add(1);
        nums4.add(2);
        nums4.add(3);
        int target4 = 7;
        ArrayList<Integer> result4 = solution.pair_sum_sorted(nums4, target4);
        System.out.println("Test Case 4: nums = [1,2,3], target = 7 -> Result: " + result4); // Expected:

    }
}