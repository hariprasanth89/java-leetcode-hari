package org.example;

import java.util.*;

public class ClosestElementsDiffApproach {

    public static int[] findNClosest(int[] arr, int target, int n) {
        // Convert array to list for easier sorting
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }

        // Sort list based on absolute difference to target
        list.sort((a, b) -> {
            int diffA = Math.abs(a - target);
            int diffB = Math.abs(b - target);
            if (diffA == diffB) {
                return a - b; // If difference is same, smaller number comes first
            }
            return diffA - diffB; // Smaller difference comes first
        });

        // Pick first n elements after sorting
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 14, 3, 7, 9, 1, 15};
        int target = 8;
        int n = 3;

        int[] closest = findNClosest(arr, target, n);
        System.out.println("Top " + n + " closest elements to " + target + ": " + Arrays.toString(closest));
    }
}
