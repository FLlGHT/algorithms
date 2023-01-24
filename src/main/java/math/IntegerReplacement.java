package math;


/**
 * 397. Integer replacement
 * <p>
 * Given a positive integer n, you can apply one of the following operations:
 * <p>
 * If n is even, replace n with n / 2.
 * If n is odd, replace n with either n + 1 or n - 1.
 * Return the minimum number of operations needed for n to become 1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 8
 * Output: 3
 * Explanation: 8 -> 4 -> 2 -> 1
 * Example 2:
 * <p>
 * Input: n = 7
 * Output: 4
 * Explanation: 7 -> 8 -> 4 -> 2 -> 1
 * or 7 -> 6 -> 3 -> 2 -> 1
 * Example 3:
 * <p>
 * Input: n = 4
 * Output: 2
 */
public class IntegerReplacement {

    public int integerReplacement(int n) {
        return replace(n);
    }

    public int replace(long n) {
        if (n == 1)
            return 0;

        if (n % 2 == 0)
            return 1 + replace(n / 2);

        else
            return 1 + Math.min(replace(n + 1), replace(n - 1));
    }
}
