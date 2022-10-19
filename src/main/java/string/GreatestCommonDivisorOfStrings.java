package string;

/**
 * 1071. Greatest Common Divisor of Strings
 * <p>
 * For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
 * <p>
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 */
public class GreatestCommonDivisorOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        for (int index = Math.min(str1.length(), str2.length()) - 1; index >= 0; --index) {
            String prefix = str1.substring(0, index + 1);
            if (isCommonDivisor(str1, str2, prefix))
                return prefix;
        }
        return "";
    }

    private boolean isCommonDivisor(String first, String second, String prefix) {
        if (first.length() % prefix.length() != 0 || second.length() % prefix.length() != 0 || !second.startsWith(prefix))
            return false;

        int firstLength = first.length(), secondLength = second.length(), prefixLength = prefix.length();

        for (int i = 0; i < Math.max(firstLength, secondLength); i += prefixLength) {
            String firstSubstring = i < firstLength ? first.substring(i, i + prefixLength) : "",
                    secondSubstring = i < secondLength ? second.substring(i, i + prefixLength) : "";

            if ((!firstSubstring.isEmpty() && !firstSubstring.equals(prefix)) || !secondSubstring.isEmpty() && !secondSubstring.equals(prefix))
                return false;
        }

        return true;
    }
}
