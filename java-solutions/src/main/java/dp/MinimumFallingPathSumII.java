package dp;

/**
 * @author FLIGHT
 * <p>
 * 1289. Minimum Falling Path Sum II
 * <p>
 * Given an n x n integer matrix grid, return the minimum sum of a falling path with non-zero shifts.
 * <p>
 * A falling path with non-zero shifts is a choice of exactly one element from each row of grid
 * such that no two elements chosen in adjacent rows are in the same column.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: 13
 * Explanation:
 * The possible falling paths are:
 * [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 * [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 * [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 * The falling path with the smallest sum is [1,5,7], so the answer is 13.
 * Example 2:
 * <p>
 * Input: grid = [[7]]
 * Output: 7
 */
public class MinimumFallingPathSumII {

  public int minFallingPathSum(int[][] grid) {
    int[][] dp = new int[grid.length][grid[0].length];

    for (int row = 0; row < grid.length; ++row) {
      for (int column = 0; column < grid[0].length; ++column) {
        if (row == 0)
          dp[row][column] = grid[row][column];
        else
          dp[row][column] = grid[row][column] + findMinValue(dp, row, column);
      }
    }

    return findMinValue(dp);
  }

  private int findMinValue(int[][] dp) {
    int min = Integer.MAX_VALUE;
    for (int column = 0; column < dp[0].length; ++column) {
      min = Math.min(dp[dp.length - 1][column], min);
    }
    return min;
  }

  private int findMinValue(int[][] dp, int row, int column) {
    int minValue = Integer.MAX_VALUE;
    for (int upperColumn = 0; upperColumn < dp[0].length; ++upperColumn) {
      if (upperColumn != column) {
        minValue = Math.min(minValue, dp[row - 1][upperColumn]);
      }
    }
    return minValue;
  }

}
