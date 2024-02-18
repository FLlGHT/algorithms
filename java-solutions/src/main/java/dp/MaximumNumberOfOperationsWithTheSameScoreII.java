package dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author FLIGHT
 * <p>
 * 3040. Maximum Number of Operations With the Same Score II
 * Given an array of integers called nums, you can perform any of the following operation while nums contains at least 2 elements:
 * <p>
 * Choose the first two elements of nums and delete them.
 * Choose the last two elements of nums and delete them.
 * Choose the first and the last elements of nums and delete them.
 * The score of the operation is the sum of the deleted elements.
 * <p>
 * Your task is to find the maximum number of operations that can be performed, such that all operations have the same score.
 * <p>
 * Return the maximum number of operations possible that satisfy the condition mentioned above.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,1,2,3,4]
 * Output: 3
 * Explanation: We perform the following operations:
 * - Delete the first two elements, with score 3 + 2 = 5, nums = [1,2,3,4].
 * - Delete the first and the last elements, with score 1 + 4 = 5, nums = [2,3].
 * - Delete the first and the last elements, with score 2 + 3 = 5, nums = [].
 * We are unable to perform any more operations as nums is empty.
 * Example 2:
 * <p>
 * Input: nums = [3,2,6,1,4]
 * Output: 2
 * Explanation: We perform the following operations:
 * - Delete the first two elements, with score 3 + 2 = 5, nums = [6,1,4].
 * - Delete the last two elements, with score 1 + 4 = 5, nums = [6].
 * It can be proven that we can perform at most 2 operations.
 */
public class MaximumNumberOfOperationsWithTheSameScoreII {

  private int[] nums;

  public int maxOperations(int[] nums) {
    int size = nums.length;
    List<Integer> possibleSum = List.of(nums[0] + nums[1], nums[0] + nums[size - 1], nums[size - 1] + nums[size - 2]);

    this.nums = nums;

    int maxOperations = 0;
    for (int sum : new HashSet<>(possibleSum)) {
      maxOperations = Math.max(maxOperations, dp(0, nums.length - 1, sum, new HashMap<>()));
    }
    return maxOperations;
  }

  private int dp(int left, int right, int sum, Map<String, Integer> cache) {
    if (right <= left)
      return 0;

    String cacheValue = left + " " + right;
    if (cache.containsKey(cacheValue))
      return cache.get(cacheValue);

    int result = 0;

    if (nums[left] + nums[left + 1] == sum)
      result = Math.max(result, 1 + dp(left + 2, right, sum, cache));
    if (nums[left] + nums[right] == sum)
      result = Math.max(result, 1 + dp(left + 1, right - 1, sum, cache));
    if (nums[right] + nums[right - 1] == sum)
      result = Math.max(result, 1 + dp(left, right - 2, sum, cache));

    cache.put(cacheValue, result);
    return result;
  }
}
