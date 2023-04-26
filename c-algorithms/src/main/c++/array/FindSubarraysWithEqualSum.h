//
// Created by fedorenko on 05.10.2022.
//

#ifndef C_ALGORITMS_FINDSUBARRAYSWITHEQUALSUM_H
#define C_ALGORITMS_FINDSUBARRAYSWITHEQUALSUM_H

#include <vector>
#include <unordered_set>

using namespace std;

/**
 * 2395. Find Subarrays With Equal Sum
 * <p>
 * Given a 0-indexed integer array nums,
 * determine whether there exist two subarrays of length 2 with equal sum.
 * Note that the two subarrays must begin at different indices.
 * <p>
 * Return true if these subarrays exist, and false otherwise.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,2,4]
 * Output: true
 * Explanation: The subarrays with elements [4,2] and [2,4] have the same sum of 6.
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4,5]
 * Output: false
 * Explanation: No two subarrays of size 2 have the same sum.
 * Example 3:
 * <p>
 * Input: nums = [0,0,0]
 * Output: true
 * Explanation: The subarrays [nums[0],nums[1]] and [nums[1],nums[2]] have the same sum of 0.
 * Note that even though the subarrays have the same content,
 * the two subarrays are considered different because they are in different positions in the original array.
 */
class FindSubarraysWithEqualSum {

public:
    bool findSubarrays(vector<int>& nums) {
        unordered_set<int> sumSet;

        for (int i = 1; i < nums.size(); ++i) {
            int sum = nums[i] + nums[i - 1];

            if (sumSet.find(sum) != sumSet.end())
                return true;
            else
                sumSet.insert(sum);
        }

        return false;
    }
};


#endif //C_ALGORITMS_FINDSUBARRAYSWITHEQUALSUM_H
