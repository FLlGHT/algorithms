package array;

/**
 * 2672. Number of Adjacent Elements With the Same Color
 * <p>
 * There is a 0-indexed array nums of length n. Initially, all elements are uncolored (has a value of 0).
 * <p>
 * You are given a 2D integer array queries where queries[i] = [indexi, colori].
 * <p>
 * For each query, you color the index indexi with the color colori in the array nums.
 * <p>
 * Return an array answer of the same length as queries where answer[i] is the number of adjacent elements with the same color after the ith query.
 * <p>
 * More formally, answer[i] is the number of indices j, such that 0 <= j < n - 1 and nums[j] == nums[j + 1] and nums[j] != 0 after the ith query.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 4, queries = [[0,2],[1,2],[3,1],[1,1],[2,1]]
 * Output: [0,1,1,0,2]
 * Explanation: Initially array nums = [0,0,0,0], where 0 denotes uncolored elements of the array.
 * - After the 1st query nums = [2,0,0,0]. The count of adjacent elements with the same color is 0.
 * - After the 2nd query nums = [2,2,0,0]. The count of adjacent elements with the same color is 1.
 * - After the 3rd query nums = [2,2,0,1]. The count of adjacent elements with the same color is 1.
 * - After the 4th query nums = [2,1,0,1]. The count of adjacent elements with the same color is 0.
 * - After the 5th query nums = [2,1,1,1]. The count of adjacent elements with the same color is 2.
 * Example 2:
 * <p>
 * Input: n = 1, queries = [[0,100000]]
 * Output: [0]
 * Explanation: Initially array nums = [0], where 0 denotes uncolored elements of the array.
 * - After the 1st query nums = [100000]. The count of adjacent elements with the same color is 0.
 */
public class NumberOfAdjacentElementsWithTheSameColor {

  public int[] colorTheArray(int n, int[][] queries) {
    int[] result = new int[queries.length];
    int[] colors = new int[n];

    int adjacentCount = 0, resultIndex = 0;

    for (int[] query : queries) {
      int index = query[0], currentColor = colors[index], newColor = query[1];

      if (newColor != currentColor) {
        if (index > 0 && currentColor > 0 && colors[index - 1] == currentColor)
          adjacentCount--;

        if (index < n - 1 && currentColor > 0 && colors[index + 1] == currentColor)
          adjacentCount--;

        if (index > 0 && colors[index - 1] == newColor)
          adjacentCount++;

        if (index < n - 1 && colors[index + 1] == newColor)
          adjacentCount++;
      }

      colors[index] = newColor;
      result[resultIndex++] = adjacentCount;
    }

    return result;
  }
}
