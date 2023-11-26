//
// Created by fedorenko on 11.10.2022.
//

#ifndef C_ALGORITMS_NUMBEROFOPERATIONSTOMAKENETWORKCONNECTED_H
#define C_ALGORITMS_NUMBEROFOPERATIONSTOMAKENETWORKCONNECTED_H

#include <vector>

using namespace std;


/**
 * 1319. Number of Operations to Make Network Connected
 * <p>
 * There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi]
 * represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.
 * <p>
 * You are given an initial computer network connections.
 * You can extract certain cables between two directly connected computers,
 * and place them between any pair of disconnected computers to make them directly connected.
 * <p>
 * Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 4, connections = [[0,1],[0,2],[1,2]]
 * Output: 1
 * Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
 * Example 2:
 * <p>
 * <p>
 * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
 * Output: 2
 * Example 3:
 * <p>
 * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
 * Output: -1
 * Explanation: There are not enough cables.
 */
class NumberOfOperationsToMakeNetworkConnected {


public:
    int makeConnected(int n, vector<vector<int>>& connections) {
        int freeCables = 0, groupsCount = n - 1;
        vector<int> groups = createGroups(n);

        for (auto connection: connections) {
            int firstGroup = find(groups, connection[0]);
            int secondGroup = find(groups, connection[1]);

            if (firstGroup == secondGroup)
                freeCables++;
            else {
                groups[firstGroup] = secondGroup;
                groupsCount--;
            }
        }

        return freeCables >= groupsCount ? groupsCount : -1;
    }

private:
    vector<int> createGroups(int n) {
        vector<int> groups(n);

        for (int group = 0; group < n; ++group) {
            groups[group] = group;
        }

        return groups;
    }

private:
    int find(vector<int>& groups, int computer) {
        if (groups[computer] == computer)
            return computer;

        return groups[computer] = find(groups, groups[computer]);
    }
};


#endif //C_ALGORITMS_NUMBEROFOPERATIONSTOMAKENETWORKCONNECTED_H
