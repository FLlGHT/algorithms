package unionfind;

import java.util.*;

/**
 * 2685. Count the Number of Complete Components
 * <p>
 * You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.
 * <p>
 * Return the number of complete connected components of the graph.
 * <p>
 * A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.
 * <p>
 * A connected component is said to be complete if there exists an edge between every pair of its vertices.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
 * Output: 3
 * Explanation: From the picture above, one can see that all of the components of this graph are complete.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]
 * Output: 1
 * Explanation: The component containing vertices 0, 1, and 2 is complete since there is an edge between every pair of two vertices.
 * On the other hand, the component containing vertices 3, 4, and 5 is not complete since there is no edge between vertices 4 and 5. Thus, the number of complete components in this graph is 1.
 */
public class CountTheNumberOfCompleteComponents {

  public int countCompleteComponents(int n, int[][] edges) {
    UnionFind unionFind = new UnionFind(n);
    Map<Integer, Set<Integer>> nodeEdges = new HashMap<>();

    for (int[] edge : edges) {
      int first = edge[0], second = edge[1];
      unionFind.union(first, second);

      nodeEdges.computeIfAbsent(first, param -> new HashSet<>()).add(second);
      nodeEdges.computeIfAbsent(second, param -> new HashSet<>()).add(first);
    }

    int countCompleteComponents = 0;
    Map<Integer, List<Integer>> groups = unionFind.getGroups();
    for (int groupParent : groups.keySet()) {
      if (allNodesConnected(groups.get(groupParent), nodeEdges))
        countCompleteComponents++;
    }

    return countCompleteComponents;
  }

  private boolean allNodesConnected(List<Integer> nodes, Map<Integer, Set<Integer>> edges) {
    for (int firstNode : nodes) {
      for (int secondNode : nodes) {
        if (firstNode == secondNode)
          continue;

        if (!edges.containsKey(firstNode) || !edges.get(firstNode).contains(secondNode))
          return false;
      }
    }

    return true;
  }

  public class UnionFind {

    private final int[] parents;
    public UnionFind(int n) {
      parents = new int[n];

      for (int i = 0; i < n; ++i) {
        parents[i] = i;
      }
    }

    private void union(int first, int second) {
      int firstParent = find(first);
      int secondParent = find(second);

      if (firstParent <= secondParent)
        parents[secondParent] = firstParent;
      else
        parents[firstParent] = secondParent;
    }

    private int find(int node) {
      if (parents[node] == node)
        return node;

      return find(parents[node]);
    }

    public Map<Integer, List<Integer>> getGroups() {
      Map<Integer, List<Integer>> groups = new HashMap<>();

      for (int i = 0; i < parents.length; ++i) {
        int parent = find(i);
        groups.computeIfAbsent(parent, param -> new ArrayList<>()).add(i);
      }

      return groups;
    }
  }
}
