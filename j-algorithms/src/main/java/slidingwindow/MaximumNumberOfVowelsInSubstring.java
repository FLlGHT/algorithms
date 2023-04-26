package slidingwindow;
import java.util.Set;

/**
 * 1456. Maximum Number of Vowels in a Substring of Given Length
 * <p>
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 * <p>
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 * Example 2:
 * <p>
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 * Example 3:
 * <p>
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 */

public class MaximumNumberOfVowelsInSubstring {

  public int maxVowels(String s, int k) {
    Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
    int currentVowels = 0, maxVowels = 0;

    for (int right = 0; right < s.length(); ++right) {
      char newLetter = s.charAt(right);
      if (right >= k && vowels.contains(s.charAt(right - k))) {
        currentVowels--;
      }
      if (vowels.contains(newLetter)) {
        currentVowels++;
        maxVowels = Math.max(currentVowels, maxVowels);
      }
    }

    return maxVowels;
  }
}
