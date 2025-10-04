package org.example.walmart;

import java.util.Arrays;
import java.util.stream.Stream;

public class MoveZerosToEnd {


    // Moves all zeros to the end of the array in-place
    public static void moveZeroes(int[] nums) {
        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        //Arrays.stream(nums).forEach(System.out::println);


//        for (int num : nums) {
//            System.out.print(num + " ");
//        }
    }
}
