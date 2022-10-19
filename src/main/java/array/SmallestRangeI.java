package array;

/**
 * 908. Smallest Range I
 * <p>
 * You are given an integer array nums and an integer k.
 * <p>
 * In one operation, you can choose any index i
 * where 0 <= i < nums.length and change nums[i] to nums[i] + x where x is an integer from the range [-k, k].
 * You can apply this operation at most once for each index i.
 * <p>
 * The score of nums is the difference between the maximum and minimum elements in nums.
 * <p>
 * Return the minimum score of nums after applying the mentioned operation at most once for each index in it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1], k = 0
 * Output: 0
 * Explanation: The score is max(nums) - min(nums) = 1 - 1 = 0.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,10], k = 2
 * Output: 6
 * Explanation: Change nums to be [2, 8]. The score is max(nums) - min(nums) = 8 - 2 = 6.
 * <p>
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [1,3,6], k = 3
 * Output: 0
 * Explanation: Change nums to be [4, 4, 4]. The score is max(nums) - min(nums) = 4 - 4 = 0.
 */
public class SmallestRangeI {

    public int smallestRangeI(int[] nums, int k) {
        int min = nums[0] + k, max = nums[0] - k, smallestRange = 0;

        for (int num : nums) {
            max = Math.max(max, num - k);
            min = Math.min(min, num + k);

            smallestRange = Math.max(smallestRange, Math.max(0, max - min));
        }

        return smallestRange;
    }

}
