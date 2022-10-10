package dfs;


/**
 * 1254. Number of Closed Islands
 * <p>
 * Given a 2D grid consists of 0s (land) and 1s (water).
 * An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
 * <p>
 * Return the number of closed islands.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * Output: 2
 * Explanation:
 * Islands in gray are closed because they are completely surrounded by water (group of 1s).
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * Output: 1
 * Example 3:
 * <p>
 * Input: grid = [[1,1,1,1,1,1,1],
 * [1,0,0,0,0,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,1,0,1,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,0,0,0,0,1],
 * [1,1,1,1,1,1,1]]
 * Output: 2
 */
public class NumberOfClosedIslands {

    public int closedIsland(int[][] grid) {
        int count = 0;

        for (int row = 0; row < grid.length; ++row) {
            for (int column = 0; column < grid[0].length; ++column) {
                if (grid[row][column] == 0 && isClosed(row, column, grid))
                    count++;
            }
        }

        return count;
    }

    private boolean isClosed(int row, int column, int[][] grid) {
        if (row < 0 || row >= grid.length || column >= grid[0].length || column < 0)
            return false;

        if (grid[row][column] == 1)
            return true;

        grid[row][column] = 1;

        return (isClosed(row + 1, column, grid) & isClosed(row - 1, column, grid)
                & isClosed(row, column + 1, grid) & isClosed(row, column - 1, grid));
    }
}
