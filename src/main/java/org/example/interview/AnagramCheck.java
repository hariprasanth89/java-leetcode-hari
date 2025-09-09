package org.example.interview;

public class AnagramCheck {
  public static boolean isAnagram(String a, String b) {
    if (a.length() != b.length()) return false;
    int[] cnt = new int[256];
    for (int i = 0; i < a.length(); i++) {
      cnt[a.charAt(i)]++;
      cnt[b.charAt(i)]--;
    }
    for (int c : cnt)
      if (c != 0)
        return false;
    return true;
  }

  //opt
  // Checks if two strings are anagrams (case-insensitive, ignores non-letters)
  public static boolean isAnagram2Way(String a, String b) {
    // Remove non-alphabetic characters and convert to lowercase
    a = a.trim().replaceAll("[^A-Za-z]", "").toLowerCase();
    b = b.trim().replaceAll("[^A-Za-z]", "").toLowerCase();
    // If lengths differ, they can't be anagrams
    if (a.length() != b.length()) return false;
    int[] cnt = new int[26];  // Array to count each letter ('a' to 'z')
    for (int i = 0; i < a.length(); i++) {
      cnt[a.charAt(i) - 'a']++;    // Increment count for letter in 'a'
      cnt[b.charAt(i) - 'a']--;    // Decrement count for letter in 'b'
    }
    // If any count is not zero, strings are not anagrams
    for (int c : cnt)
      if (c != 0)
        return false;
    return true; // All counts are zero, so strings are anagrams
  }
  public static boolean isPalindromeTwoPointer(String input) {
    input = input.replaceAll("[^A-Za-z]", "").toLowerCase();
    int left = 0, right = input.length() -1;
    while (left < right) {
      if (input.charAt(left) != input.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
  public static boolean isPalindromeAnagram(String input) {
    input = input.replaceAll("[^A-Za-z]", "").toLowerCase();
    String reversed = new StringBuilder(input).reverse().toString();
    return input.equals(reversed);
  }

  public static void main(String[] args) {
    String a = "anagram";
    String b = "nagaram";
    //System.out.println(isAnagram(a, b));
    //System.out.println(isAnagram2Way(a, b));
    boolean palindromeTwoPointer = isPalindromeTwoPointer("a");
    System.out.println(palindromeTwoPointer);


  }

}
