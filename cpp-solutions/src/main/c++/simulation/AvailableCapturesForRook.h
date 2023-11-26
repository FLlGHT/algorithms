//
// Created by fedorenko on 18.10.2022.
//

#ifndef C_ALGORITMS_AVAILABLECAPTURESFORROOK_H
#define C_ALGORITMS_AVAILABLECAPTURESFORROOK_H

#include <vector>

using namespace std;

class AvailableCapturesForRook {

public:
    int numRookCaptures(vector<vector<char>>& board) {
        for (int row = 0; row < board.size(); ++row) {
            for (int column = 0; column < board[0].size(); ++column) {
                if (board[row][column] == 'R')
                    return numOfCaptures(row, column, board);
            }
        }
        return 0;
    }

private:
    int numOfCaptures(int row, int column, vector<vector<char>>& board) {
        int numberOfCaptures = 0;

        if (contains(board, row, column, true, true)) numberOfCaptures++;
        if (contains(board, row, column, true, false)) numberOfCaptures++;
        if (contains(board, row, column, false, true)) numberOfCaptures++;
        if (contains(board, row, column, false, false)) numberOfCaptures++;

        return numberOfCaptures;
    }

private:
    bool contains(vector<vector<char>>& board, int row, int column, bool checkRow, bool checkLeft) {
        int to = checkRow ? (checkLeft ? column + 1 : board[0].size() - column) : (checkLeft ? row + 1 : board.size() - row);
        for (int offset = 1; offset < to; ++offset) {
            int rowNumber = checkRow ? row : (checkLeft ? row - offset : row + offset);
            int colNumber = checkRow ? (checkLeft ? column - offset : column + offset) : column;

            char value = board[rowNumber][colNumber];
            if (value == 'B')
                return false;

            if (value == 'p')
                return true;
        }

        return false;
    }

};


#endif //C_ALGORITMS_AVAILABLECAPTURESFORROOK_H
