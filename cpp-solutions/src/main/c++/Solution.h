//
// Created by fedorenko on 26.09.2022.
//

#ifndef C_ALGORITMS_SOLUTION_H
#define C_ALGORITMS_SOLUTION_H


#include <iostream>
#include <vector>

using namespace std;

class Solution {

public:
    vector<int> successfulPairs(vector<int> &spells, vector<int> &potions, long long success) {
        sort(potions.begin(), potions.end());
        vector<int> result = vector<int>(spells.size());

        for (int i = 0; i < spells.size(); ++i) {
            long successFactor = (success + spells[i] - 1) / spells[i];
            int startPosition = binarySearch(potions, successFactor);
            result[i] = potions.size() - startPosition;
        }

        return result;
    }

private:
    int binarySearch(vector<int> &potions, long successFactor) {
        int left = 0, right = potions.size();

        while (left < right) {
            int middle = left + (right - left) / 2;

            if (potions[middle] < successFactor)
                left = middle + 1;
            else
                right = middle;
        }

        return right;
    }


};


#endif //C_ALGORITMS_SOLUTION_H
