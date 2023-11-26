//
// Created by fedorenko on 12.10.2022.
//

#ifndef C_ALGORITMS_NUMBEROFPROVINCES_H
#define C_ALGORITMS_NUMBEROFPROVINCES_H

#include <vector>

using namespace std;

/**
 * 547. Number of Provinces
 * <p>
 * There are n cities. Some of them are connected, while some are not.
 * If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 * <p>
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * <p>
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 * <p>
 * Return the total number of provinces.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 */
class NumberOfProvinces {

public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        vector<bool> visited(isConnected.size());
        int count = 0;
        for (int i = 0; i < isConnected.size(); ++i) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

private:
    void dfs(vector<vector<int>>& isConnected, vector<bool>& visited, int number) {
        for (int j = 0; j < isConnected.size(); ++j) {
            if (isConnected[number][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, j);
            }
        }
    }
};


#endif //C_ALGORITMS_NUMBEROFPROVINCES_H
