package unionfind;

/**
 * 684. Redundant Connection
 * <p>
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 * <p>
 * You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added.
 * The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed.
 * The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.
 * <p>
 * Return an edge that can be removed so that the resulting graph is a tree of n nodes.
 * If there are multiple answers, return the answer that occurs last in the input.
 * <p>
 * Example 1:
 * <p>
 * Input: edges = [[1,2],[1,3],[2,3]]
 * Output: [2,3]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
 * Output: [1,4]
 */
public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length);

        for (int[] edge : edges) {
            if (unionFind.find(edge[0]) == unionFind.find(edge[1]))
                return edge;

            unionFind.union(edge[0], edge[1]);
        }

        return new int[] {};
    }

    private static class UnionFind {

        private final int[] groups;

        public UnionFind(int n) {
            groups = new int[n + 1];
            for (int i = 1; i < groups.length; ++i) {
                groups[i] = i;
            }
        }

        private int find(int node) {
            if (groups[node] == node)
                return node;

            return groups[node] = find(groups[node]);
        }

        private void union(int first, int second) {
            int firstGroup = find(first);
            int secondGroup = find(second);

            if (firstGroup != secondGroup)
                groups[firstGroup] = secondGroup;
        }
    }
}
