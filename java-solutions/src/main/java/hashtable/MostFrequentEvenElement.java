package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 2404. Most Frequent Even Element
 * <p>
 * Given an integer array nums, return the most frequent even element.
 * <p>
 * If there is a tie, return the smallest one. If there is no such element, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,2,2,4,4,1]
 * Output: 2
 * Explanation:
 * The even elements are 0, 2, and 4. Of these, 2 and 4 appear the most.
 * We return the smallest one, which is 2.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [4,4,4,9,2,4]
 * Output: 4
 * Explanation: 4 is the even element appears the most.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [29,47,21,41,13,37,25,7]
 * Output: -1
 * Explanation: There is no even element.
 */
public class MostFrequentEvenElement {

    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        int smallest = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num % 2 == 0) {
                frequency.put(num, frequency.getOrDefault(num, 0) + 1);
                if (smallest == Integer.MAX_VALUE || frequency.get(num) > frequency.get(smallest) ||
                        (frequency.get(num).equals(frequency.get(smallest)) && num < smallest))
                    smallest = num;
            }
        }
        return smallest == Integer.MAX_VALUE ? -1 : smallest;
    }
}
