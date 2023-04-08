//
// Created by fedorenko on 11.10.2022.
//

#ifndef C_ALGORITMS_FINDEVENTUALSAFESTATES_H
#define C_ALGORITMS_FINDEVENTUALSAFESTATES_H

#include <vector>

using namespace std;

/**
 * 802. Find Eventual Safe States
 *
 * There is a directed graph of n nodes with each node labeled from 0 to n - 1.
 * The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i,
 * meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges.
 A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.



Example 1:

Illustration of graph
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Explanation: The given graph is shown above.
Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.


Example 2:

Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
Output: [4]
Explanation:
Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
 */
class FindEventualSafeStates {

private:
    enum State {
        UNKNOWN, UNSAFE, SAFE
    };
public:
    vector<int> eventualSafeNodes(vector<vector<int>> &graph) {
        vector<State> states(graph.size(), UNKNOWN);
        vector<int> safeNodes;
        for (int node = 0; node < graph.size(); ++node) {
            if (isSafeNode(graph, node, states))
                safeNodes.push_back(node);
        }

        return safeNodes;
    }

private:
    bool isSafeNode(vector<vector<int>> &graph, int currentNode, vector<State>& states) {
        if (states[currentNode] != UNKNOWN)
            return states[currentNode] == SAFE;

        states[currentNode] = UNSAFE;

        for (auto &nextNode: graph[currentNode]) {
            if (!isSafeNode(graph, nextNode, states))
                return false;
        }

        states[currentNode] = SAFE;
        return true;
    }
};


#endif //C_ALGORITMS_FINDEVENTUALSAFESTATES_H
