package org.example.interview;

public class FirstNonRepeating {
  public static Character firstNonRepeating(String s) {
    int[] cnt = new int[256];
    for (char ch : s.toCharArray()) cnt[ch]++;
    for (char ch : s.toCharArray()) if (cnt[ch] == 1) return ch;
    return null;
  }
}
