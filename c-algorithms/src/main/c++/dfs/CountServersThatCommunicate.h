//
// Created by fedorenko on 21.10.2022.
//

#ifndef C_ALGORITMS_COUNTSERVERSTHATCOMMUNICATE_H
#define C_ALGORITMS_COUNTSERVERSTHATCOMMUNICATE_H

#include <vector>

using namespace std;

class CountServersThatCommunicate {

public:
    int countServers(vector<vector<int>>& grid) {
        int connected = 0;
        for (int row = 0; row < grid.size(); ++row) {
            for (int column = 0; column < grid[0].size(); ++column) {
                if (grid[row][column] == 1 && isConnected(grid, row, column))
                    connected++;
            }
        }
        return connected;
    }

private:
    bool isConnected(vector<vector<int>>& grid, int row, int column) {
        vector<vector<int>> directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (vector<int> direction : directions) {
            int newRow = row + direction[0], newColumn = column + direction[1];
            while (newRow >= 0 && newRow < grid.size() && newColumn >= 0 && newColumn < grid[0].size()) {
                if (grid[newRow][newColumn] == 1)
                    return true;
                newRow += direction[0];
                newColumn += direction[1];
            }
        }
        return false;
    }

};


#endif //C_ALGORITMS_COUNTSERVERSTHATCOMMUNICATE_H
