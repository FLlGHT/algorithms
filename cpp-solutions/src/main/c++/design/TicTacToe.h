//
// Created by fedorenko on 30.09.2022.
//

#ifndef C_ALGORITMS_TICTACTOE_H
#define C_ALGORITMS_TICTACTOE_H

#include <vector>

using namespace std;

class TicTacToe {
private:
    vector<vector<int>> field;

    int move(int row, int col, int player) {
        field[row][col] = player;

        if (isRow(row, player) || isColumn(col, player) || isDiagonal(row, col, player) ||
            isAntiDiagonal(row, col, player))
            return player;

        return 0;
    }

    bool isRow(int row, int player) {
        for (int i = 0; i < field.size(); ++i) {
            if (field[row][i] != player)
                return false;
        }

        return true;
    }

    bool isColumn(int column, int player) {
        for (auto &row: field) {
            if (row[column] != player)
                return false;
        }
        return true;
    }

    bool isDiagonal(int row, int column, int player) {
        if (row == column) {
            for (int i = 0; i < field.size(); ++i) {
                if (field[i][i] != player)
                    return false;
            }
            return true;

        } else
            return false;
    }

    bool isAntiDiagonal(int row, int column, int player) {
        if (row == field.size() - column - 1) {
            for (int i = 0; i < field.size(); ++i) {
                if (field[i][field.size() - i - 1] != player)
                    return false;
            }
            return true;

        } else
            return false;
    }

};


#endif //C_ALGORITMS_TICTACTOE_H
