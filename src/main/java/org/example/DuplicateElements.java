package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateElements {

    public static void findTheDuplicateElement(int[] arr) { // Find the duplicate element in an array
        int slow = arr[0]; // slow pointer
        int fast = arr[0]; // fast pointer

        // Finding the intersection point
        do { // loop until slow and fast pointers meet
            slow = arr[slow]; // move slow pointer by 1 step
            fast = arr[arr[fast]]; // move fast pointer by 2 steps
        } while (slow != fast); // loop until slow and fast pointers meet

        // Finding the entrance to the cycle
        slow = arr[0]; // move slow pointer to start
        while (slow != fast) { // loop until slow and fast pointers meet
            slow = arr[slow]; // move slow pointer by 1 step
            fast = arr[fast]; // move fast pointer by 1 step
        }
        System.out.println("Duplicate element is: " + slow); // print the duplicate element
    }

    public static void findTheDuplicateElementUsingHashing(int[] arr) { // Find the duplicate element in an array using hashing
        boolean[] visited = new boolean[arr.length]; // create a boolean array to keep track of visited elements
        for (int num : arr) { // loop through the array
            if (visited[num]) { // if the element is already visited
                System.out.println("Duplicate element is: " + num); // print the duplicate element
                return; // exit the method
            }
            visited[num] = true; // mark the element as visited
        }
        System.out.println("No duplicate element found"); // if no duplicate element is found
    }

    public static void findTheDuplicateElementAndStoreElement(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        for (int num : arr) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }
        if (duplicates.isEmpty()) {
            System.out.println("No duplicate elements found");
        } else {
            System.out.println("Duplicate elements are: " + duplicates);
        }
    }
    public static void findTheDuplicateElementSingleSet(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        boolean found = false;
        for (int num : arr) {
            if (!seen.add(num)) {
                System.out.println("Duplicate element is: " + num);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No duplicate elements found");
        }
    }
    public static List<Integer> findTheDuplicateElementAndStoreElementList(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();
        for (int num : arr) {
            if (!seen.add(num) && !duplicates.contains(num)) {
                duplicates.add(num);
            }
        }
        return duplicates;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 3};
        int[] arrEle = {2, 3, 1};
                //findTheDuplicateElement(arr);
        //findTheDuplicateElementAndStoreElement(arr);
        //findTheDuplicateElementSingleSet(arrEle);
        findTheDuplicateElementAndStoreElementList(arr).forEach(System.out::println);
    }

}
