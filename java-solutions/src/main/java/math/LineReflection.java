package math;

import java.util.HashSet;
import java.util.Set;

/**
 * @author FLIGHT
 *
 * 356. Line Reflection
 *
 * Given n points on a 2D plane,
 * find if there is such a line parallel to the y-axis that reflects the given points symmetrically.
 *
 * In other words, answer whether or not if there exists a line that after reflecting all points over the given line,
 * the original points' set is the same as the reflected ones.
 *
 * Note that there can be repeated points.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: points = [[1,1],[-1,1]]
 * Output: true
 * Explanation: We can choose the line x = 0.
 * Example 2:
 *
 *
 * Input: points = [[1,1],[-1,-1]]
 * Output: false
 * Explanation: We can't choose a line.
 */
public class LineReflection {

  public boolean isReflected(int[][] points) {
    Set<Point> uniquePoints = new HashSet<>();
    int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;

    for (int[] point : points) {
      uniquePoints.add(new Point(point[0], point[1]));

      minX = Math.min(minX, point[0]);
      maxX = Math.max(maxX, point[0]);
    }
    int doubleMiddle = maxX + minX;

    for (Point point : uniquePoints) {
      int x = point.x(), y = point.y();
      int reflectedX = doubleMiddle - x;

      if (!uniquePoints.contains(new Point(reflectedX, y)))
        return false;
    }

    return true;
  }

  private record Point(int x, int y) {
  }

}
