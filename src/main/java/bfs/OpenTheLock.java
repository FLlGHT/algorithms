package bfs;


import java.util.*;
import java.util.stream.Collectors;

/**
 * 752. Open the Lock
 * <p>
 * You have a lock in front of you with 4 circular wheels.
 * Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
 * The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
 * Each move consists of turning one wheel one slot.
 * <p>
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * <p>
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
 * the wheels of the lock will stop turning and you will be unable to open it.
 * <p>
 * Given a target representing the value of the wheels that will unlock the lock,
 * return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 * Explanation:
 * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 * Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
 * because the wheels of the lock become stuck after the display becomes the dead end "0102".
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: deadends = ["8888"], target = "0009"
 * Output: 1
 * Explanation: We can turn the last wheel in reverse to move from "0000" -> "0009".
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * Output: -1
 * Explanation: We cannot reach the target without getting stuck.
 */
public class OpenTheLock {

    public int openLock(String[] deadends, String target) {
        Set<String> deCombinations = Arrays.stream(deadends).collect(Collectors.toSet());
        if (deCombinations.contains("0000")) return -1;
        Queue<String> queue = new LinkedList<>(List.of("0000"));

        for (int steps = 0; !queue.isEmpty(); ++steps) {
            for (int i = queue.size(); i > 0; --i) {
                String current = queue.poll();
                if (Objects.equals(current, target))
                    return steps;

                for (String neighbor : neighbors(current)) {
                    if (!deCombinations.contains(neighbor)) {
                        deCombinations.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return -1;
    }

    private List<String> neighbors(String current) {
        List<String> neighbors = new ArrayList<>();
        for (int i = 0; i < 4; ++i) {
            int digit = current.charAt(i) - '0', previousDigit = (10 + digit - 1) % 10, nextDigit =
                    (10 + digit + 1) % 10;

            neighbors.add(current.substring(0, i) + previousDigit + current.substring(i + 1));
            neighbors.add(current.substring(0, i) + nextDigit + current.substring(i + 1));
        }

        return neighbors;
    }
}
