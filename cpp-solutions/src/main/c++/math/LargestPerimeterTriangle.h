//
// Created by fedorenko on 12.10.2022.
//

#ifndef C_ALGORITMS_LARGESTPERIMETERTRIANGLE_H
#define C_ALGORITMS_LARGESTPERIMETERTRIANGLE_H

#include <vector>

using namespace std;

/**
 * 976. Largest Perimeter Triangle
 * <p>
 * Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths.
 * If it is impossible to form any triangle of a non-zero area, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,1,2]
 * Output: 5
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,2,1]
 * Output: 0
 */
class LargestPerimeterTriangle {

public:
    int largestPerimeter(vector<int>& nums) {
        sort(nums.begin(), nums.end());

        for (int i = nums.size() - 3; i >= 0; i--) {
            if (nums[i + 2] < nums[i] + nums[i + 1])
                return nums[i] + nums[i + 1] + nums[i + 2];
        }

        return 0;
    }
};


#endif //C_ALGORITMS_LARGESTPERIMETERTRIANGLE_H
