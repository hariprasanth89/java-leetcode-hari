package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static void main(String[] args) {

    List<String> listItem = new ArrayList<>();
    listItem.add("leet");
    listItem.add("code");

       String s = "leetcode";
        String[] wordDict = {"leed","code"};

        System.out.println(wordBreak(s, listItem));
        String s1 = "applepenapple";
        String[] wordDict1 = {"apple", "pen"};
       // System.out.println(wordBreak(s1, wordDict1));

        String s2 = "catsandog";
        String[] wordDict2 = {"cats", "dog", "sand", "and", "cat"};
        //System.out.println(wordBreak(s2, wordDict2));


    }
}
