package array;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author FLIGHT

2965. Find Missing and Repeated Values

You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2].
Each integer appears exactly once except a which appears twice and b which is missing.
The task is to find the repeating and missing numbers a and b.

Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b.

Example 1:

Input: grid = [[1,3],[2,2]]
Output: [2,4]
Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,4].
Example 2:

Input: grid = [[9,1,7],[8,9,2],[3,4,6]]
Output: [9,5]
Explanation: Number 9 is repeated and number 5 is missing so the answer is [9,5].

 */
public class FindMissingAndRepeatedValues {

  public int[] findMissingAndRepeatedValues(int[][] grid) {
    Set<Integer> expectedValues = IntStream.range(1, grid.length * grid.length + 1).boxed().collect(Collectors.toSet());
    int repeated = Integer.MIN_VALUE;

    for (int[] row : grid) {
      for (int value : row) {
        if (!expectedValues.contains(value))
          repeated = value;
        else
          expectedValues.remove(value);
      }
    }
    return new int[]{repeated, expectedValues.iterator().next()};
  }
}
