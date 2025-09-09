package org.example.dinesh;

public class IncreaseDecreaseDifferences {

    public static int increaseDecreasing(int[] num) {
        int count = 0;

        for (int i=1; i<num.length; i++) {
            if (num[i-1] < num[i])
                count++;
            if (num[i-1] > num[i])
                count--;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 3, 2, 1, 2, 3, 2, 5}; // 2
        int[] num1 = {1, 2, 3, 4}; // 3
        int[] num2 = {2, 2, 2}; // 0

        System.out.println(increaseDecreasing(num));
        System.out.println(increaseDecreasing(num1));
        System.out.println(increaseDecreasing(num2));
    }
}
