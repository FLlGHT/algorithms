package dfs;


/**
 * 1267. Count Servers that Communicate
 * <p>
 * You are given a map of a server center, represented as a m * n integer matrix grid,
 * where 1 means that on that cell there is a server and 0 means that it is no server.
 * Two servers are said to communicate if they are on the same row or on the same column.
 * <p>
 * Return the number of servers that communicate with any other server.
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [[1,0],[0,1]]
 * Output: 0
 * Explanation: No servers can communicate with others.
 * <p>
 * Example 2:
 * <p>
 * Input: grid = [[1,0],[1,1]]
 * Output: 3
 * Explanation: All three servers can communicate with at least one other server.
 * <p>
 * Example 3:
 * <p>
 * Input: grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
 * Output: 4
 * Explanation: The two servers in the first row can communicate with each other.
 * The two servers in the third column can communicate with each other. The server at right bottom corner can't communicate with any other server.
 */
public class CountServersThatCommunicate {

    public int countServers(int[][] grid) {

        int connected = 0;
        for (int row = 0; row < grid.length; ++row) {
            for (int column = 0; column < grid[0].length; ++column) {
                if (grid[row][column] == 1 && isConnected(grid, row, column))
                    connected++;
            }
        }
        return connected;
    }

    private boolean isConnected(int[][] grid, int row, int column) {
        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] direction : directions) {
            int newRow = row + direction[0], newColumn = column + direction[1];
            while (newRow >= 0 && newRow < grid.length && newColumn >= 0 && newColumn < grid[0].length) {
                if (grid[newRow][newColumn] == 1)
                    return true;
                newRow += direction[0];
                newColumn += direction[1];
            }
        }
        return false;
    }
}
