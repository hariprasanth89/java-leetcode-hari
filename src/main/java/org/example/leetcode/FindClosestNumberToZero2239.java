package org.example.leetcode;

public class FindClosestNumberToZero2239 {

    public static int findClosestNumber(int[] nums) {

        int maxValue = Integer.MAX_VALUE;
        for(int num : nums){
            if(Math.abs(num) < Math.abs(maxValue) || Math.abs(maxValue) == Math.abs(num)){
                maxValue = num;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        System.out.println(findClosestNumber(new int[]{-4, -2, 1, 4, 8}));
    }
}
