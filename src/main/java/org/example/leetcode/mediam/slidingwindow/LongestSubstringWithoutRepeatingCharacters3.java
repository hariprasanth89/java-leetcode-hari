package org.example.leetcode.mediam.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public static int lengthOfLongestSubString(String s){
            int left = 0; // Initialize the left pointer of the sliding window
            int right = 0; // Initialize the right pointer of the sliding window
            int max = Integer.MIN_VALUE;  // Initialize the maximum length found so far to the smallest possible integer value
            Set<Character> lastSeenChat = new HashSet<>(); // Create a HashSet to store characters in the current window to check for duplicates
            while(right < s.length()){ // Loop as long as the right pointer is within the string bounds
                if(!lastSeenChat.contains(s.charAt(right))){ // If the character at the right pointer is not in the set (i.e., it's not a repeating character)
                    lastSeenChat.add(s.charAt(right)); // Add the character to the set
                    max =Math.max(max,right-left+1); // (Alternative way to calculate max length)
                    //max =Math.max(max,lastSeenChat.size()); // Update max with the current size of the set (which is the length of the current non-repeating substring)
                    right++; // Move the right pointer to expand the window
                }else{ // If the character at the right pointer is already in the set (i.e., it's a repeating character)
                    lastSeenChat.remove(s.charAt(left)); // Remove the character at the left pointer from the set
                    left++; // Move the left pointer to shrink the window, effectively removing the repeating character from consideration
                }
            }
        return max; // Return the maximum length of the substring without repeating characters
    }
    // This is an optimized solution using a sliding window approach.
    public static int lengthOfLongestSubstringDifferentApproach(String s) {
        int left = 0;
        Set<Character> lastSeen = new HashSet<>(); // Create a HashSet to store characters in the current window
        int max = 0; // Initialize the maximum length found so far
        for(int right = 0; right < s.length(); right++){ // Iterate with the right pointer
            while(lastSeen.contains(s.charAt(right))){ // If the character at the right pointer is already in the set (repeating character)
                lastSeen.remove(s.charAt(left)); // Remove the character at the left pointer from the set
                left++; // Move the left pointer to shrink the window
            }
            lastSeen.add(s.charAt(right)); // Add the current character at the right pointer to the set
            max = Math.max(max,lastSeen.size()); // Update max with the current size of the set (length of the non-repeating substring)
            //max = Math.max(max, right - left + 1);
        }
        return max; // Return the maximum length of the substring without repeating characters
    }

    // Brute-force approach (for comparison, not optimized)
    public static int lengthOfLongestSubstringBruteForce(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> currentWindow = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (currentWindow.contains(s.charAt(j))) {
                    break; // Found a repeating character, break inner loop
                }
                currentWindow.add(s.charAt(j));
                max = Math.max(max, currentWindow.size());
            }
        }
        return max; // Return the maximum length of the substring without repeating characters
    }


    public static void main(String[] args) {
        String s = "abcabcbb";
        //System.out.println(lengthOfLongestSubString(s));
        System.out.println(lengthOfLongestSubstringDifferentApproach(s));
        System.out.println(lengthOfLongestSubstringBruteForce(s));
    }
}
