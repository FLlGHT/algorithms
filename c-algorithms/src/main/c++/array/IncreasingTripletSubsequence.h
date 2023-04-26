//
// Created by fedorenko on 11.10.2022.
//

#ifndef C_ALGORITMS_INCREASINGTRIPLETSUBSEQUENCE_H
#define C_ALGORITMS_INCREASINGTRIPLETSUBSEQUENCE_H

#include <vector>

using namespace std;

/**
 * 334. Increasing Triplet Subsequence
 * <p>
 * Given an integer array nums,
 * return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k].
 * If no such indices exists, return false.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4,5]
 * Output: true
 * Explanation: Any triplet where i < j < k is valid.
 * Example 2:
 * <p>
 * Input: nums = [5,4,3,2,1]
 * Output: false
 * Explanation: No triplet exists.
 * Example 3:
 * <p>
 * Input: nums = [2,1,5,0,4,6]
 * Output: true
 * Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 */
class IncreasingTripletSubsequence {

public:
    bool increasingTriplet(vector<int> &nums) {
        int first = INT_MAX;
        int second = INT_MAX;
        for (int num: nums) {
            if (num <= first)
                first = num;
            else if (num <= second)
                second = num;
            else
                return true;
        }
        return false;
    }
};


#endif //C_ALGORITMS_INCREASINGTRIPLETSUBSEQUENCE_H
