//
// Created by Michael Fedorenko on 08.04.2023.
//

#ifndef C_ALGORITMS_MEDIANOFTWOSORTEDARRAYS_H
#define C_ALGORITMS_MEDIANOFTWOSORTEDARRAYS_H

#include <vector>

using namespace std;

/**
 * 4. Median of Two Sorted Arrays
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
class MedianOfTwoSortedArrays {

public:
    double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2) {
        vector<int> result(nums1.size() + nums2.size());

        for (int i = 0, firstIndex = 0, secondIndex = 0; i <= result.size() / 2; ++i) {
            int first = firstIndex < nums1.size() ? nums1[firstIndex] : INT_MAX;
            int second = secondIndex < nums2.size() ? nums2[secondIndex] : INT_MAX;

            if (first > second) {
                secondIndex++;
                result[i] = second;
            } else {
                firstIndex++;
                result[i] = first;
            }
        }

        return processResult(result);
    }

private:
    double processResult(vector<int> &result) {
        bool even = result.size() % 2 == 0;

        if (even)
            return (result[result.size() / 2] + result[result.size() / 2 - 1]) / 2.0;
        else
            return result[result.size() / 2] * 1.0;
    }
};


#endif //C_ALGORITMS_MEDIANOFTWOSORTEDARRAYS_H
