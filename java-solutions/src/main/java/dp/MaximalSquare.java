package dp;

/**
 * @author FLIGHT
 * <p>
 * 221. Maximal Square
 * <p>
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 * Example 2:
 * <p>
 * <p>
 * Input: matrix = [["0","1"],["1","0"]]
 * Output: 1
 * Example 3:
 * <p>
 * Input: matrix = [["0"]]
 * Output: 0
 */
public class MaximalSquare {

  public int maximalSquare(char[][] matrix) {
    int maxLength = 0;

    int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];

    for (int row = 1; row <= matrix.length; ++row) {
      for (int column = 1; column <= matrix[0].length; ++column) {
        if (matrix[row - 1][column - 1] == '1') {
          dp[row][column] = min(dp[row - 1][column], dp[row][column - 1], dp[row - 1][column - 1]) + 1;
          maxLength = Math.max(dp[row][column], maxLength);
        }
      }
    }

    return maxLength * maxLength;
  }

  private int min(int first, int second, int third) {
    return Math.min(Math.min(first, second), third);
  }

  public static void main(String[] args) {
    MaximalSquare maximalSquare = new MaximalSquare();

    char[][] matrix = new char[][]{
      {'0', '1', '1', '1', '0'},
      {'1', '1', '1', '1', '1'},
      {'0', '1', '1', '1', '1'},
      {'0', '1', '1', '1', '1'},
      {'0', '0', '1', '1', '1'}
    };

    System.out.println(maximalSquare.maximalSquare(matrix));
  }
}
