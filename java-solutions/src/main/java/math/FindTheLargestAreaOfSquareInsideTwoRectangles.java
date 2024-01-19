package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FLIGHT
 * <p>
 * * 3047. Find the Largest Area of Square Inside Two Rectangles
 * *
 * * There exist n rectangles in a 2D plane.
 * * You are given two 0-indexed 2D integer arrays bottomLeft and topRight, both of size n x 2,
 * * where bottomLeft[i] and topRight[i] represent the bottom-left and top-right coordinates of the ith rectangle respectively.
 * <p>
 * You can select a region formed from the intersection of two of the given rectangles.
 * You need to find the largest area of a square that can fit inside this region if you select the region optimally.
 * <p>
 * Return the largest possible area of a square, or 0 if there do not exist any intersecting regions between the rectangles.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: bottomLeft = [[1,1],[2,2],[3,1]], topRight = [[3,3],[4,4],[6,6]]
 * Output: 1
 * Explanation: A square with side length 1 can fit inside either the intersecting region of rectangle 0 and rectangle 1,
 * or the intersecting region of rectangle 1 and rectangle 2. Hence the largest area is side * side which is 1 * 1 == 1.
 * It can be shown that a square with a greater side length can not fit inside any intersecting region.
 * Example 2:
 * <p>
 * <p>
 * Input: bottomLeft = [[1,1],[2,2],[1,2]], topRight = [[3,3],[4,4],[3,4]]
 * Output: 1
 * Explanation: A square with side length 1 can fit inside either the intersecting region of rectangle 0 and rectangle 1,
 * the intersecting region of rectangle 1 and rectangle 2, or the intersection region of all 3 rectangles.
 * Hence the largest area is side * side which is 1 * 1 == 1.
 * It can be shown that a square with a greater side length can not fit inside any intersecting region.
 * Note that the region can be formed by the intersection of more than 2 rectangles.
 * Example 3:
 * <p>
 * <p>
 * Input: bottomLeft = [[1,1],[3,3],[3,1]], topRight = [[2,2],[4,4],[4,2]]
 * Output: 0
 * Explanation: No pair of rectangles intersect, hence, we return 0.
 */
public class FindTheLargestAreaOfSquareInsideTwoRectangles {

  public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
    List<Rectangle> rectangles = createRectangles(bottomLeft, topRight);

    long largestArea = 0;
    for (int i = 0; i < rectangles.size(); ++i) {
      for (int j = i + 1; j < rectangles.size(); ++j) {
        long currentArea = squareIntersectionArea(rectangles.get(i), rectangles.get(j));
        largestArea = Math.max(largestArea, currentArea);
      }
    }

    return largestArea;
  }

  private List<Rectangle> createRectangles(int[][] bottomLeft, int[][] topRight) {
    List<Rectangle> rectangles = new ArrayList<>();
    for (int i = 0; i < bottomLeft.length; ++i) {
      Rectangle rectangle = new Rectangle(topRight[i][0], bottomLeft[i][0], topRight[i][1], bottomLeft[i][1]);
      rectangles.add(rectangle);
    }
    return rectangles;
  }


  public long squareIntersectionArea(Rectangle rectangle1, Rectangle rectangle2) {
    long xLength = Math.min(rectangle1.xMax(), rectangle2.xMax()) - Math.max(rectangle1.xMin(), rectangle2.xMin());
    long yLength = Math.min(rectangle1.yMax(), rectangle2.yMax()) - Math.max(rectangle1.yMin(), rectangle2.yMin());

    if (xLength <= 0 || yLength <= 0)
      return 0;

    long smallSide = Math.min(xLength, yLength);
    return smallSide * smallSide;
  }


  public record Rectangle(int xMax, int xMin, int yMax, int yMin) {
  }
}
