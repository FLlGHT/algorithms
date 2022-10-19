package simulation;


/**
 * 999. Available Captures for Rook
 *
 * On an 8 x 8 chessboard, there is exactly one white rook 'R' and some number of white bishops 'B', black pawns 'p', and empty squares '.'.
 *
 * When the rook moves, it chooses one of four cardinal directions (north, east, south, or west),
 * then moves in that direction until it chooses to stop, reaches the edge of the board, captures a black pawn, or is blocked by a white bishop.
 * A rook is considered attacking a pawn if the rook can capture the pawn on the rook's turn.
 * The number of available captures for the white rook is the number of pawns that the rook is attacking.
 *
 * Return the number of available captures for the white rook.
 */
public class AvailableCapturesForRook {

    public int numRookCaptures(char[][] board) {
        for (int row = 0; row < board.length; ++row) {
            for (int column = 0; column < board[0].length; ++column) {
                if (board[row][column] == 'R')
                    return numOfCaptures(row, column, board);
            }
        }
        return 0;
    }

    private int numOfCaptures(int row, int column, char[][] board) {
        int numberOfCaptures = 0;

        if (contains(board, row, column, true, true)) numberOfCaptures++;
        if (contains(board, row, column, true, false)) numberOfCaptures++;
        if (contains(board, row, column, false, true)) numberOfCaptures++;
        if (contains(board, row, column, false, false)) numberOfCaptures++;

        return numberOfCaptures;
    }

    private boolean contains(char[][] board, int row, int column, boolean checkRow, boolean checkLeft) {
        int to = checkRow ? (checkLeft ? column + 1 : board[0].length - column) : (checkLeft ? row + 1 : board.length - row);
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
}
