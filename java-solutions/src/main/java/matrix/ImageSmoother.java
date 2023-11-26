package matrix;


/**
 * 661. Image Smoother
 * <p>
 * An image smoother is a filter of the size 3 x 3
 * that can be applied to each cell of an image by rounding down the average of the cell and the eight surrounding cells
 * (i.e., the average of the nine cells in the blue smoother).
 * If one or more of the surrounding cells of a cell is not present, we do not consider it in the average
 * (i.e., the average of the four cells in the red smoother).
 * <p>
 * Example 1:
 * <p>
 * Input: img = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[0,0,0],[0,0,0],[0,0,0]]
 * Explanation:
 * For the points (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the points (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: img = [[100,200,100],[200,50,200],[100,200,100]]
 * Output: [[137,141,137],[141,138,141],[137,141,137]]
 * Explanation:
 * For the points (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
 * For the points (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
 * For the point (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138
 */
public class ImageSmoother {

    public int[][] imageSmoother(int[][] image) {
        int[][] smoother = new int[image.length][image[0].length];

        for (int row = 0; row < smoother.length; ++row)
            for (int column = 0; column < smoother[0].length; ++column)
                smoother[row][column] = surroundingFloor(image, row, column);

        return smoother;
    }

    private int surroundingFloor(int[][] image, int row, int column) {
        int count = 0, sum = 0;

        for (int rowDifference = -1; rowDifference <= 1; ++rowDifference) {
            for (int columnDifference = -1; columnDifference <= 1; ++columnDifference) {
                int newRow = row + rowDifference, newColumn = column + columnDifference;

                if (newRow >= 0 && newRow < image.length && newColumn >= 0 && newColumn < image[0].length) {
                    sum += image[newRow][newColumn];
                    count++;
                }
            }
        }

        return (int) Math.floor(sum * 1.00 / count);
    }
}
