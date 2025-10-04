package org.example;

import java.util.Arrays;
import java.util.Collections;
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

    // Brute-force approach
    public static int[] findNClosestBruteForce(int[] arr, int target, int n) {
        // Create a list of pairs (difference, value)
        class Element {
            int value;
            int difference;

            Element(int value, int target) {
                this.value = value;
                this.difference = Math.abs(value - target);
            }
        }

        Element[] elements = new Element[arr.length];
        for (int i = 0; i < arr.length; i++) {
            elements[i] = new Element(arr[i], target);
        }

        // Sort the elements based on difference, then by value
        Arrays.sort(elements, (a, b) -> {
            if (a.difference == b.difference) {
                return a.value - b.value;
            }
            return a.difference - b.difference;
        });

        // Extract the first n elements
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = elements[i].value;
        }

        // Sort the result to match the expected output order (optional, but good for consistency)
        Arrays.sort(result);
        return result;
    }

    // Optimized approach using two pointers (assuming sorted array)
    public static int[] findNClosestOptimized(int[] arr, int target, int n) {
        // First, sort the array if it's not already sorted
        Arrays.sort(arr);

        // Find the index of the element closest to the target
        int left = 0;
        int right = arr.length - 1;
        int closestIndex = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (Math.abs(arr[mid] - target) < Math.abs(arr[closestIndex] - target) ||
                    (Math.abs(arr[mid] - target) == Math.abs(arr[closestIndex] - target) && arr[mid] < arr[closestIndex])) {
                closestIndex = mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Use two pointers to expand outwards from the closest element
        left = closestIndex;
        right = closestIndex;
        while (right - left + 1 < n) {
            if (left == 0) { // If left pointer is at the beginning, expand right
                right++;
            } else if (right == arr.length - 1) { // If right pointer is at the end, expand left
                left--;
            } else if (Math.abs(arr[left - 1] - target) <= Math.abs(arr[right + 1] - target)) {
                // If left element is closer or equally close (prioritize smaller value)
                left--;
            } else {
                right++;
            }
        }

        return Arrays.copyOfRange(arr, left, right + 1);
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 14, 3, 7, 9, 1, 15};
        int target = 8;
        int n = 3;

        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Target: " + target + ", n: " + n);

        // Using the PriorityQueue approach
        int[] closest = findNClosest(arr, target, n);
        // The PriorityQueue approach returns elements in arbitrary order, sort for consistent output
        Arrays.sort(closest);
        System.out.println("PriorityQueue Approach: " + Arrays.toString(closest));

        // Using the Brute-Force approach
        int[] closestBruteForce = findNClosestBruteForce(arr, target, n);
        System.out.println("Brute-Force Approach: " + Arrays.toString(closestBruteForce));

        // Using the Optimized (Two Pointers) approach
        // Note: The optimized approach expects a sorted array or sorts it internally.
        // For demonstration, we'll pass a copy or let it sort.
        int[] arrForOptimized = Arrays.copyOf(arr, arr.length); // Make a copy to not modify original arr
        int[] closestOptimized = findNClosestOptimized(arrForOptimized, target, n);
        System.out.println("Optimized (Two Pointers) Approach: " + Arrays.toString(closestOptimized));

        System.out.println("\n--- Test Case 2 ---");
        int[] arr2 = {1, 2, 3, 4, 5};
        int target2 = 3;
        int n2 = 4;
        System.out.println("Original Array: " + Arrays.toString(arr2));
        System.out.println("Target: " + target2 + ", n: " + n2);

        int[] closest2 = findNClosest(arr2, target2, n2);
        Arrays.sort(closest2);
        System.out.println("PriorityQueue Approach: " + Arrays.toString(closest2));

        int[] closestBruteForce2 = findNClosestBruteForce(arr2, target2, n2);
        System.out.println("Brute-Force Approach: " + Arrays.toString(closestBruteForce2));

        int[] arrForOptimized2 = Arrays.copyOf(arr2, arr2.length);
        int[] closestOptimized2 = findNClosestOptimized(arrForOptimized2, target2, n2);
        System.out.println("Optimized (Two Pointers) Approach: " + Arrays.toString(closestOptimized2));
    }
}