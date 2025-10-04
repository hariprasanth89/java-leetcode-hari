package org.example.leetcode.easy.twopointer;

public class ValidPalindrome125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true; // An empty string is considered a valid palindrome
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Move left pointer inward until it points to an alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Move right pointer inward until it points to an alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // If the characters at the pointers are not the same (case-insensitive), it's not a palindrome
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            // Move both pointers inward
            left++;
            right--;
        }

        return true; // All alphanumeric characters matched
    }

    public static void main(String[] args) {
        ValidPalindrome125 solution = new ValidPalindrome125();

        // Test cases
        System.out.println("Test Case 1: \"A man, a plan, a canal: Panama\"");
        System.out.println("Is Palindrome: " + solution.isPalindrome("A man, a plan, a canal: Panama")); // Expected: true

        System.out.println("\nTest Case 2: \"race a car\"");
        System.out.println("Is Palindrome: " + solution.isPalindrome("race a car")); // Expected: false

        System.out.println("\nTest Case 3: \" \"");
        System.out.println("Is Palindrome: " + solution.isPalindrome(" ")); // Expected: true

        System.out.println("\nTest Case 4: \"Madam\"");
        System.out.println("Is Palindrome: " + solution.isPalindrome("Madam")); // Expected: true

        System.out.println("\nTest Case 5: \"0P\"");
        System.out.println("Is Palindrome: " + solution.isPalindrome("0P")); //
    }
}