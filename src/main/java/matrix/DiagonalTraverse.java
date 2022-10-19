package matrix;


/**
 * 498. Diagonal Traverse
 *
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 * <p>
 * Example 1:
 * <p>
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,4,7,5,3,6,8,9]
 * <p>
 * Example 2:
 * <p>
 * Input: mat = [[1,2],[3,4]]
 * Output: [1,2,3,4]
 */
public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] mat) {
        int columns = mat[0].length, rows = mat.length;
        int[] diagonalOrder = new int[rows * columns];

        for (int i = 0, row = 0, column = 0; i < diagonalOrder.length; ++i) {
            diagonalOrder[i] = mat[row][column];

            if ((row + column) % 2 == 0) {
                if (column == columns - 1)
                    row++;
                else if (row == 0)
                    column++;
                else {
                    row--;
                    column++;
                }

            } else {
                if (row == rows - 1)
                    column++;
                else if (column == 0)
                    row++;
                else {
                    row++;
                    column--;
                }
            }
        }

        return diagonalOrder;
    }
}
