package backtracking;

import java.util.*;

/**
 * 491. Non-decreasing Subsequences
 * <p>
 * Given an integer array nums,
 * return all the different possible non-decreasing subsequences of the given array with at least two elements.
 * You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,6,7,7]
 * Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * Example 2:
 * <p>
 * Input: nums = [4,4,3,2,1]
 * Output: [[4,4]]
 */
public class NonDecreasingSubsequences {

  public List<List<Integer>> findSubsequences(int[] nums) {
    List<List<Integer>> subsequences = new ArrayList<>();
    backtracking(subsequences, new LinkedList<>(), nums, 0);

    return subsequences;
  }

  private void backtracking(List<List<Integer>> subsequences, LinkedList<Integer> subsequence, int[] nums, int index) {
    if (subsequence.size() >= 2)
      subsequences.add(new LinkedList<>(subsequence));

    Set<Integer> used = new HashSet<>();

    for (int i = index; i < nums.length; ++i) {
      if (!used.contains(nums[i]) && (subsequence.size() == 0 || nums[i] >= subsequence.peekLast())) {
        subsequence.add(nums[i]);
        used.add(nums[i]);
        backtracking(subsequences, subsequence, nums, i + 1);
        subsequence.pollLast();
      }
    }
  }
}
