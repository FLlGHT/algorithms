package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 2461. Maximum Sum of Distinct Subarrays With Length K
 * <p>
 * You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:
 * <p>
 * The length of the subarray is k, and
 * All the elements of the subarray are distinct.
 * Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,5,4,2,9,9,9], k = 3
 * Output: 15
 * Explanation: The subarrays of nums with length 3 are:
 * - [1,5,4] which meets the requirements and has a sum of 10.
 * - [5,4,2] which meets the requirements and has a sum of 11.
 * - [4,2,9] which meets the requirements and has a sum of 15.
 * - [2,9,9] which does not meet the requirements because the element 9 is repeated.
 * - [9,9,9] which does not meet the requirements because the element 9 is repeated.
 * We return 15 because it is the maximum subarray sum of all the subarrays that meet the
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [4,4,4], k = 3
 * Output: 0
 * Explanation: The subarrays of nums with length 3 are:
 * - [4,4,4] which does not meet the requirements because the element 4 is repeated.
 * We return 0 because no subarrays meet the conditions.
 */
public class MaximumSumOfDistinctSubarraysWithLengthK {

    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0, currentSum = 0;

        Map<Integer, Integer> currentSubarray = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {

            if (i >= k) {
                int excludedValue = nums[i - k];
                currentSubarray.put(excludedValue, currentSubarray.get(excludedValue) - 1);
                if (currentSubarray.get(excludedValue) == 0)
                    currentSubarray.remove(excludedValue);

                currentSum -= excludedValue;
            }

            currentSubarray.put(nums[i], currentSubarray.getOrDefault(nums[i], 0) + 1);
            currentSum += nums[i];

            if (currentSubarray.size() == k)
                maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }
}
