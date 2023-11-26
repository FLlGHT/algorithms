//
// Created by fedorenko on 29.09.2022.
//

#ifndef C_ALGORITMS_WIDESTPAIROFINDICESWITHEQUALRANGESUM_H
#define C_ALGORITMS_WIDESTPAIROFINDICESWITHEQUALRANGESUM_H

#include <vector>
#include <unordered_map>

using namespace std;

/**
 * 1983. Widest Pair of Indices With Equal Range Sum
 * <p>
 * You are given two 0-indexed binary arrays nums1 and nums2.
 * Find the widest pair of indices (i, j) such that i <= j and
 * nums1[i] + nums1[i+1] + ... + nums1[j] == nums2[i] + nums2[i+1] + ... + nums2[j].
 * <p>
 * The widest pair of indices is the pair with the largest distance between i and j.
 * The distance between a pair of indices is defined as j - i + 1.
 * <p>
 * Return the distance of the widest pair of indices. If no pair of indices meets the conditions, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,1,0,1], nums2 = [0,1,1,0]
 * Output: 3
 * Explanation:
 * If i = 1 and j = 3:
 * nums1[1] + nums1[2] + nums1[3] = 1 + 0 + 1 = 2.
 * nums2[1] + nums2[2] + nums2[3] = 1 + 1 + 0 = 2.
 * The distance between i and j is j - i + 1 = 3 - 1 + 1 = 3.
 * Example 2:
 * <p>
 * Input: nums1 = [0,1], nums2 = [1,1]
 * Output: 1
 * Explanation:
 * If i = 1 and j = 1:
 * nums1[1] = 1.
 * nums2[1] = 1.
 * The distance between i and j is j - i + 1 = 1 - 1 + 1 = 1.
 * Example 3:
 * <p>
 * Input: nums1 = [0], nums2 = [1]
 * Output: 0
 * Explanation:
 * There are no pairs of indices that meet the requirements.
 */
class WidestPairOfIndicesWithEqualRangeSum {

public:
    int widestPairOfIndices(vector<int>& nums1, vector<int>& nums2) {
        int widest = 0;
        unordered_map<int, int> differenceToIndex;
        for (int i = 0; i < nums1.size(); ++i) {
            if (i > 0) {
                nums1[i] = nums1[i - 1] + nums1[i];
                nums2[i] = nums2[i - 1] + nums2[i];
            }

            int difference = nums2[i] - nums1[i];

            if (differenceToIndex.find(difference) != differenceToIndex.end())
                widest = max(widest, i - differenceToIndex[difference]);
            else if (difference == 0)
                widest = max(widest, i + 1);
            else
                differenceToIndex[difference] = i;
        }

        return widest;
    }
};


#endif //C_ALGORITMS_WIDESTPAIROFINDICESWITHEQUALRANGESUM_H
