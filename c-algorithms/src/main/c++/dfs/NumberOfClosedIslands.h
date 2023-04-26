//
// Created by fedorenko on 06.10.2022.
//

#ifndef C_ALGORITMS_NUMBEROFCLOSEDISLANDS_H
#define C_ALGORITMS_NUMBEROFCLOSEDISLANDS_H

#include <vector>

using namespace std;

/**
 * 1254. Number of Closed Islands
 *
 * Given a 2D grid consists of 0s (land) and 1s (water).
 * An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.


Example 1:

Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation:
Islands in gray are closed because they are completely surrounded by water (group of 1s).
Example 2:

Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
Output: 1
Example 3:

Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2
 */
class NumberOfClosedIslands {

public:
    int closedIsland(vector<vector<int>> &grid) {
        int count = 0;

        for (int row = 0; row < grid.size(); ++row) {
            for (int column = 0; column < grid[0].size(); ++column) {
                if (grid[row][column] == 0 && isClosed(row, column, grid))
                    count++;
            }
        }

        return count;
    }

private:
    bool isClosed(int row, int column, vector<vector<int>> &grid) {
        if (row < 0 || row >= grid.size() || column < 0 || column >= grid[0].size())
            return false;

        if (grid[row][column] == 1)
            return true;

        grid[row][column] = 1;

        return isClosed(row + 1, column, grid) & isClosed(row - 1, column, grid) & isClosed(row, column + 1, grid) &
               isClosed(row, column - 1, grid);
    }
};


#endif //C_ALGORITMS_NUMBEROFCLOSEDISLANDS_H
