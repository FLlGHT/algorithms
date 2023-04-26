//
// Created by fedorenko on 26.09.2022.
//

#ifndef C_ALGORITMS_NUMBEROFCONNECTEDCOMPONENTSINANUNDIRECTEDGRAPH_H
#define C_ALGORITMS_NUMBEROFCONNECTEDCOMPONENTSINANUNDIRECTEDGRAPH_H
#include <iostream>
#include <vector>
using namespace std;

/**
 * 323. Number of Connected Components in an Undirected Graph
 *
 * You have a graph of n nodes.
 * You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.
 *
 * Return the number of connected components in the graph.
 *
 * Example 1:
 * Input: n = 5, edges = [[0,1],[1,2],[3,4]] Output: 2
 *
 * Example 2:
 * Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]] Output: 1
 *
 */
class NumberOfConnectedComponentsInAnUndirectedGraph {
public:
    int countComponents(int n, vector<vector<int>>& edges) {
        vector<int> groups(n, -1);
        int count = n;

        for (const auto &edge: edges) {
            if (merge(groups, edge[0], edge[1]))
                count--;
        }

        return count;
    }

private:
    bool merge(vector<int>& groups, int first, int second) {
        int firstGroup = find(groups, first);
        int secondGroup = find(groups, second);

        if (firstGroup != secondGroup) {
            groups[firstGroup] = secondGroup;
            return true;
        }

        return false;
    }

private:
    int find(vector<int>& groups, int node) {
        if (groups[node] == -1)
            return node;

        return find(groups, groups[node]);
    }
};


#endif //C_ALGORITMS_NUMBEROFCONNECTEDCOMPONENTSINANUNDIRECTEDGRAPH_H
