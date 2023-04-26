//
// Created by fedorenko on 17.10.2022.
//

#ifndef C_ALGORITMS_JUMPGAMEIII_H
#define C_ALGORITMS_JUMPGAMEIII_H

#include <vector>

using namespace std;

/**
 * 1306. Jump Game III
 * <p>
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array.
 * When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
 * <p>
 * Notice that you can not jump outside of the array at any time.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [4,2,3,0,3,1,2], start = 5
 * Output: true
 * Explanation:
 * All possible ways to reach at index 3 with value 0 are:
 * index 5 -> index 4 -> index 1 -> index 3
 * index 5 -> index 6 -> index 4 -> index 1 -> index 3
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: arr = [4,2,3,0,3,1,2], start = 0
 * Output: true
 * Explanation:
 * One possible way to reach at index 3 with value 0 is:
 * index 0 -> index 4 -> index 1 -> index 3
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: arr = [3,0,2,1,2], start = 2
 * Output: false
 * Explanation: There is no way to reach at index 1 with value 0.
 */
class JumpGameIII {

public:
    bool canReach(vector<int> &arr, int start) {
        vector<bool> visited(arr.size());
        return dfs(arr, start, visited);
    }

private:
    bool dfs(vector<int> &arr, int current, vector<bool> visited) {
        if (current < 0 || current >= arr.size() || visited[current])
            return false;

        if (arr[current] == 0)
            return true;

        visited[current] = true;

        return dfs(arr, current + arr[current], visited) || dfs(arr, current - arr[current], visited);
    }
};


#endif //C_ALGORITMS_JUMPGAMEIII_H
