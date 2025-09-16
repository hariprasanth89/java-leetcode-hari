package org.example.leetcode.mediam.dynamicprogramming;

import java.util.*;

public class WordBreak139 {

public static boolean wordBreak(String s, String[] wordDict) {
    List<String> wordList = Arrays.asList(wordDict);
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true; // Base case: empty string can always be segmented

    for (int i = 1; i <= s.length(); i++) {
        for (int j = 0; j < i; j++) {
            if (dp[j] && wordList.contains(s.substring(j, i))) {
                dp[i] = true;
                break;
            }
        }
    }
    return dp[s.length()];
}
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String w : wordDict) {
                int start = i - w.length();
                if (start >= 0 && dp[start] && s.substring(start, i).equals(w)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    //  different approach
    public static boolean wordBreakDifferent(String s, List<String> wordDict) {
        // Convert the dictionary to a set for O(1) lookups
        Set<String> wordSet = new HashSet<>(wordDict);

        // Find the maximum word length in the dictionary
        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }

        int n = s.length();
        // dp[i] states if the substring s[0..i] can be segmented
        boolean[] dp = new boolean[n + 1];

        // Base case: empty string is valid
        dp[0] = true;

        for (int i = 1; i <= n; i++)

            // Check prefixes of length up to maxLen
            for (int j = i - 1; j >= Math.max(0, i - maxLen); j--)
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further prefixes
                }

        return dp[n];
    }

    public static boolean wordBreakTesting(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int max = 0;
        for (String str : wordDict){
            max = Math.max(max, str.length());
        }
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i = 1; i <=n; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordSet.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];

    }

    public static void main(String[] args) {

    List<String> listItem = new ArrayList<>();
    listItem.add("leet");
    listItem.add("code");

       String s = "leetcode";
//        String[] wordDict = {"leed","code"};
//
//        System.out.println(wordBreak(s, listItem));
//        String s1 = "applepenapple";
//        String[] wordDict1 = {"apple", "pen"};
//       // System.out.println(wordBreak(s1, wordDict1));
//
//        String s2 = "catsandog";
//        String[] wordDict2 = {"cats", "dog", "sand", "and", "cat"};
//        //System.out.println(wordBreak(s2, wordDict2));
       // System.out.println(wordBreakDifferent(s,listItem));
        System.out.println(wordBreakTesting(s,listItem));


    }
}
