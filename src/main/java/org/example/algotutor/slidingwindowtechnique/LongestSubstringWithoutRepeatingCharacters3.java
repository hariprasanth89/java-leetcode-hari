package org.example.algotutor.slidingwindowtechnique;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters3 {

    public static int lengthOfLongestSubstringUsingSet(String s){
        int left = 0;
        int maxLength = Integer.MIN_VALUE;
        Set<Character> charSet = new HashSet<>();
        for(int right = 0; right < s.length(); right++){
                while(charSet.contains(s.charAt(right))){
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            }
        System.out.println(charSet);
        return maxLength;
    }


    public static int lengthOfLongestSubstringUsingHashMap(String s){
        int maxLength = 0;
        int left = 0;
        Map<Character, Integer> count = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            count.put(c, count.getOrDefault(c, 0) + 1);

            while (count.get(c) > 1) {
                char leftChar = s.charAt(left);
                count.put(leftChar, count.get(leftChar) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        System.out.println(count);
        return maxLength;
    }

    public int lengthOfLongestSubstringDifferent(String s) {
        int maxLength = 0;
        int left = 0;
        Map<Character, Integer> lastSeen = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (lastSeen.containsKey(c) && lastSeen.get(c) >= left) {
                left = lastSeen.get(c) + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            lastSeen.put(c, right);
        }
        System.out.println(lastSeen);
        return maxLength;
    }

    // display the words
    public static String lengthOfLongestSubstringUsingSetApproach(String s) {
        int left = 0;
        int maxLength = 0; // Initialize to 0 for length
        String longestSubstring = ""; // To store the actual substring
        Set<Character> charSet = new HashSet<>();

        if (s == null || s.isEmpty()) {
            return ""; // Handle empty or null string
        }

        // Handle single character string or all unique characters
        if (s.length() == 1) {
            return s;
        }

        for (int right = 0; right < s.length(); right++) {
            // While the current character at 'right' is already in our set,
            // remove characters from the 'left' until it's unique again.
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            // Add the current character to the set
            charSet.add(s.charAt(right));

            // Calculate current length
            int currentLength = right - left + 1;

            // If current length is greater than max length, update max length
            // AND update the longestSubstring
            if (currentLength > maxLength) {
                maxLength = currentLength;
                longestSubstring = s.substring(left, right + 1); // Extract the substring
            }
        }

        // If maxLength is 0 (e.g., if s was empty or all characters removed due to initial MIN_VALUE),
        // it means no valid substring was found, but the problem usually implies at least one char
        // This handles cases like "aa" where initial maxLength might be MIN_VALUE
        if (maxLength == 0 && !s.isEmpty()) { // Special case for when s has all repeating chars like "aaaa"
            return String.valueOf(s.charAt(0)); // Or handle as per problem spec, often first char if all same
        }

        return longestSubstring;
    }

    public static int lengthOfLongestSubstringAndGetAllUniqueChars(String s) {
        int left = 0;
        int maxLength = 0; // Initialize to 0 for length
        Set<Character> currentWindowCharSet = new HashSet<>(); // For the sliding window
        Set<Character> allUniqueCharsEncountered = new HashSet<>(); // To keep track of all unique chars in the string

        if (s == null || s.isEmpty()) {
            return 0;
        }

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // Add the current character to the set that records all unique characters
            allUniqueCharsEncountered.add(currentChar);

            // This part is the original sliding window logic for the longest substring
            while (currentWindowCharSet.contains(currentChar)) {
                currentWindowCharSet.remove(s.charAt(left));
                left++;
            }
            currentWindowCharSet.add(currentChar);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println("All unique characters encountered in the string: " + allUniqueCharsEncountered);
        return maxLength;
    }


    public static void main(String[] args) {
        String s = "abcabcbb";
       // System.out.println(lengthOfLongestSubstringUsingSet(s));
        //System.out.println(lengthOfLongestSubstringUsingHashMap(s));
//        System.out.println("Longest substring for \"abcabcbb\": " + lengthOfLongestSubstringUsingSetApproach("abcabcbb")); // Expected: abc
//        System.out.println("Longest substring for \"bbbbb\": " + lengthOfLongestSubstringUsingSetApproach("bbbbb"));     // Expected: b
//        System.out.println("Longest substring for \"pwwkew\": " + lengthOfLongestSubstringUsingSetApproach("pwwkew"));   // Expected: wke
//        System.out.println("Longest substring for \"\": " + lengthOfLongestSubstringUsingSetApproach(""));         // Expected: ""
//        System.out.println("Longest substring for \"a\": " + lengthOfLongestSubstringUsingSetApproach("a"));         // Expected: a
//        System.out.println("Longest substring for \"au\": " + lengthOfLongestSubstringUsingSetApproach("au"));         // Expected: au
        System.out.println("Longest substring length for \"abcabcbb\": " + lengthOfLongestSubstringAndGetAllUniqueChars("abcabcbb")); // Length: 3. All unique chars: [a, b, c]
        System.out.println("Longest substring length for \"bbbbb\": " + lengthOfLongestSubstringAndGetAllUniqueChars("bbbbb"));     // Length: 1. All unique chars: [b]
        System.out.println("Longest substring length for \"pwwkew\": " + lengthOfLongestSubstringAndGetAllUniqueChars("pwwkew"));   // Length: 3. All unique chars: [p, w, k, e]
        System.out.println("Longest substring length for \"\": " + lengthOfLongestSubstringAndGetAllUniqueChars(""));         // Length: 0. All unique chars: []

    }
}
