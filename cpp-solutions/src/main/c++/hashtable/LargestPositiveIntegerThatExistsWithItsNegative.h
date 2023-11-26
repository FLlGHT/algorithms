//
// Created by Michael Fedorenko on 16.10.2022.
//

#ifndef C_ALGORITMS_LARGESTPOSITIVEINTEGERTHATEXISTSWITHITSNEGATIVE_H
#define C_ALGORITMS_LARGESTPOSITIVEINTEGERTHATEXISTSWITHITSNEGATIVE_H
using namespace std;
#import "vector";
#import "unordered_set"

/**
 * 2441. Largest Positive Integer That Exists With Its Negative
 *
 * Given an integer array nums that does not contain any zeros,
 * find the largest positive integer k such that -k also exists in the array.

Return the positive integer k. If there is no such integer, return -1.



Example 1:

Input: nums = [-1,2,-3,3]
Output: 3
Explanation: 3 is the only valid k we can find in the array.
Example 2:

Input: nums = [-1,10,6,7,-7,1]
Output: 7
Explanation: Both 1 and 7 have their corresponding negative values in the array. 7 has a larger value.
Example 3:

Input: nums = [-10,8,6,7,-2,-3]
Output: -1
Explanation: There is no a single valid k, we return -1.
 */
class LargestPositiveIntegerThatExistsWithItsNegative {

public:
    int findMaxK(vector<int>& nums) {
        unordered_set<int> numbers;
        int maximum = -1;
        for (const auto &num: nums) {
            if (numbers.find(-num) != numbers.end())
                maximum = max(maximum, abs(num));

            numbers.insert(num);
        }

        return maximum;
    }
};


#endif //C_ALGORITMS_LARGESTPOSITIVEINTEGERTHATEXISTSWITHITSNEGATIVE_H
