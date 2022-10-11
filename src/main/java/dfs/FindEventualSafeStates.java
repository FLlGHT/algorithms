package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 802. Find Eventual Safe States
 * <p>
 * There is a directed graph of n nodes with each node labeled from 0 to n - 1.
 * The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i,
 * meaning there is an edge from node i to each node in graph[i].
 * <p>
 * A node is a terminal node if there are no outgoing edges.
 * A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).
 * <p>
 * Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
 * <p>
 * Example 1:
 * <p>
 * Illustration of graph
 * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * Output: [2,4,5,6]
 * Explanation: The given graph is shown above.
 * Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
 * Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
 * Output: [4]
 * Explanation:
 * Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
 */
public class FindEventualSafeStates {

    private enum State {UNKNOWN, UNSAFE, SAFE}
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNodes = new ArrayList<>();

        State[] states = new State[graph.length];
        Arrays.fill(states, State.UNKNOWN);

        for (int node = 0; node < graph.length; ++node) {
            if (isSafeNode(graph, node, states))
                safeNodes.add(node);
        }

        return safeNodes;
    }

    private boolean isSafeNode(int[][] graph, int node, State[] states) {
        if (states[node] != State.UNKNOWN)
            return states[node] == State.SAFE;

        states[node] = State.UNSAFE;

        for (int nextNode : graph[node]) {
            if (!isSafeNode(graph, nextNode, states))
                return false;
        }

        states[node] = State.SAFE;
        return true;
    }
}
