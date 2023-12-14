package array;

import java.util.Arrays;

/**
 * 2966. Divide Array Into Arrays With Max Difference
 * <p>
 * You are given an integer array nums of size n and a positive integer k.
 * <p>
 * Divide the array into one or more arrays of size 3 satisfying the following conditions:
 * <p>
 * Each element of nums should be in exactly one array.
 * The difference between any two elements in one array is less than or equal to k.
 * Return a 2D array containing all the arrays. If it is impossible to satisfy the conditions,
 * return an empty array. And if there are multiple answers, return any of them.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,4,8,7,9,3,5,1], k = 2
 * Output: [[1,1,3],[3,4,5],[7,8,9]]
 * Explanation: We can divide the array into the following arrays: [1,1,3], [3,4,5] and [7,8,9].
 * The difference between any two elements in each array is less than or equal to 2.
 * Note that the order of elements is not important.
 * Example 2:
 * <p>
 * Input: nums = [1,3,3,2,7,3], k = 3
 * Output: []
 * Explanation: It is not possible to divide the array satisfying all the conditions.
 */
public class DivideArrayIntoArraysWithMaxDifference {

  public int[][] divideArray(int[] nums, int k) {
    Arrays.sort(nums);
    int[][] result = new int[nums.length / 3][3];

    for (int index = 1; index < nums.length; index = index + 3) {
      int previous = nums[index - 1], current = nums[index], next = nums[index + 1];

      if (next - previous > k)
        return new int[][]{};
      else
        result[index / 3] = new int[]{previous, current, next};
    }
    return result;
  }
}
