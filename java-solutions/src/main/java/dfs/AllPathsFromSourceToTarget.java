package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 797. All Paths From Source to Target
 * <p>
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
 * <p>
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * Example 2:
 * <p>
 * <p>
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 */
public class AllPathsFromSourceToTarget {

    private List<List<Integer>> paths;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        paths = new ArrayList<>();
        dfs(graph, 0, new ArrayList<>());
        return paths;
    }

    private void dfs(int[][] graph, int currentNodeNumber, List<Integer> currentPath) {
        if (currentNodeNumber == graph.length - 1)
            paths.add(currentPath);

        currentPath.add(currentNodeNumber);
        for (int node : graph[currentNodeNumber]) {
            dfs(graph, node, new ArrayList<>(currentPath));
        }
    }
}
