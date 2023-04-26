//
// Created by fedorenko on 14.10.2022.
//

#ifndef C_ALGORITMS_FINDWINNERONTICTACTOEGAME_H
#define C_ALGORITMS_FINDWINNERONTICTACTOEGAME_H

#include <vector>
#include <string>

using namespace std;

/**
 * 1275. Find Winner on a Tic Tac Toe Game
 *
 * Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:

Players take turns placing characters into empty squares ' '.
The first player A always places 'X' characters, while the second player B always places 'O' characters.
'X' and 'O' characters are always placed into empty squares, never on filled ones.
The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.
Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli].
 return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw". If there are still movements to play return "Pending".

You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.



Example 1:


Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
Output: "A"
Explanation: A wins, they always play first.


Example 2:


Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
Output: "B"
Explanation: B wins.


Example 3:


Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
Output: "Draw"
Explanation: The game ends in a draw since there are no moves to make.
 */
class FindWinnerOnTicTacToeGame {
private:
    vector<vector<int>> field;
public:
    string tictactoe(vector<vector<int>> &moves) {
        field = vector<vector<int>>(3, vector<int>(3, 0));

        for (int i = 0; i < moves.size(); ++i) {
            vector<int> move = moves[i];
            int row = move[0], column = move[1];
            bool firstPlayer = i % 2 == 0;

            field[row][column] = firstPlayer ? 1 : 2;

            if (checkRow(row) || checkColumn(column) || checkDiagonal(row, column) || checkAntiDiagonal(row, column))
                return firstPlayer ? "A" : "B";
        }

        return moves.size() < 9 ? "Pending" : "Draw";
    }

private:
    bool checkRow(int row) {
        for (int i = 1; i < field.size(); ++i) {
            if (field[row][i] == 0 || field[row][i] != field[row][i - 1])
                return false;
        }
        return true;
    }

private:
    bool checkColumn(int column) {
        for (int i = 1; i < field.size(); ++i) {
            if (field[i][column] == 0 || field[i][column] != field[i - 1][column])
                return false;
        }
        return true;
    }

private:
    bool checkDiagonal(int row, int column) {
        if (row != column)
            return false;

        for (int i = 1; i < field.size(); ++i) {
            if (field[i][i] == 0 || field[i - 1][i - 1] != field[i][i])
                return false;
        }

        return true;
    }

private:
    bool checkAntiDiagonal(int row, int column) {
        if (column != field.size() - row - 1)
            return false;

        for (int i = 1; i < field.size(); ++i) {
            if (field[i][field.size() - i - 1] == 0 || field[i][field.size() - i - 1] != field[i - 1][field.size() - i])
                return false;
        }
        return true;
    }
};


#endif //C_ALGORITMS_FINDWINNERONTICTACTOEGAME_H
