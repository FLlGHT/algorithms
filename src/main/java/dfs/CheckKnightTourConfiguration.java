package dfs;

/**
 * 2596. Check Knight Tour Configuration
 * <p>
 * There is a knight on an n x n chessboard.
 * In a valid configuration, the knight starts at the top-left cell of the board and visits every cell on the board exactly once.
 * <p>
 * You are given an n x n integer matrix grid consisting of distinct integers from the range [0, n * n - 1]
 * where grid[row][col] indicates that the cell (row, col) is the grid[row][col]th cell that the knight visited.
 * The moves are 0-indexed.
 * <p>
 * Return true if grid represents a valid configuration of the knight's movements or false otherwise.
 * <p>
 * Note that a valid knight move consists of moving two squares vertically and one square horizontally,
 * or two squares horizontally and one square vertically.
 * The figure below illustrates all the possible eight moves of a knight from some cell.
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[0,11,16,5,20],[17,4,19,10,15],[12,1,8,21,6],[3,18,23,14,9],[24,13,2,7,22]]
 * Output: true
 * Explanation: The above diagram represents the grid. It can be shown that it is a valid configuration.
 * Example 2:
 * <p>
 * <p>
 * Input: grid = [[0,3,6],[5,8,1],[2,7,4]]
 * Output: false
 * Explanation: The above diagram represents the grid. The 8th move of the knight is not valid considering its position after the 7th move.
 */
public class CheckKnightTourConfiguration {

  private final int[][] directions = new int[][]{{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};

  public boolean checkValidGrid(int[][] grid) {
    int start = 0, finish = grid.length * grid[0].length - 1;
    return dfs(grid, 0, 0, start - 1, finish);
  }

  private boolean dfs(int[][] grid, int row, int column, int previous, int finish) {
    boolean outside = row < 0 || row >= grid.length || column < 0 || column >= grid[0].length;
    if (outside || previous + 1 != grid[row][column])
      return false;

    if (grid[row][column] == finish)
      return true;

    for (int[] direction : directions) {
      if (dfs(grid, row + direction[0], column + direction[1], grid[row][column], finish))
        return true;
    }

    return false;
  }
}
