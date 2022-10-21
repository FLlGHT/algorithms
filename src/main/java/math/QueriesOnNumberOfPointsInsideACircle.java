package math;


/**
 * 1828. Queries on Number of Points Inside a Circle
 * <p>
 * You are given an array points where points[i] = [xi, yi] is the coordinates of the ith point on a 2D plane. Multiple points can have the same coordinates.
 * You are also given an array queries where queries[j] = [xj, yj, rj] describes a circle centered at (xj, yj) with a radius of rj.
 * For each query queries[j], compute the number of points inside the jth circle. Points on the border of the circle are considered inside.
 * Return an array answer, where answer[j] is the answer to the jth query.
 * <p>
 * Example 1:
 * <p>
 * Input: points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
 * Output: [3,2,2]
 * Explanation: The points and circles are shown above.
 * queries[0] is the green circle, queries[1] is the red circle, and queries[2] is the blue circle.
 * <p>
 * Example 2:
 * <p>
 * Input: points = [[1,1],[2,2],[3,3],[4,4],[5,5]], queries = [[1,2,2],[2,2,2],[4,3,2],[4,3,3]]
 * Output: [2,3,2,4]
 * Explanation: The points and circles are shown above.
 * queries[0] is green, queries[1] is red, queries[2] is blue, and queries[3] is purple.
 */
public class QueriesOnNumberOfPointsInsideACircle {

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] result = new int[queries.length];

        for (int i = 0; i < result.length; ++i) {
            int count = 0;
            int[] query = queries[i];
            for (int[] point : points)
                if (distance(point[0], point[1], query[0], query[1]) <= query[2])
                    count++;

            result[i] = count;
        }

        return result;
    }

    private double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }
}
