package matrix;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 1030. Matrix Cells in Distance Order
 * <p>
 * You are given four integers row, cols, rCenter, and cCenter.
 * There is a rows x cols matrix and you are on the cell with the coordinates (rCenter, cCenter).
 * <p>
 * Return the coordinates of all cells in the matrix, sorted by their distance from (rCenter, cCenter) from the smallest distance to the largest distance.
 * You may return the answer in any order that satisfies this condition.
 * <p>
 * The distance between two cells (r1, c1) and (r2, c2) is |r1 - r2| + |c1 - c2|.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: rows = 1, cols = 2, rCenter = 0, cCenter = 0
 * Output: [[0,0],[0,1]]
 * Explanation: The distances from (0, 0) to other cells are: [0,1]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: rows = 2, cols = 2, rCenter = 0, cCenter = 1
 * Output: [[0,1],[0,0],[1,1],[1,0]]
 * Explanation: The distances from (0, 1) to other cells are: [0,1,1,2]
 * The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: rows = 2, cols = 3, rCenter = 1, cCenter = 2
 * Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * Explanation: The distances from (1, 2) to other cells are: [0,1,1,2,2,3]
 * There are other answers that would also be accepted as correct, such as [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].
 */
public class MatrixCellsInDistanceOrder {

    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        List<Cell> cells = new ArrayList<>();

        for (int row = 0; row < rows; ++row)
            for (int column = 0; column < cols; ++column)
                cells.add(new Cell(row, column, Math.abs(row - rCenter) + Math.abs(column - cCenter)));

        return cells.stream().sorted(Comparator.comparing(Cell::distance)).map(cell -> new int[] {cell.row(), cell.column()}).toArray(int[][]::new);
    }

    private record Cell(int row, int column, int distance) {}
}
