package unionfind;


import java.util.Arrays;

/**
 * 323. Number of Connected Components in an Undirected Graph
 * <p>
 * You have a graph of n nodes.
 * You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.
 * <p>
 * Return the number of connected components in the graph.
 * <p>
 * Example 1:
 * Input: n = 5, edges = [[0,1],[1,2],[3,4]] Output: 2
 * <p>
 * Example 2:
 * Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]] Output: 1
 *
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {

    public int countComponents(int n, int[][] edges) {
        int[] groups = new int[n]; Arrays.fill(groups, -1);
        int count = n;

        for (int[] edge : edges) {
            if (union(groups, edge[0], edge[1]))
                count--;
        }

        return count;
    }

    private boolean union(int[] groups, int first, int second) {
        int firstGroup = find(groups, first);
        int secondGroup = find(groups, second);

        if (firstGroup != secondGroup) {
            groups[firstGroup] = secondGroup;
            return true;
        }

        return false;
    }

    private int find(int[] groups, int node) {
        if (groups[node] == -1)
            return node;

        return find(groups, groups[node]);
    }
}
