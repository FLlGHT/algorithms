package design;

/**
 * 348. Design-Tic-Tac-Toe
 */
public class TicTacToe {

    private final int[][] field;

    public TicTacToe(int n) {
        field = new int[n][n];
    }

    public int move(int row, int col, int player) {
        field[row][col] = player;

        if (isColumn(col, player) || isRow(row, player) || isDiagonal(row, col, player) || isAntiDiagonal(
                row, col, player))
            return player;

        return 0;
    }

    private boolean isColumn(int col, int player) {
        for (int[] row : field) {
            if (row[col] != player)
                return false;
        }

        return true;
    }

    private boolean isRow(int row, int player) {
        for (int j = 0; j < field[0].length; ++j) {
            if (field[row][j] != player)
                return false;
        }

        return true;
    }

    private boolean isDiagonal(int row, int col, int player) {
        if (row == col) {
            for (int i = 0; i < field.length; ++i) {
                if (field[i][i] != player)
                    return false;
            }

            return true;
        } else
            return false;
    }

    private boolean isAntiDiagonal(int row, int col, int player) {
        if (row == field.length - col - 1) {
            for (int i = 0; i < field.length; ++i) {
                if (field[i][field.length - i - 1] != player)
                    return false;
            }

            return true;
        } else
            return false;
    }
}
