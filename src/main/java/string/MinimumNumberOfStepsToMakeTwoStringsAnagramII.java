package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 2186. Minimum Number of Steps to Make Two Strings Anagram II
 *
 * You are given two strings s and t. In one step, you can append any character to either s or t.
 * <p>
 * Return the minimum number of steps to make s and t anagrams of each other.
 * <p>
 * An anagram of a string is a string that contains the same characters with a different (or the same) ordering.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leetcode", t = "coats"
 * Output: 7
 * Explanation:
 * - In 2 steps, we can append the letters in "as" onto s = "leetcode", forming s = "leetcodeas".
 * - In 5 steps, we can append the letters in "leede" onto t = "coats", forming t = "coatsleede".
 * "leetcodeas" and "coatsleede" are now anagrams of each other.
 * We used a total of 2 + 5 = 7 steps.
 * It can be shown that there is no way to make them anagrams of each other with less than 7 steps.
 * Example 2:
 * <p>
 * Input: s = "night", t = "thing"
 * Output: 0
 * Explanation: The given strings are already anagrams of each other. Thus, we do not need any further steps.
 */
public class MinimumNumberOfStepsToMakeTwoStringsAnagramII {

    public int minSteps(String s, String t) {
        Map<Character, Integer> freqMap = new HashMap<>();
        count(freqMap, s, true);
        count(freqMap, t, false);

        int steps = 0;
        for (int value : freqMap.values())
            steps += Math.abs(value);

        return steps;
    }

    private void count(Map<Character, Integer> freqMap, String s, boolean add) {
        for (char c : s.toCharArray()) {
            int frequency = freqMap.getOrDefault(c, 0);
            freqMap.put(c, frequency + (add ? 1 : -1));
        }
    }

}
