package string;

/**
 * 2414. Length of the Longest Alphabetical Continuous Substring
 * <p>
 * An alphabetical continuous string is a string consisting of consecutive letters in the alphabet.
 * In other words, it is any substring of the string "abcdefghijklmnopqrstuvwxyz".
 * <p>
 * For example, "abc" is an alphabetical continuous string, while "acb" and "za" are not.
 * Given a string s consisting of lowercase letters only, return the length of the longest alphabetical continuous substring.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abacaba"
 * Output: 2
 * Explanation: There are 4 distinct continuous substrings: "a", "b", "c" and "ab".
 * "ab" is the longest continuous substring.
 * Example 2:
 * <p>
 * Input: s = "abcde"
 * Output: 5
 * Explanation: "abcde" is the longest continuous substring.
 */
public class LengthOfTheLongestAlphabeticalContinuousSubstring {

    public int longestContinuousSubstring(String s) {
        int longest = 1, current = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) - s.charAt(i - 1) == 1)
                current++;
            else
                current = 1;

            longest = Math.max(current, longest);
        }

        return longest;
    }
}
