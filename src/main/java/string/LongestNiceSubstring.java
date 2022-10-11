package string;

/**
 * 1763. Longest Nice Substring
 * <p>
 * A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase.
 * For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.
 * <p>
 * Given a string s, return the longest substring of s that is nice.
 * If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "YazaAay"
 * Output: "aAa"
 * Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
 * "aAa" is the longest nice substring.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: s = "Bb"
 * Output: "Bb"
 * Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: s = "c"
 * Output: ""
 * Explanation: There are no nice substrings.
 */
public class LongestNiceSubstring {

    public String longestNiceSubstring(String s) {
        String longest = "";
        for (int start = 0; start < s.length(); ++start) {
            for (int end = start; end < s.length(); ++end) {
                if (end - start >= longest.length()) {
                    String substring = s.substring(start, end + 1);
                    if (isNice(substring))
                        longest = substring;
                }
            }
        }
        return longest;
    }

    private boolean isNice(String substring) {
        for (char c : substring.toCharArray()) {
            if ((Character.isUpperCase(c) && !substring.contains("" + Character.toLowerCase(c))) ||
                    (Character.isLowerCase(c) && !substring.contains("" + Character.toUpperCase(c))))
                return false;
        }

        return true;
    }
}
