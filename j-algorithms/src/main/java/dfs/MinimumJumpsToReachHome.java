package dfs;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 1654. Minimum Jumps to Reach Home
 * <p>
 * <p>
 * A certain bug's home is on the x-axis at position x. Help them get there from position 0.
 * <p>
 * The bug jumps according to the following rules:
 * <p>
 * It can jump exactly a positions forward (to the right).
 * It can jump exactly b positions backward (to the left).
 * It cannot jump backward twice in a row.
 * It cannot jump to any forbidden positions.
 * The bug may jump forward beyond its home, but it cannot jump to positions numbered with negative integers.
 * <p>
 * Given an array of integers forbidden, where forbidden[i] means that the bug cannot jump to the position forbidden[i], and integers a, b, and x,
 * return the minimum number of jumps needed for the bug to reach its home. If there is no possible sequence of jumps that lands the bug on position x, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9
 * Output: 3
 * Explanation: 3 jumps forward (0 -> 3 -> 6 -> 9) will get the bug home.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: forbidden = [8,3,16,6,12,20], a = 15, b = 13, x = 11
 * Output: -1
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: forbidden = [1,6,2,14,5,17,4], a = 16, b = 9, x = 7
 * Output: 2
 * Explanation: One jump forward (0 -> 16) then one jump backward (16 -> 7) will get the bug home.
 */
public class MinimumJumpsToReachHome {
    private int minimum = Integer.MAX_VALUE;

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> forbiddenSet = Arrays.stream(forbidden).boxed().collect(Collectors.toSet());
        dfs(forbiddenSet, new HashSet<>(), x, 0, 0, a, b, false);
        return minimum == Integer.MAX_VALUE ? -1 : minimum;
    }

    private void dfs(Set<Integer> forbidden, Set<Integer> visited, int target, int current, int jumps, int forward, int backward, boolean lastIsBack) {
        if (visited.contains(current) || forbidden.contains(current) || current < 0 || current > 6000 || jumps >= minimum)
            return;

        if (!lastIsBack)
            visited.add(current);

        if (current == target)
            minimum = jumps;
        else {
            dfs(forbidden, visited, target, current + forward, jumps + 1, forward, backward, false);
            if (!lastIsBack)
                dfs(forbidden, visited, target, current - backward, jumps + 1, forward, backward, true);
        }
    }
}
