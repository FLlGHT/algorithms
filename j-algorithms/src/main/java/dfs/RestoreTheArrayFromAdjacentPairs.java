package dfs;


import java.util.*;

/**
 * 1743. Restore the Array From Adjacent Pairs
 * <p>
 * There is an integer array nums that consists of n unique elements, but you have forgotten it. However, you do remember every pair of adjacent elements in nums.
 * <p>
 * You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi] indicates that the elements ui and vi are adjacent in nums.
 * <p>
 * It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs, either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.
 * <p>
 * Return the original array nums. If there are multiple solutions, return any of them.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: adjacentPairs = [[2,1],[3,4],[3,2]]
 * Output: [1,2,3,4]
 * Explanation: This array has all its adjacent pairs in adjacentPairs.
 * Notice that adjacentPairs[i] may not be in left-to-right order.
 * Example 2:
 * <p>
 * Input: adjacentPairs = [[4,-2],[1,4],[-3,1]]
 * Output: [-2,4,1,-3]
 * Explanation: There can be negative numbers.
 * Another solution is [-3,1,4,-2], which would also be accepted.
 * Example 3:
 * <p>
 * Input: adjacentPairs = [[100000,-100000]]
 * Output: [100000,-100000]
 */
public class RestoreTheArrayFromAdjacentPairs {


    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, Set<Integer>> graph = buildGraph(adjacentPairs);
        int start = graph.entrySet().stream().filter(a -> a.getValue().size() == 1).findFirst().get().getKey();

        List<Integer> result = new ArrayList<>();
        dfs(graph, start, new HashSet<>(), result);
        return result.stream().mapToInt(a -> a).toArray();
    }

    private Map<Integer, Set<Integer>> buildGraph(int[][] adjacent) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int[] pair : adjacent) {
            graph.computeIfAbsent(pair[0], param -> new HashSet<>()).add(pair[1]);
            graph.computeIfAbsent(pair[1], param -> new HashSet<>()).add(pair[0]);
        }

        return graph;
    }

    private void dfs(Map<Integer, Set<Integer>> graph, int start, Set<Integer> visited, List<Integer> result) {
        result.add(start);
        visited.add(start);

        for (int next : graph.get(start)) {
            if (!visited.contains(next))
                dfs(graph, next, visited, result);
        }
    }
}
