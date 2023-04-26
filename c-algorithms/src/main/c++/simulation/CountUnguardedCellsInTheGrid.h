//
// Created by fedorenko on 20.10.2022.
//

#ifndef C_ALGORITMS_COUNTUNGUARDEDCELLSINTHEGRID_H
#define C_ALGORITMS_COUNTUNGUARDEDCELLSINTHEGRID_H

#include <vector>

using namespace std;

class CountUnguardedCellsInTheGrid {


public:
    int countUnguarded(int m, int n, vector<vector<int>>& guards, vector<vector<int>>& walls) {
        vector<vector<char>> matrix(m, vector<char>(n)); int unguarded = m * n - guards.size() - walls.size();
        vector<vector<int>> directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (vector<int> wall : walls) matrix[wall[0]][wall[1]] = 'W';
        for (vector<int> guard : guards) matrix[guard[0]][guard[1]] = 'G';

        for (vector<int> guard : guards) {
            for (vector<int> direction : directions) {
                int row = guard[0] + direction[0]; int column = guard[1] + direction[1];

                while (row >= 0 && row < m && column >= 0 && column < n && matrix[row][column] != 'W' && matrix[row][column] != 'G') {
                    if (matrix[row][column] != 'S')
                        unguarded--;

                    matrix[row][column] = 'S';
                    row = row + direction[0]; column = column + direction[1];
                }
            }
        }


        return unguarded;
    }
};


#endif //C_ALGORITMS_COUNTUNGUARDEDCELLSINTHEGRID_H
