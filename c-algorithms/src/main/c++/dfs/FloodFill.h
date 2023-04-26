//
// Created by fedorenko on 05.10.2022.
//

#ifndef C_ALGORITMS_FLOODFILL_H
#define C_ALGORITMS_FLOODFILL_H

#include <vector>

using namespace std;

/**
 * 733. Flood Fill
 *
 * <p>
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * You are also given three integers sr, sc, and color.
 * You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * <p>
 * To perform a flood fill, consider the starting pixel,
 * plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
 * plus any pixels connected 4-directionally to those pixels (also with the same color), and so on.
 * Replace the color of all of the aforementioned pixels with color.
 * <p>
 * Return the modified image after performing the flood fill.
 */

class FloodFill {

public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        if (image[sr][sc] != color)
            fillAround(image, sr, sc, image[sr][sc], color);

        return image;
    }

private:
    void fillAround(vector<vector<int>>& image, int sr, int sc, int current, int newColor) {
        if (sr < 0 || sr >= image.size() || sc < 0 || sc >= image[0].size() || image[sr][sc] != current)
            return;

        image[sr][sc] = newColor;

        fillAround(image, sr, sc - 1, current, newColor);
        fillAround(image, sr, sc + 1, current, newColor);
        fillAround(image, sr - 1, sc, current, newColor);
        fillAround(image, sr + 1, sc, current, newColor);
    }
};


#endif //C_ALGORITMS_FLOODFILL_H
