//
// Created by Michael Fedorenko on 23.02.2024.
//

#ifndef C_ALGORITHMS_MAXIMUMSUMCIRCULARSUBARRAY_H
#define C_ALGORITHMS_MAXIMUMSUMCIRCULARSUBARRAY_H

#include <vector>

using namespace std;

/*
 * 918. Maximum Sum Circular Subarray
 *
 * Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array.
 Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once.
 Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.



Example 1:

Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.
Example 2:

Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
Example 3:

Input: nums = [-3,-2,-3]
Output: -2
Explanation: Subarray [-2] has maximum sum -2.
 */
class MaximumSumCircularSubarray {


public:
    int maxSubarraySumCircular(vector<int> &nums) {
        int currentMin = 0, minSum = nums[0], currentMax = 0, maxSum = nums[0], totalSum = 0;

        for (auto &num: nums) {
            currentMax = max(currentMax, 0) + num;
            maxSum = max(maxSum, currentMax);

            currentMin = min(currentMin, 0) + num;
            minSum = min(minSum, currentMin);

            totalSum += num;
        }

        if (totalSum == minSum)
            return maxSum;

        return max(maxSum, totalSum - minSum);
    }
};


#endif //C_ALGORITHMS_MAXIMUMSUMCIRCULARSUBARRAY_H
