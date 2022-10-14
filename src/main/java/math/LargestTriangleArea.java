package math;


/**
 * 812. Largest Triangle Area
 *
 * Given an array of points on the X-Y plane points where points[i] = [xi, yi],
 * return the area of the largest triangle that can be formed by any three different points.
 * Answers within 10-5 of the actual answer will be accepted.
 *

 * Example 1:
 *
 *
 * Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * Output: 2.00000
 * Explanation: The five points are shown in the above figure. The red triangle is the largest.
 *
 *
 * Example 2:
 *
 * Input: points = [[1,0],[0,0],[0,1]]
 * Output: 0.50000
 */
public class LargestTriangleArea {

    public double largestTriangleArea(int[][] points) {
        double largestArea = 0.00;

        for (int first = 0; first < points.length - 2; ++first) {
            for (int second = first + 1; second < points.length - 1; ++second) {
                for (int third = second + 1; third < points.length; ++third) {
                    int[] firstPoint = points[first], secondPoint = points[second], thirdPoint = points[third];

                    double firstSide = Math.sqrt(Math.pow(firstPoint[0] - secondPoint[0], 2) + Math.pow(firstPoint[1] - secondPoint[1], 2));
                    double secondSide = Math.sqrt(Math.pow(secondPoint[0] - thirdPoint[0], 2) + Math.pow(secondPoint[1] - thirdPoint[1], 2));
                    double thirdSide = Math.sqrt(Math.pow(thirdPoint[0] - firstPoint[0], 2) + Math.pow(thirdPoint[1] - firstPoint[1], 2));

                    double semiPerimeter = (firstSide + secondSide + thirdSide) / 2;
                    double area = Math.sqrt(semiPerimeter * (semiPerimeter - firstSide) * (semiPerimeter - secondSide) * (semiPerimeter - thirdSide));

                    if (!Double.isNaN(area) && !Double.isInfinite(area))
                        largestArea = Math.max(area, largestArea);
                }
            }
        }

        return largestArea;
    }
}
