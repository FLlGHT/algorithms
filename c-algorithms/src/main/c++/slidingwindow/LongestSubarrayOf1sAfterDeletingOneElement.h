//
// Created by Michael Fedorenko on 26.04.2023.
//

#ifndef C_ALGORITHMS_LONGESTSUBARRAYOF1SAFTERDELETINGONEELEMENT_H
#define C_ALGORITHMS_LONGESTSUBARRAYOF1SAFTERDELETINGONEELEMENT_H
#include <iostream>
using namespace std;

/**
 * 1493. Longest Subarray of 1's After Deleting One Element
 *
 * Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array.
 Return 0 if there is no such subarray.



Example 1:

Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
Example 2:

Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
Example 3:

Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.
 */
class LongestSubarrayOf1sAfterDeletingOneElement {

public:
    int longestSubarray(vector<int>& nums) {
        int current = 0, longest = 0, indexOfLastZero = -1;

        for (int right = 0; right < nums.size(); ++right) {
            if (nums[right] == 1) {
                current++;
            }
            else {
                if (indexOfLastZero != -1)
                    current = right - indexOfLastZero;
                else
                    current++;

                indexOfLastZero = right;
            }

            longest = max(current, longest);
        }

        return longest - 1;
    }
};


#endif //C_ALGORITHMS_LONGESTSUBARRAYOF1SAFTERDELETINGONEELEMENT_H
