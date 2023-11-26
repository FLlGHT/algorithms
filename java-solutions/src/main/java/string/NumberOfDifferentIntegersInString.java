package string;

import java.util.HashSet;
import java.util.Set;

/**
 * 1805. Number of Different Integers in a String
 * <p>
 * You are given a string word that consists of digits and lowercase English letters.
 * <p>
 * You will replace every non-digit character with a space. For example, "a123bc34d8ef34" will become " 123  34 8  34".
 * Notice that you are left with some integers that are separated by at least one space: "123", "34", "8", and "34".
 * <p>
 * Return the number of different integers after performing the replacement operations on word.
 * <p>
 * Two integers are considered different if their decimal representations without any leading zeros are different.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: word = "a123bc34d8ef34"
 * Output: 3
 * Explanation: The three different integers are "123", "34", and "8". Notice that "34" is only counted once.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: word = "leet1234code234"
 * Output: 2
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: word = "a1b01c001"
 * Output: 1
 * Explanation: The three integers "1", "01", and "001" all represent the same integer because
 * the leading zeros are ignored when comparing their decimal values.
 */
public class NumberOfDifferentIntegersInString {

    public int numDifferentIntegers(String word) {
        Set<String> differentIntegers = new HashSet<>();

        for (int start = 0, end = start; start < word.length(); ++start, end = start) {
            if (Character.isDigit(word.charAt(start))) {
                while (end < word.length() && Character.isDigit(word.charAt(end)))
                    end++;

                differentIntegers.add(replaceZeroStart(word.substring(start, end)));
                start = end;
            }
        }

        return differentIntegers.size();
    }

    private String replaceZeroStart(String inputString) {
        while (inputString.startsWith("0"))
            inputString = inputString.replaceFirst("0", "");

        return inputString;
    }
}
