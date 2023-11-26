//
// Created by fedorenko on 06.10.2022.
//

#ifndef C_ALGORITMS_COUNTSUBISLAND_H
#define C_ALGORITMS_COUNTSUBISLAND_H

#include <vector>

using namespace std;

/**
 * 1905. Count Sub Islands
 *
 * You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's (representing land).
 * An island is a group of 1's connected 4-directionally (horizontal or vertical). Any cells outside of the grid are considered water cells.

An island in grid2 is considered a sub-island if there is an island in grid1 that contains all the cells that make up this island in grid2.

Return the number of islands in grid2 that are considered sub-islands.



Example 1:


Input: grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
Output: 3
Explanation: In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
The 1s colored red in grid2 are those considered to be part of a sub-island. There are three sub-islands.
Example 2:


Input: grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]], grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
Output: 2
Explanation: In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
The 1s colored red in grid2 are those considered to be part of a sub-island. There are two sub-islands.
 */
class CountSubIsland {

public:
    int countSubIslands(vector<vector<int>>& grid1, vector<vector<int>>& grid2) {
        int count = 0;

        for (int row = 0; row < grid2.size(); ++row) {
            for (int column = 0; column < grid2[0].size(); ++column) {
                if (grid2[row][column] == 1 && isSubIsland(row, column, grid1, grid2))
                    count++;
            }
        }

        return count;
    }

private:
    bool isSubIsland(int row, int column, vector<vector<int>>& grid1, vector<vector<int>>& grid2) {
        if (row < 0 || row >= grid2.size() || column < 0 || column >= grid2[0].size() || grid2[row][column] == 0)
            return true;

        if (grid1[row][column] == 0)
            return false;

        grid2[row][column] = 0;

        return isSubIsland(row + 1, column, grid1, grid2) & isSubIsland(row - 1, column, grid1, grid2)
               & isSubIsland(row, column + 1, grid1, grid2) & isSubIsland(row, column - 1, grid1, grid2);
    }
};


#endif //C_ALGORITMS_COUNTSUBISLAND_H
