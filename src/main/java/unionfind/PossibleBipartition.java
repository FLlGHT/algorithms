package unionfind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 886. Possible Bipartition
 * <p>
 * We want to split a group of n people (labeled from 1 to n) into two groups of any size.
 * Each person may dislike some other people, and they should not go into the same group.
 * <p>
 * Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi,
 * return true if it is possible to split everyone into two groups in this way.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4] and group2 [2,3].
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 */
public class PossibleBipartition {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] groups = createGroups(n);
        Map<Integer, Set<Integer>> graph = buildGraph(dislikes);

        for (int vertex = 1; vertex <= n; ++vertex) {
            Set<Integer> neighbors = graph.getOrDefault(vertex, new HashSet<>());
            if (neighbors.size() > 0) {
                int firstNeighbor = neighbors.iterator().next();
                for (int neighbor : neighbors) {
                    if (isConnected(groups, vertex, neighbor))
                        return false;

                    union(groups, firstNeighbor, neighbor);
                }
            }
        }

        return true;
    }

    private Map<Integer, Set<Integer>> buildGraph(int[][] dislikes) {
        Map<Integer, Set<Integer>> toOtherGroups = new HashMap<>();
        for (int[] dislike : dislikes) {
            int who = dislike[0], whom = dislike[1];
            toOtherGroups.computeIfAbsent(who, param -> new HashSet<>()).add(whom);
            toOtherGroups.computeIfAbsent(whom, param -> new HashSet<>()).add(who);
        }
        return toOtherGroups;
    }

    private int[] createGroups(int n) {
        int[] groups = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            groups[i] = i;
        }
        return groups;
    }

    private void union(int[] groups, int first, int second) {
        int firstGroup = find(groups, first);
        int secondGroup = find(groups, second);

        if (firstGroup != secondGroup)
            groups[firstGroup] = secondGroup;
    }

    private int find(int[] groups, int person) {
        if (groups[person] == person)
            return person;

        return groups[person] = find(groups, groups[person]);
    }

    private boolean isConnected(int[] groups, int first, int second) {
        return find(groups, first) == find(groups, second);
    }
}
