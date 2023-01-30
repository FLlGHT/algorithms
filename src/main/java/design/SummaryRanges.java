package design;

import java.util.TreeMap;

/**
 * 352. Data Stream as Disjoint Intervals
 * <p>
 * Given a data stream input of non-negative integers a1, a2, ..., an, summarize the numbers seen so far as a list of disjoint intervals.
 * <p>
 * Implement the SummaryRanges class:
 * <p>
 * SummaryRanges() Initializes the object with an empty stream.
 * void addNum(int value) Adds the integer value to the stream.
 * int[][] getIntervals() Returns a summary of the integers in the stream currently as a list of disjoint intervals [starti, endi]. The answer should be sorted by starti.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
 * [[], [1], [], [3], [], [7], [], [2], [], [6], []]
 * Output
 * [null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
 * <p>
 * Explanation
 * SummaryRanges summaryRanges = new SummaryRanges();
 * summaryRanges.addNum(1);      // arr = [1]
 * summaryRanges.getIntervals(); // return [[1, 1]]
 * summaryRanges.addNum(3);      // arr = [1, 3]
 * summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
 * summaryRanges.addNum(7);      // arr = [1, 3, 7]
 * summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
 * summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
 * summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
 * summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
 * summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
 */
public class SummaryRanges {

  private final TreeMap<Integer, int[]> tree;


  public SummaryRanges() {
    tree = new TreeMap<>();
  }

  public void addNum(int value) {
    if (tree.containsKey(value))
      return;

    Integer lower = tree.lowerKey(value);
    Integer higher = tree.higherKey(value);

    if (lower != null && higher != null && tree.get(lower)[1] == value - 1 && tree.get(higher)[0] == value + 1) {
      tree.get(lower)[1] = tree.get(higher)[1];
      tree.remove(higher);
    } else if (lower != null && value <= tree.get(lower)[1] + 1) {
      tree.get(lower)[1] = Math.max(tree.get(lower)[1], value);
    } else if (higher != null && value == tree.get(higher)[0] - 1) {
      tree.put(value, new int[]{value, tree.get(higher)[1]});
      tree.remove(higher);
    } else
      tree.put(value, new int[]{value, value});
  }

  public int[][] getIntervals() {
    return tree.values().toArray(new int[0][0]);
  }
}
