//
// Created by fedorenko on 05.10.2022.
//

#ifndef C_ALGORITMS_CELLSWITHODDVALUESINAMATRIX_H
#define C_ALGORITMS_CELLSWITHODDVALUESINAMATRIX_H

#include <vector>

using namespace std;

/**
 * 1252. Cells with Odd Values in a Matrix
 *
 * * <p>
 * There is an m x n matrix that is initialized to all 0's.
 * There is also a 2D array indices where each indices[i] = [ri, ci]
 * represents a 0-indexed location to perform some increment operations on the matrix.
 * <p>
 * For each location indices[i], do both of the following:
 * <p>
 * Increment all the cells on row ri.
 * Increment all the cells on column ci.
 * Given m, n, and indices, return the number of odd-valued cells in the matrix after applying the increment to all locations in indices.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: m = 2, n = 3, indices = [[0,1],[1,1]]
 * Output: 6
 * Explanation: Initial matrix = [[0,0,0],[0,0,0]].
 * After applying first increment it becomes [[1,2,1],[0,1,0]].
 * The final matrix is [[1,3,1],[1,3,1]], which contains 6 odd numbers.
 * Example 2:
 * <p>
 * <p>
 * Input: m = 2, n = 2, indices = [[1,1],[0,0]]
 * Output: 0
 * Explanation: Final matrix = [[2,2],[2,2]]. There are no odd numbers in the final matrix.
 */
class CellsWithOddValuesInAMatrix {

public:
    int oddCells(int m, int n, vector<vector<int>>& indices) {
        vector<vector<int>> matrix(m, vector<int>(n, 0)); int count = 0;

        for (vector<int> updateInfo : indices) {
            int row = updateInfo[0], column = updateInfo[1];

            for (int i = 0; i < m; ++i) {
                matrix[i][column]++;
            }
            for (int j = 0; j < n; ++j) {
                matrix[row][j]++;
            }
        }

        for (const vector<int>& row : matrix) {
            for (int element : row) {
                if (element % 2 == 1)
                    count++;
            }
        }

        return count;
    }
};


#endif //C_ALGORITMS_CELLSWITHODDVALUESINAMATRIX_H
