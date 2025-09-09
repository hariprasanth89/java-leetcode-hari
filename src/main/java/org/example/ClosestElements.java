package org.example;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

public class ClosestElements {

    public static int[] findNClosest(int[] arr, int target, int n) {
        // Custom comparator for the PriorityQueue based on absolute difference
        Comparator<Integer> comparator = (a, b) -> {
            int diffA = Math.abs(a - target);
            int diffB = Math.abs(b - target);
            if (diffA == diffB) { // If differences are equal, prioritize smaller number
                return a - b;
            }
            return diffB - diffA; // Max-heap based on difference
        };

        PriorityQueue<Integer> pq = new PriorityQueue<>(comparator);

        for (int num : arr) {
            pq.offer(num);
            if (pq.size() > n) {
                pq.poll(); // Remove the element with the largest difference
            }
        }

        int[] result = new int[pq.size()];
        for (int i = pq.size() - 1; i >= 0; i--) {
            result[i] = pq.poll();
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