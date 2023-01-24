package math;


/**
 * 2523. Closest Prime Numbers in Range
 * <p>
 * Given two positive integers left and right, find the two integers num1 and num2 such that:
 * <p>
 * left <= nums1 < nums2 <= right .
 * nums1 and nums2 are both prime numbers.
 * nums2 - nums1 is the minimum amongst all other pairs satisfying the above conditions.
 * Return the positive integer array ans = [nums1, nums2]. If there are multiple pairs satisfying these conditions, return the one with the minimum nums1 value or [-1, -1] if such numbers do not exist.
 * <p>
 * A number greater than 1 is called prime if it is only divisible by 1 and itself.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: left = 10, right = 19
 * Output: [11,13]
 * Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
 * The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
 * Since 11 is smaller than 17, we return the first pair.
 * Example 2:
 * <p>
 * Input: left = 4, right = 6
 * Output: [-1,-1]
 * Explanation: There exists only one prime number in the given range, so the conditions cannot be satisfied.
 */
public class ClosestPrimeNumbersInRange {


    public int[] closestPrimes(int left, int right) {
        PrimePair primePair = new PrimePair(0, 0);
        for (int number = Math.max(2, left), lastPrime = 0; number <= right; ++number) {
            if (isPrime(number)) {
                if (lastPrime > 0 && number - lastPrime < primePair.difference()) {
                    primePair = new PrimePair(lastPrime, number);

                    if (number - lastPrime <= 2)
                        return primePair.arrayRepresentation();
                }

                lastPrime = number;
            }
        }
        return primePair.arrayRepresentation();
    }


    private boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; ++i) {
            if (number % i == 0)
                return false;
        }
        return true;
    }


    public record PrimePair(int first, int second) {

        private int difference() {
            return first == 0 ? Integer.MAX_VALUE : second - first;
        }

        private int[] arrayRepresentation() {
            return first == 0 ? new int[] {-1, -1} : new int[] {first, second};
        }
    }
}
