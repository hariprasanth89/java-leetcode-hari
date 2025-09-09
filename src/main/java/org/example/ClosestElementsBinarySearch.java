package org.example;

import java.util.*;

public class ClosestElementsBinarySearch {

    public static int[] findNClosest(int[] arr, int target, int n) {
        int left = 0, right = arr.length - 1;

        // 1. Binary search to find closest index
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                left = mid;
                break;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // After loop, 'left' is the first element >= target
        int l = left - 1;  // pointer to left side
        int r = left;      // pointer to right side

        // 2. Expand two pointers outward
        List<Integer> result = new ArrayList<>();
        while (n-- > 0) {
            if (l < 0) {
                result.add(arr[r++]);
            } else if (r >= arr.length) {
                result.add(arr[l--]);
            } else {
                if (Math.abs(arr[l] - target) <= Math.abs(arr[r] - target)) {
                    result.add(arr[l--]);
                } else {
                    result.add(arr[r++]);
                }
            }
        }

        // 3. Sort result since we may pick from both sides
        Collections.sort(result);

        // Convert to int[]
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 9, 10, 14, 15}; // sorted array
        int target = 8;
        int n = 3;

        int[] closest = findNClosest(arr, target, n);
        System.out.println("Top " + n + " closest elements to " + target + ": " + Arrays.toString(closest));
    }
}
