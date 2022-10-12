package math;

import java.util.Arrays;

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
public class LargestPerimeterTriangle {

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for (int i = nums.length - 3; i >= 0; i--) {
            if (nums[i] + nums[i + 1] > nums[i + 2])
                return nums[i] + nums[i + 1] + nums[i + 2];
        }
        return 0;
    }
}
