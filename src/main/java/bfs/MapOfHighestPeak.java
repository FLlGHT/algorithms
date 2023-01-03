package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1765. Map of The Highest Peak
 *
 * You are given an integer matrix isWater of size m x n that represents a map of land and water cells.
 * <p>
 * If isWater[i][j] == 0, cell (i, j) is a land cell.
 * If isWater[i][j] == 1, cell (i, j) is a water cell.
 * You must assign each cell a height in a way that follows these rules:
 * <p>
 * The height of each cell must be non-negative.
 * If the cell is a water cell, its height must be 0.
 * Any two adjacent cells must have an absolute height difference of at most 1.
 * A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter
 * (i.e., their sides are touching).
 * Find an assignment of heights such that the maximum height in the matrix is maximized.
 * <p>
 * Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height.
 * If there are multiple solutions, return any of them.
 */
public class MapOfHighestPeak {

  public int[][] highestPeak(int[][] isWater) {
    int[][] result = new int[isWater.length][isWater[0].length];

    Queue<int[]> cells = findWaterCells(isWater, result);
    return bfs(cells, result);
  }

  private Queue<int[]> findWaterCells(int[][] isWater, int[][] result) {
    Queue<int[]> cells = new LinkedList<>();
    for (int row = 0; row < isWater.length; ++row) {
      for (int column = 0; column < isWater[0].length; ++column) {
        if (isWater[row][column] == 1)
          cells.offer(new int[]{row, column});
        else
          result[row][column] = -1;
      }
    }
    return cells;
  }

  private int[][] bfs(Queue<int[]> cells, int[][] result) {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    while (!cells.isEmpty()) {
      int[] cell = cells.poll();
      int row = cell[0], column = cell[1];

      for (int[] direction : directions) {
        int newRow = row + direction[0], newColumn = column + direction[1];
        if (newRow < 0 || newRow >= result.length
          || newColumn < 0 || newColumn >= result[0].length
          || result[newRow][newColumn] != -1)
          continue;

        result[newRow][newColumn] = result[row][column] + 1;
        cells.offer(new int[]{newRow, newColumn});
      }
    }
    return result;
  }
}
