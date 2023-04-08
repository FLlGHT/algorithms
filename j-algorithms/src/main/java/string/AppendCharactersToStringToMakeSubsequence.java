package string;

/**
 * 2486. Append Characters to String to Make Subsequence
 * <p>
 * You are given two strings s and t consisting of only lowercase English letters.
 * <p>
 * Return the minimum number of characters that need to be appended to the end of s so that t becomes a subsequence of s.
 * <p>
 * A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "coaching", t = "coding"
 * Output: 4
 * Explanation: Append the characters "ding" to the end of s so that s = "coachingding".
 * Now, t is a subsequence of s ("coachingding").
 * It can be shown that appending any 3 characters to the end of s will never make t a subsequence.
 * Example 2:
 * <p>
 * Input: s = "abcde", t = "a"
 * Output: 0
 * Explanation: t is already a subsequence of s ("abcde").
 * Example 3:
 * <p>
 * Input: s = "z", t = "abcde"
 * Output: 5
 * Explanation: Append the characters "abcde" to the end of s so that s = "zabcde".
 * Now, t is a subsequence of s ("zabcde").
 * It can be shown that appending any 4 characters to the end of s will never make t a subsequence.
 */
public class AppendCharactersToStringToMakeSubsequence {

  public int appendCharacters(String word, String subsequence) {
    int alreadyInChars = 0;
    int lastPosition = 0;

    for (char c : subsequence.toCharArray()) {
      int index = word.indexOf(c, lastPosition);
      if (index > -1) {
        lastPosition = index + 1;
        alreadyInChars++;
      }
      else
        break;
    }

    return subsequence.length() - alreadyInChars;
  }
}
