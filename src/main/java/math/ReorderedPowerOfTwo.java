package math;

import java.util.Arrays;

/**
 *
 * 869. Reordered Power of 2
 *
 *
 * You are given an integer n. We reorder the digits in any order (including the original order)
 * such that the leading digit is not zero.
 * <p>
 * Return true if and only if we can do this so that the resulting number is a power of two.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1
 * Output: true
 * Example 2:
 * <p>
 * Input: n = 10
 * Output: false
 */

public class ReorderedPowerOfTwo {

    public boolean reorderedPowerOf2(int n) {
        char[] number = sortedDigits(n);

        for (int i = 0; i < 30; ++i) {
            char[] powerOfTwo = sortedDigits(1 << i);
            if (Arrays.equals(number, powerOfTwo))
                return true;
        }
        return false;
    }

    private char[] sortedDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        Arrays.sort(digits);
        return digits;
    }
}
