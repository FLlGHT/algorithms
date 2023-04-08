package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 2606. Find the Substring With Maximum Cost
 * <p>
 * You are given a string s, a string chars of distinct characters and an integer array vals of the same length as chars.
 * <p>
 * The cost of the substring is the sum of the values of each character in the substring. The cost of an empty string is considered 0.
 * <p>
 * The value of the character is defined in the following way:
 * <p>
 * If the character is not in the string chars, then its value is its corresponding position (1-indexed) in the alphabet.
 * For example, the value of 'a' is 1, the value of 'b' is 2, and so on. The value of 'z' is 26.
 * Otherwise, assuming i is the index where the character occurs in the string chars, then its value is vals[i].
 * Return the maximum cost among all substrings of the string s.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "adaa", chars = "d", vals = [-1000]
 * Output: 2
 * Explanation: The value of the characters "a" and "d" is 1 and -1000 respectively.
 * The substring with the maximum cost is "aa" and its cost is 1 + 1 = 2.
 * It can be proven that 2 is the maximum cost.
 * Example 2:
 * <p>
 * Input: s = "abc", chars = "abc", vals = [-1,-1,-1]
 * Output: 0
 * Explanation: The value of the characters "a", "b" and "c" is -1, -1, and -1 respectively.
 * The substring with the maximum cost is the empty substring "" and its cost is 0.
 * It can be proven that 0 is the maximum cost.
 */
public class FindTheSubstringWithMaximumCost {

  public int maximumCostSubstring(String s, String chars, int[] vals) {
    Map<Character, Integer> cost = new HashMap<>();

    for (int i = 0; i < chars.length(); ++i) {
      cost.put(chars.charAt(i), vals[i]);
    }

    int currentCost = 0, maxCost = 0;
    for (int i = 0; i < s.length(); ++i) {
      int letterCost = cost.getOrDefault(s.charAt(i), s.charAt(i) - 'a' + 1);
      currentCost = Math.max(0, currentCost + letterCost);
      maxCost = Math.max(currentCost, maxCost);
    }

    return maxCost;
  }
}
