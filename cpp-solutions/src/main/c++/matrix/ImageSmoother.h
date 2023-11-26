//
// Created by fedorenko on 17.10.2022.
//

#ifndef C_ALGORITMS_IMAGESMOOTHER_H
#define C_ALGORITMS_IMAGESMOOTHER_H

#include <vector>
#include <cmath>

using namespace std;


/**
 * 661. Image Smoother
 *
 * An image smoother is a filter of the size 3 x 3
 * that can be applied to each cell of an image by rounding down the average of the cell and the eight surrounding cells
 * (i.e., the average of the nine cells in the blue smoother).
 * If one or more of the surrounding cells of a cell is not present,
 * we do not consider it in the average (i.e., the average of the four cells in the red smoother).

Given an m x n integer matrix img representing the grayscale of an image, return the image after applying the smoother on each cell of it.

Example 1:

Input: img = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[0,0,0],[0,0,0],[0,0,0]]
Explanation:
For the points (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the points (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0


Example 2:

Input: img = [[100,200,100],[200,50,200],[100,200,100]]
Output: [[137,141,137],[141,138,141],[137,141,137]]
Explanation:
For the points (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
For the points (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
For the point (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138
 */
class ImageSmoother {

public:
    vector<vector<int>> imageSmoother(vector<vector<int>> &image) {
        vector<vector<int>> smoother(image.size(), vector<int>(image[0].size()));

        for (int row = 0; row < smoother.size(); ++row)
            for (int column = 0; column < smoother[0].size(); ++column)
                smoother[row][column] = surroundingFloor(image, row, column);

        return smoother;
    }

private:
    int surroundingFloor(vector<vector<int>> &image, int row, int column) {
        int count = 0, sum = 0;

        for (int rowDifference = -1; rowDifference <= 1; ++rowDifference) {
            for (int columnDifference = -1; columnDifference <= 1; ++columnDifference) {
                int newRow = row + rowDifference, newColumn = column + columnDifference;

                if (newRow >= 0 && newRow < image.size() && newColumn >= 0 && newColumn < image[0].size()) {
                    sum += image[newRow][newColumn];
                    count++;
                }
            }
        }

        return (int) floor(sum * 1.00 / count);
    }
};


#endif //C_ALGORITMS_IMAGESMOOTHER_H
