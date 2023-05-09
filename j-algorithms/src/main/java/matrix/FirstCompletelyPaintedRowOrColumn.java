package matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2661. First Completely Painted Row or Column
 * You are given a 0-indexed integer array arr, and an m x n integer matrix mat. arr and mat both contain all the integers in the range [1, m * n].
 * <p>
 * Go through each index i in arr starting from index 0 and paint the cell in mat containing the integer arr[i].
 * <p>
 * Return the smallest index i at which either a row or a column will be completely painted in mat.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * image explanation for example 1
 * Input: arr = [1,3,4,2], mat = [[1,4],[2,3]]
 * Output: 2
 * Explanation: The moves are shown in order, and both the first row and second column of the matrix become fully painted at arr[2].
 * Example 2:
 * <p>
 * image explanation for example 2
 * Input: arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
 * Output: 3
 * Explanation: The second column becomes fully painted at arr[3].
 */
public class FirstCompletelyPaintedRowOrColumn {

  public int firstCompleteIndex(int[] numbers, int[][] matrix) {
    Map<Integer, Set<Integer>> rows = new HashMap<>();
    Map<Integer, Set<Integer>> columns = new HashMap<>();
    Map<Integer, Coordinates> coordinates = new HashMap<>();

    for (int row = 0; row < matrix.length; ++row) {
      for (int column = 0; column < matrix[0].length; ++column) {
        rows.computeIfAbsent(row, p -> new HashSet<>()).add(matrix[row][column]);
        columns.computeIfAbsent(column, p -> new HashSet<>()).add(matrix[row][column]);
        coordinates.put(matrix[row][column], new Coordinates(row, column));
      }
    }

    for (int index = 0; index < numbers.length; ++index) {
      int number = numbers[index];

      Coordinates numberCoordinates = coordinates.get(number);
      int row = numberCoordinates.row(), column = numberCoordinates.column();

      rows.get(row).remove(number);
      columns.get(column).remove(number);

      if (rows.get(row).isEmpty() || columns.get(column).isEmpty())
        return index;
    }

    return numbers.length - 1;
  }

  private record Coordinates(int row, int column) {}
}
