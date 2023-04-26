package matrix;

/**
 * 2614. Prime In Diagonal
 * You are given a 0-indexed two-dimensional integer array nums.
 * <p>
 * Return the largest prime number that lies on at least one of the diagonals of nums.
 * In case, no prime is present on any of the diagonals, return 0.
 * <p>
 * Note that:
 * <p>
 * An integer is prime if it is greater than 1 and has no positive integer divisors other than 1 and itself.
 * An integer val is on one of thediagonals of nums if there exists an integer i for which nums[i][i] = val or an i for which nums[i][nums.length - i - 1]= val.
 * <p>
 * <p>
 * In the above diagram, one diagonal is [1,5,9] and another diagonal is [3,5,7].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [[1,2,3],[5,6,7],[9,10,11]]
 * Output: 11
 * Explanation: The numbers 1, 3, 6, 9, and 11 are the only numbers present on at least one of the diagonals. Since 11 is the largest prime, we return 11.
 * Example 2:
 * <p>
 * Input: nums = [[1,2,3],[5,17,7],[9,11,10]]
 * Output: 17
 * Explanation: The numbers 1, 3, 9, 10, and 17 are all present on at least one of the diagonals. 17 is the largest prime, so we return 17.
 */
public class PrimeInDiagonal {

  public int diagonalPrime(int[][] nums) {
    int maxPrime = 0;
    for (int i = 0; i < nums.length; ++i) {
      for (int j = 0; j < nums[0].length; ++j) {
        boolean inMainDiagonal = i == j;
        boolean inAntiDiagonal = i == nums[0].length - j - 1;

        if ((inMainDiagonal || inAntiDiagonal) && nums[i][j] > maxPrime && isPrime(nums[i][j]))
          maxPrime = nums[i][j];
      }
    }

    return maxPrime;
  }

  private boolean isPrime(int number) {
    if (number < 2)
      return false;

    for (int divider = 2; divider <= number / 2; ++divider) {
      if (number % divider == 0)
        return false;
    }

    return true;
  }
}
