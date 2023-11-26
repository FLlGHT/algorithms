package simulation;


/**
 * 2257. Count Unguarded Cells in the Grid
 * <p>
 * You are given two integers m and n representing a 0-indexed m x n grid.
 * You are also given two 2D integer arrays guards and walls where guards[i] = [rowi, coli] and walls[j] = [rowj, colj]
 * represent the positions of the ith guard and jth wall respectively.
 * <p>
 * A guard can see every cell in the four cardinal directions (north, east, south, or west)
 * starting from their position unless obstructed by a wall or another guard. A cell is guarded if there is at least one guard that can see it.
 * <p>
 * Return the number of unoccupied cells that are not guarded.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
 * Output: 7
 * Explanation: The guarded and unguarded cells are shown in red and green respectively in the above diagram.
 * There are a total of 7 unguarded cells, so we return 7.
 * <p>
 * Example 2:
 * <p>
 * Input: m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
 * Output: 4
 * Explanation: The unguarded cells are shown in green in the above diagram.
 * There are a total of 4 unguarded cells, so we return 4.
 */
public class CountUnguardedCellsInTheGrid {

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] matrix = new char[m][n]; int unguarded = m * n - guards.length - walls.length;
        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] wall : walls) matrix[wall[0]][wall[1]] = 'W';
        for (int[] guard : guards) matrix[guard[0]][guard[1]] = 'G';

        for (int[] guard : guards) {
            for (int[] direction : directions) {
                int row = guard[0] + direction[0]; int column = guard[1] + direction[1];

                while (row >= 0 && row < m && column >= 0 && column < n && matrix[row][column] != 'W' && matrix[row][column] != 'G') {
                    if (matrix[row][column] != 'S')
                        unguarded--;

                    matrix[row][column] = 'S';
                    row = row + direction[0]; column = column + direction[1];
                }
            }
        }


        return unguarded;
    }
}
