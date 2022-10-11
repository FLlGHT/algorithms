package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1926. Nearest Exit from Entrance in Maze
 * <p>
 * You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+').
 * You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.
 * <p>
 * In one step, you can move one cell up, down, left, or right.
 * You cannot step into a cell with a wall, and you cannot step outside the maze.
 * Your goal is to find the nearest exit from the entrance.
 * An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.
 * <p>
 * Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
 * Output: 1
 * Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
 * Initially, you are at the entrance cell [1,2].
 * - You can reach [1,0] by moving 2 steps left.
 * - You can reach [0,2] by moving 1 step up.
 * It is impossible to reach [2,3] from the entrance.
 * Thus, the nearest exit is [0,2], which is 1 step away.
 * Example 2:
 * <p>
 * <p>
 * Input: maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
 * Output: 2
 * Explanation: There is 1 exit in this maze at [1,2].
 * [1,0] does not count as an exit since it is the entrance cell.
 * Initially, you are at the entrance cell [1,0].
 * - You can reach [1,2] by moving 2 steps right.
 * Thus, the nearest exit is [1,2], which is 2 steps away.
 * Example 3:
 * <p>
 * <p>
 * Input: maze = [[".","+"]], entrance = [0,0]
 * Output: -1
 * Explanation: There are no exits in this maze.
 */
public class NearestExitFromEntranceInMaze {

    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        maze[entrance[0]][entrance[1]] = '+';

        Queue<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(entrance[0], entrance[1], 0));

        while (!queue.isEmpty()) {
            Cell currentCell = queue.poll();

            for (int[] direction : directions) {
                int newRow = currentCell.row() + direction[0], newColumn = currentCell.column() + direction[1];
                if (newRow >= 0 && newRow < maze.length && newColumn >= 0 && newColumn < maze[0].length && maze[newRow][newColumn] == '.') {

                    if (newRow == 0 || newRow == maze.length - 1 || newColumn == 0 || newColumn == maze[0].length - 1)
                        return currentCell.distance() + 1;

                    maze[newRow][newColumn] = '+';
                    queue.add(new Cell(newRow, newColumn, currentCell.distance() + 1));
                }
            }
        }
        return -1;
    }

    private record Cell(int row, int column, int distance) {

    }
}
