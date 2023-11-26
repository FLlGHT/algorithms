//
// Created by fedorenko on 30.09.2022.
//

#ifndef C_ALGORITMS_LEFTMOSTCOLUMNWITHATLEASTAONE_H
#define C_ALGORITMS_LEFTMOSTCOLUMNWITHATLEASTAONE_H

#include <vector>

using namespace std;

class LeftmostColumnWithAtLeastAOne {

    class BinaryMatrix {
           public:
            int get(int row, int col);
             vector<int> dimensions();
         };

public:
    int leftMostColumnWithOne(BinaryMatrix &binaryMatrix) {
        vector<int> dimensions = binaryMatrix.dimensions();
        int rows = dimensions[0], columns = dimensions[1];
        int currentRow = 0, currentColumn = columns - 1;

        while (currentColumn >= 0 && currentRow < rows) {
            if (binaryMatrix.get(currentRow, currentColumn) == 1)
                currentColumn--;
            else
                currentRow++;
        }

        return currentColumn + 1 == columns ? -1 : currentColumn + 1;
    }
};


#endif //C_ALGORITMS_LEFTMOSTCOLUMNWITHATLEASTAONE_H
