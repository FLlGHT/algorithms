package simulation;


/**
 * 1275. Find Winner on a Tic Tac Toe Game
 * <p>
 * Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:
 * <p>
 * Players take turns placing characters into empty squares ' '.
 * The first player A always places 'X' characters, while the second player B always places 'O' characters.
 * 'X' and 'O' characters are always placed into empty squares, never on filled ones.
 * The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
 * The game also ends if all squares are non-empty.
 * No more moves can be played if the game is over.
 * Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli].
 * return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw". If there are still movements to play return "Pending".
 * <p>
 * You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
 * Output: "A"
 * Explanation: A wins, they always play first.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
 * Output: "B"
 * Explanation: B wins.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
 * Output: "Draw"
 * Explanation: The game ends in a draw since there are no moves to make.
 */
public class FindWinnerOnATicTacToeGame {

    private final int[][] field = new int[3][3];

    public String tictactoe(int[][] moves) {
        for (int i = 0; i < moves.length; ++i) {
            int[] move = moves[i];
            int row = move[0], column = move[1];
            boolean firstPlayer = i % 2 == 0;

            field[row][column] = firstPlayer ? 1 : 2;

            if (checkRow(row) || checkColumn(column) || checkDiagonal(row, column) || checkAntiDiagonal(row, column))
                return firstPlayer ? "A" : "B";
        }

        return moves.length < 9 ? "Pending" : "Draw";
    }

    private boolean checkRow(int row) {
        for (int i = 1; i < field.length; ++i) {
            if (field[row][i] == 0 || field[row][i] != field[row][i - 1])
                return false;
        }
        return true;
    }

    private boolean checkColumn(int column) {
        for (int i = 1; i < field.length; ++i) {
            if (field[i][column] == 0 || field[i][column] != field[i - 1][column])
                return false;
        }
        return true;
    }

    private boolean checkDiagonal(int row, int column) {
        if (row != column)
            return false;

        for (int i = 1; i < field.length; ++i) {
            if (field[i][i] == 0 || field[i - 1][i - 1] != field[i][i])
                return false;
        }

        return true;
    }

    private boolean checkAntiDiagonal(int row, int column) {
        if (column != field.length - row - 1)
            return false;

        for (int i = 1; i < field.length; ++i) {
            if (field[i][field.length - i - 1] == 0 || field[i][field.length - i - 1] != field[i - 1][field.length - i])
                return false;
        }
        return true;
    }
}
