//
// Created by fedorenko on 19.10.2022.
//

#ifndef C_ALGORITMS_DIAGONALTRAVERSE_H
#define C_ALGORITMS_DIAGONALTRAVERSE_H

#include <vector>

using namespace std;

/**
 * 498. Diagonal Traverse
 *
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

Example 1:

Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,4,7,5,3,6,8,9]

Example 2:

Input: mat = [[1,2],[3,4]]
Output: [1,2,3,4]
 */
class DiagonalTraverse {


public:
    vector<int> findDiagonalOrder(vector<vector<int>> &mat) {
        int columns = mat[0].size(), rows = mat.size();
        vector<int> diagonalOrder(rows * columns);

        for (int i = 0, row = 0, column = 0; i < diagonalOrder.size(); ++i) {
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
};


#endif //C_ALGORITMS_DIAGONALTRAVERSE_H
