package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 2094. Finding 3-Digit Even Numbers
 * <p>
 * You are given an integer array digits, where each element is a digit. The array may contain duplicates.
 * <p>
 * You need to find all the unique integers that follow the given requirements:
 * <p>
 * The integer consists of the concatenation of three elements from digits in any arbitrary order.
 * The integer does not have leading zeros.
 * The integer is even.
 * For example, if the given digits were [1, 2, 3], integers 132 and 312 follow the requirements.
 * <p>
 * Return a sorted array of the unique integers.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: digits = [2,1,3,0]
 * Output: [102,120,130,132,210,230,302,310,312,320]
 * Explanation: All the possible integers that follow the requirements are in the output array.
 * Notice that there are no odd integers or integers with leading zeros.
 * Example 2:
 * <p>
 * Input: digits = [2,2,8,8,2]
 * Output: [222,228,282,288,822,828,882]
 * Explanation: The same digit can be used as many times as it appears in digits.
 * In this example, the digit 8 is used twice each time in 288, 828, and 882.
 * Example 3:
 * <p>
 * Input: digits = [3,7,5]
 * Output: []
 * Explanation: No even integers can be formed using the given digits.
 */
public class Finding3DigitEvenNumbers {

    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> evenNumbers = new HashSet<>();
        for (int first = 0; first < digits.length; ++first) {
            for (int second = 0; second < digits.length; ++second) {
                for (int third = 0; third < digits.length; ++third) {
                    if (first != second && second != third && first != third && digits[first] != 0 && digits[third] % 2 == 0) {
                        evenNumbers.add(digits[first] * 100 + digits[second] * 10 + digits[third]);
                    }
                }
            }
        }

        return evenNumbers.stream().sorted().mapToInt(a -> a).toArray();
    }
}
