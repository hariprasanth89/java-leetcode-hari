package org.example.meta;

import java.util.Arrays;

public class ConcatenationOfArray1929 {

    public static int[] getConcatenation(int[] nums) {
        int n = nums.length *2;
        int[] res = new int[n];
        System.out.println(res.length);
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
            res[i + nums.length] = nums[i];
        }
        Arrays.stream(res).forEach(System.out::print);
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        getConcatenation(nums);
    }
}
