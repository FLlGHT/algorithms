//
// Created by fedorenko on 06.10.2022.
//

#ifndef C_ALGORITMS_MAXAREAOFISLAND_H
#define C_ALGORITMS_MAXAREAOFISLAND_H

#include <vector>

using namespace std;

/**
 * 695. Max Area of Island
 * <p>
 * You are given an m x n binary matrix grid.
 * An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 * <p>
 * The area of an island is the number of cells with a value 1 in the island.
 * <p>
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 * <p>
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 */
class MaxAreaOfIsland {

public:
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int maxArea = 0;
        for (int row = 0; row < grid.size(); ++row) {
            for (int column = 0; column < grid[0].size(); ++column) {
                maxArea = max(maxArea, squareOfIsland(row, column, grid));
            }
        }
        return maxArea;
    }

private:
    int squareOfIsland(int row, int column, vector<vector<int>>& grid) {
        if (row < 0 || row >= grid.size() || column < 0 || column >= grid[0].size() || grid[row][column] == 0)
            return 0;

        grid[row][column] = 0;
        return 1 + squareOfIsland(row, column + 1, grid) + squareOfIsland(row, column - 1, grid) +
                squareOfIsland(row + 1, column, grid) + squareOfIsland(row - 1, column, grid);
    }
};


#endif //C_ALGORITMS_MAXAREAOFISLAND_H
