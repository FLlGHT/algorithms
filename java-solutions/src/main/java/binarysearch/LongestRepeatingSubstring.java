package binarysearch;

import java.util.HashSet;
import java.util.Set;

/**
 * @author FLIGHT
 * <p>
 * /**
 * * 1062. Longest Repeating Substring
 * * <p>
 * * Given a string s, return the length of the longest repeating substrings.
 * * If no repeating substring exists, return 0.
 * * <p>
 * * <p>
 * * <p>
 * * Example 1:
 * * <p>
 * * Input: s = "abcd"
 * * Output: 0
 * * Explanation: There is no repeating substring.
 * * Example 2:
 * * <p>
 * * Input: s = "abbaba"
 * * Output: 2
 * * Explanation: The longest repeating substrings are "ab" and "ba", each of which occurs twice.
 * * Example 3:
 * * <p>
 * * Input: s = "aabcaabdaab"
 * * Output: 3
 * * Explanation: The longest repeating substring is "aab", which occurs 3 times.
 * * <p>
 * * 1 <= s.length <= 2000
 */


public class LongestRepeatingSubstring {

  public int longestRepeatingSubstring(String s) {
    int left = 0, right = s.length(), result = 0;

    while (left <= right) {
      int middle = left + (right - left) / 2;
      if (contains(s, middle)) {
        result = middle;
        left = middle + 1;
      } else
        right = middle - 1;
    }

    return result;
  }

  private boolean contains(String s, int length) {
    Set<String> substrings = new HashSet<>();

    for (int start = 0; start <= s.length() - length; ++start) {
      String substring = s.substring(start, start + length);
      if (substrings.contains(substring))
        return true;

      substrings.add(substring);
    }

    return false;
  }
}
