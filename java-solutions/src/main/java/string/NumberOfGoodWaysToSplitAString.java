package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 1525. Number of Good Ways to Split a String
 * <p>
 * You are given a string s.
 * <p>
 * A split is called good if you can split s into two non-empty strings sleft and sright where their concatenation is equal to s (i.e., sleft + sright = s) and the number of distinct letters in sleft and sright is the same.
 * <p>
 * Return the number of good splits you can make in s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aacaba"
 * Output: 2
 * Explanation: There are 5 ways to split "aacaba" and 2 of them are good.
 * ("a", "acaba") Left string and right string contains 1 and 3 different letters respectively.
 * ("aa", "caba") Left string and right string contains 1 and 3 different letters respectively.
 * ("aac", "aba") Left string and right string contains 2 and 2 different letters respectively (good split).
 * ("aaca", "ba") Left string and right string contains 2 and 2 different letters respectively (good split).
 * ("aacab", "a") Left string and right string contains 3 and 1 different letters respectively.
 * Example 2:
 * <p>
 * Input: s = "abcd"
 * Output: 1
 * Explanation: Split the string as follows ("ab", "cd").
 */
public class NumberOfGoodWaysToSplitAString {


    public int numSplits(String s) {
        int goodSplits = 0;

        Map<Character, Integer> rightMap = toFreqMap(s);
        Map<Character, Integer> leftMap = new HashMap<>();

        for (int i = 0; i < s.length() - 1; ++i) {
            char letter = s.charAt(i);
            leftMap.put(letter, leftMap.getOrDefault(letter, 0) + 1);
            rightMap.put(letter, rightMap.getOrDefault(letter, 0) - 1);

            if (rightMap.get(letter) == 0)
                rightMap.remove(letter);

            if (leftMap.size() == rightMap.size())
                goodSplits++;
        }

        return goodSplits;
    }

    private Map<Character, Integer> toFreqMap(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }
}
