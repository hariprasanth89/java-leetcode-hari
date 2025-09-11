package org.example.leetcode.dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakOptimizedDP139 {
    /**
     * Optimized solution for Word Break using Dynamic Programming (Bottom-Up).
     *
     * Time Complexity: O(n^2 * L) where n is the length of string s, and L is the average length
     * of words in the dictionary. The nested loops run O(n^2) times, and
     * substring operation can take O(L) time. Hashset lookup is O(L) on average
     * (due to hashing string). If we consider dictionary words to have bounded length,
     * it's often simplified to O(n^2).
     * Space Complexity: O(n) for the dp array and O(M*L_max) for the wordDictSet (M words, max length L_max).
     *
     * @param s The input string.
     * @param wordDict The dictionary of words.
     * @return true if s can be segmented, false otherwise.
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        int n = s.length();

        // dp[i] will be true if s.substring(0, i) can be segmented.
        // dp array size n + 1: index 0 to n.
        // dp[0] represents an empty string, which can always be segmented (base case).
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        // Iterate through all possible end points (i) of the current prefix.
        // i goes from 1 to n (length of string s)
        for (int i = 1; i <= n; i++) {
            // Iterate through all possible split points (j) for the prefix s.substring(0, i).
            // j goes from 0 to i - 1
            for (int j = 0; j < i; j++) {
                // If the prefix s.substring(0, j) can be segmented (dp[j] is true)
                // AND the current segment s.substring(j, i) is a word in the dictionary
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true; // Then s.substring(0, i) can be segmented
                    break;        // Once dp[i] is true, no need to check other split points for this 'i'
                }
            }
        }

        // The final answer is whether the entire string s (s.substring(0, n)) can be segmented.
        return dp[n];
    }

    public static void main(String[] args) {
        WordBreakOptimizedDP139 solver = new WordBreakOptimizedDP139();

        // Example 1
        String s1 = "leetcode";
        List<String> wordDict1 = Arrays.asList("leet", "code");
        System.out.println(s1 + ", dict: " + wordDict1 + " -> " + solver.wordBreak(s1, wordDict1)); // true

        // Example 2
        String s2 = "applepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen");
        System.out.println(s2 + ", dict: " + wordDict2 + " -> " + solver.wordBreak(s2, wordDict2)); // true

        // Example 3
        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(s3 + ", dict: " + wordDict3 + " -> " + solver.wordBreak(s3, wordDict3)); // false

        // Example 4 (Previous worst case, now fast)
        String s4 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"; // length ~ 150
        List<String> wordDict4 = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
        System.out.println(s4 + ", dict: " + wordDict4 + " -> " + solver.wordBreak(s4, wordDict4)); // true
    }
}
