package design;

import java.util.List;

/**
 * @author FLIGHT
 * <p>
 * 281. Zigzag Iterator
 * <p>
 * Given two vectors of integers v1 and v2, implement an iterator to return their elements alternately.
 * <p>
 * Implement the ZigzagIterator class:
 * <p>
 * ZigzagIterator(List<int> v1, List<int> v2) initializes the object with the two vectors v1 and v2.
 * boolean hasNext() returns true if the iterator still has elements, and false otherwise.
 * int next() returns the current element of the iterator and moves the iterator to the next element.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: v1 = [1,2], v2 = [3,4,5,6]
 * Output: [1,3,2,4,5,6]
 * Explanation: By calling next repeatedly until hasNext returns false,
 * the order of elements returned by next should be: [1,3,2,4,5,6].
 * Example 2:
 * <p>
 * Input: v1 = [1], v2 = []
 * Output: [1]
 * Example 3:
 * <p>
 * Input: v1 = [], v2 = [1]
 * Output: [1]
 */
public class ZigzagIterator {

  private final List<Integer> vector1;

  private final List<Integer> vector2;

  private int index1;

  private int index2;

  public ZigzagIterator(List<Integer> vector1, List<Integer> vector2) {
    this.vector1 = vector1;
    this.vector2 = vector2;
  }

  public int next() {
    if (index1 < vector1.size() && (index1 == index2 || index2 >= vector2.size()))
      return vector1.get(index1++);

    return vector2.get(index2++);
  }

  public boolean hasNext() {
    return index1 < vector1.size() || index2 < vector2.size();
  }
}
