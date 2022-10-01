package binarysearch;

import java.util.List;


/**
 * 1428. Leftmost Column with at Least a One
 * <p>
 * A row-sorted binary matrix means that all elements are 0 or 1 and each row of the matrix is sorted in non-decreasing order.
 * <p>
 * Given a row-sorted binary matrix binaryMatrix, return the index (0-indexed) of the leftmost column with a 1 in it.
 * If such an index does not exist, return -1.
 * <p>
 * You can't access the Binary Matrix directly. You may only access the matrix using a BinaryMatrix interface:
 * <p>
 * BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
 * BinaryMatrix.dimensions() returns the dimensions of the matrix as a list of 2 elements [rows, cols], which means the matrix is rows x cols.
 * Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.
 * Also, any solutions that attempt to circumvent the judge will result in disqualification.
 * <p>
 * For custom testing purposes, the input will be the entire binary matrix mat. You will not have access to the binary matrix directly.
 * <p>
 * Example 1:
 * <p>
 * Input: mat = [[0,0],[1,1]]
 * Output: 0
 * <p>
 * Example 2:
 * <p>
 * Input: mat = [[0,0],[0,1]]
 * Output: 1
 * Example 3:
 * <p>
 * Input: mat = [[0,0],[0,0]]
 * Output: -1
 */
public class LeftmostColumnWithAtLeastAOne {

    interface BinaryMatrix {

        public int get(int row, int col);

        public List<Integer> dimensions();
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int rows = dimensions.get(0), columns = dimensions.get(1);

        int currentRow = 0, currentColumn = columns - 1;
        while (currentRow < rows && currentColumn >= 0) {
            if (binaryMatrix.get(currentRow, currentColumn) == 1)
                currentColumn--;
            else
                currentRow++;
        }

        return currentColumn + 1 == columns ? -1 : currentColumn + 1;
    }

}
