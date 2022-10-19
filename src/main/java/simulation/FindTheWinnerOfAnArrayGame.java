package simulation;

import java.util.LinkedList;


/**
 * 1535. Find the Winner of an Array Game
 * <p>
 * Given an integer array arr of distinct integers and an integer k.
 * <p>
 * A game will be played between the first two elements of the array (i.e. arr[0] and arr[1]).
 * In each round of the game, we compare arr[0] with arr[1],
 * the larger integer wins and remains at position 0, and the smaller integer moves to the end of the array.
 * The game ends when an integer wins k consecutive rounds.
 * <p>
 * Return the integer which will win the game.
 * <p>
 * It is guaranteed that there will be a winner of the game.
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [2,1,3,5,4,6,7], k = 2
 * Output: 5
 * Explanation: Let's see the rounds of the game:
 * Round |       arr       | winner | win_count
 * 1   | [2,1,3,5,4,6,7] | 2      | 1
 * 2   | [2,3,5,4,6,7,1] | 3      | 1
 * 3   | [3,5,4,6,7,1,2] | 5      | 1
 * 4   | [5,4,6,7,1,2,3] | 5      | 2
 * So we can see that 4 rounds will be played and 5 is the winner because it wins 2 consecutive games.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: arr = [3,2,1], k = 10
 * Output: 3
 * Explanation: 3 will win the first 10 rounds consecutively.
 */
public class FindTheWinnerOfAnArrayGame {

    public int getWinner(int[] arr, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        for (int number : arr)
            queue.add(number);

        int lastWinner = Math.max(arr[0], arr[1]), consecutiveWins = 0;
        while (consecutiveWins < Math.min(k, arr.length)) {
            int first = queue.removeFirst(), second = queue.removeFirst();
            int gameWinner = Math.max(first, second);
            consecutiveWins = gameWinner == lastWinner ? consecutiveWins + 1 : 1;
            queue.addFirst(gameWinner);
            queue.addLast(Math.min(first, second));
            lastWinner = gameWinner;
        }

        return lastWinner;
    }
}
