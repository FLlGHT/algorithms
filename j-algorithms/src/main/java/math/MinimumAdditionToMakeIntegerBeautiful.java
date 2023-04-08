package math;


/**
 * 2457. Minimum Addition to Make Integer Beautiful
 * <p>
 * You are given two positive integers n and target.
 * <p>
 * An integer is considered beautiful if the sum of its digits is less than or equal to target.
 * <p>
 * Return the minimum non-negative integer x such that n + x is beautiful.
 * The input will be generated such that it is always possible to make n beautiful.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 16, target = 6
 * Output: 4
 * Explanation: Initially n is 16 and its digit sum is 1 + 6 = 7. After adding 4, n becomes 20 and digit sum becomes 2 + 0 = 2.
 * It can be shown that we can not make n beautiful with adding non-negative integer less than 4.
 * Example 2:
 * <p>
 * Input: n = 467, target = 6
 * Output: 33
 * Explanation: Initially n is 467 and its digit sum is 4 + 6 + 7 = 17. After adding 33, n becomes 500 and digit sum becomes 5 + 0 + 0 = 5.
 * It can be shown that we can not make n beautiful with adding non-negative integer less than 33.
 * Example 3:
 * <p>
 * Input: n = 1, target = 1
 * Output: 0
 * Explanation: Initially n is 1 and its digit sum is 1, which is already smaller than or equal to target.
 */
public class MinimumAdditionToMakeIntegerBeautiful {

    public long makeIntegerBeautiful(long n, int target) {
        long value = n, base = 1;

        while (sum(value) > target) {
            value = value / 10 + 1;
            base = base * 10;
        }

        return value * base - n;
    }

    private int sum(long number) {
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }

        return sum;
    }
}
